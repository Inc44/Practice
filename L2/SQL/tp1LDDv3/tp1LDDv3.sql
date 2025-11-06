-- 1
CREATE DATABASE eaux;
USE eaux;
-- 2
CREATE TABLE substance (
	substanceId INT AUTO_INCREMENT PRIMARY KEY,
	libelle VARCHAR(100) NOT NULL,
	qteMax FLOAT DEFAULT 0,
	CONSTRAINT chk_substance_qteMax CHECK (qteMax >= 0)
);
-- Insertion of 'Lisier' fails. Constraint `chk_qteMax` requires `qteMax` more than 0; therefore, -100 violates this constraint.
-- 3
CREATE TABLE technicien (
	technicienId INT AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(100) NOT NULL,
	prenom VARCHAR(100) NOT NULL,
	CONSTRAINT uq_technicien_nom_prenom UNIQUE (nom, prenom),
	CONSTRAINT chk_technicien_nom_prenom CHECK (nom <> prenom)
);
SELECT
	*
FROM
	technicien
WHERE
	nom IS NULL
	OR prenom IS NULL;
SELECT
	nom,
	prenom,
	COUNT(*)
FROM
	technicien
GROUP BY
	nom,
	prenom
HAVING
	COUNT(*) > 1;
SELECT
	*
FROM
	technicien
WHERE
	nom = prenom;
-- 4
CREATE TABLE analyseeau (
	analyseEauId INT AUTO_INCREMENT PRIMARY KEY,
	captageId INT,
	reservoirId INT,
	technicienId INT,
	dateAnalyse DATE NOT NULL,
	CONSTRAINT fk_technicien_technicienId FOREIGN KEY (technicienId) REFERENCES technicien(technicienId) ON DELETE
	SET
		NULL ON UPDATE CASCADE
);
-- 5
CREATE TABLE captage (
	captageId INT AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(100) NOT NULL,
	debitMax FLOAT NOT NULL,
	CONSTRAINT chk_captage_debitMax CHECK (debitMax >= 0)
);
SELECT
	*
FROM
	captage
WHERE
	debitMax < 0;
-- 6
CREATE TABLE reservoir (
	reservoirId INT AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(100) NOT NULL,
	capaciteMax INT NOT NULL,
	hauteurMin FLOAT,
	hauteurMax FLOAT,
	pression FLOAT,
	typeReservoir VARCHAR(20),
	tempsRemplissageMin INT,
	debitGroupe INT,
	CONSTRAINT chk_reservoir_capaciteMax CHECK (capaciteMax >= 0),
	CONSTRAINT chk_reservoir_hauteur CHECK (hauteurMin <= hauteurMax)
);
UPDATE
	reservoir
SET
	typeReservoir = 'aérien'
WHERE
	nom LIKE 'RA%';
UPDATE
	reservoir
SET
	typeReservoir = 'enterré'
WHERE
	nom LIKE 'RE%';
UPDATE
	reservoir
SET
	typeReservoir = 'inconnu'
WHERE
	nom NOT LIKE 'RA%'
	AND nom NOT LIKE 'RE%';
ALTER TABLE
	reservoir
MODIFY
	typeReservoir VARCHAR(20) NOT NULL;
ALTER TABLE
	reservoir
ADD
	CONSTRAINT chk_reservoir_typeReservoir CHECK (
		typeReservoir IN ('aérien', 'enterré', 'inconnu')
	);
SELECT
	*
FROM
	reservoir
WHERE
	typeReservoir NOT IN ('aérien', 'enterré', 'inconnu');
-- 7a
CREATE INDEX idx_reservoirId ON analyseeau(reservoirId);
-- 7b
CREATE INDEX idx_captageId ON analyseeau(captageId);
-- 7c
ALTER TABLE
	analyseeau
ADD
	CONSTRAINT fk_analyseEau_reservoirId FOREIGN KEY (reservoirId) REFERENCES reservoir(reservoirId) ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE
	analyseeau
ADD
	CONSTRAINT fk_analyseEau_captageId FOREIGN KEY (captageId) REFERENCES captage(captageId) ON DELETE RESTRICT ON UPDATE CASCADE;
-- 7d
ALTER TABLE
	analyseeau
ADD
	CONSTRAINT chk_analyseEau_reservoirId CHECK (reservoirId IS NOT NULL);
-- 7e
ALTER TABLE
	analyseeau
ADD
	CONSTRAINT chk_analyseEau_captageId_reservoirId CHECK (
		(
			captageId IS NOT NULL
			AND reservoirId IS NULL
		)
		OR (
			captageId IS NULL
			AND reservoirId IS NOT NULL
		)
	);
SELECT
	*
FROM
	analyseeau
WHERE
	technicienId IS NULL;
SELECT
	*
FROM
	analyseeau
WHERE
	(
		captageId IS NOT NULL
		AND reservoirId IS NOT NULL
	)
	OR (
		captageId IS NULL
		AND reservoirId IS NULL
	);
-- 8
CREATE TABLE releve (
	analyseEauId INT NOT NULL,
	substanceId INT NOT NULL,
	qteReleve FLOAT NOT NULL,
	CONSTRAINT pk_releve_analyseEauId_substanceId PRIMARY KEY (analyseEauId, substanceId),
	CONSTRAINT fk_releve_analyseEauId FOREIGN KEY (analyseEauId) REFERENCES analyseeau(analyseEauId),
	CONSTRAINT fk_releve_substanceId FOREIGN KEY (substanceId) REFERENCES substance(substanceId),
	CONSTRAINT chk_releve_qteReleve CHECK (qteReleve > 0)
);
-- 9
DROP TABLE reservoir;
-- Cannot delete or update a parent row: a foreign key constraint fails due to `reservoir` using `fk_analyseEau_reservoirId` in table `analyseeau`