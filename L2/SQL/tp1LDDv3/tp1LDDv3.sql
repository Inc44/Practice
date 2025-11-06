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
-- Fails for MariaDB 10.11.14
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
-- Fails for MariaDB 10.11.14
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
-- 10
SELECT
	DISTINCT c.nom
FROM
	captage c
	INNER JOIN analyseeau a ON c.captageId = a.captageId
WHERE
	a.dateAnalyse BETWEEN '2018-01-01' AND '2018-12-31'
	AND c.nom LIKE '%AAC%'
ORDER BY
	c.nom;
-- 11
SELECT
	DISTINCT r.reservoirId,
	r.capaciteMax
FROM
	reservoir r
	INNER JOIN analyseeau a ON r.reservoirId = a.reservoirId
	INNER JOIN releve re ON a.analyseEauId = re.analyseEauId
	INNER JOIN substance s ON re.substanceId = s.substanceId
WHERE
	r.typeReservoir = 'enterré'
	AND r.capaciteMax > 15000
	AND s.libelle = 'Nitrates'
	AND re.qteReleve > 20;
-- 12
SELECT
	DISTINCT c.nom
FROM
	captage c
	INNER JOIN analyseeau a ON c.captageId = a.captageId
	INNER JOIN releve re ON a.analyseEauId = re.analyseEauId
	INNER JOIN substance s ON re.substanceId = s.substanceId
WHERE
	c.nom LIKE 'AAC%'
	AND s.libelle = 'Atrazine'
	AND re.qteReleve < 0.065
	AND a.dateAnalyse BETWEEN '2019-01-01' AND '2019-12-31';
-- 13
SELECT
	DISTINCT t.nom,
	t.prenom,
	a.dateAnalyse,
	r.nom
FROM
	technicien t
	INNER JOIN analyseeau a ON t.technicienId = a.technicienId
	INNER JOIN reservoir r ON a.reservoirId = r.reservoirId
WHERE
	a.reservoirId IN (
		SELECT
			a.reservoirId
		FROM
			analyseeau a
			INNER JOIN technicien t ON a.technicienId = t.technicienId
		WHERE
			t.nom = 'LABAT'
			AND t.prenom = 'ALEXANDRA'
	)
	AND NOT (
		t.nom = 'LABAT'
		AND t.prenom = 'ALEXANDRA'
	);
-- 14
SELECT
	c.nom,
	COUNT(a.analyseEauId)
FROM
	captage c
	INNER JOIN analyseeau a ON c.captageId = a.captageId
GROUP BY
	c.nom
HAVING
	COUNT(a.analyseEauId) < 3;
-- 15
SELECT
	libelle
FROM
	substance
WHERE
	substanceId NOT IN (
		SELECT
			DISTINCT substanceId
		FROM
			releve
	);
SELECT
	s.libelle
FROM
	substance s
	LEFT JOIN releve r ON s.substanceId = r.substanceId
WHERE
	r.analyseEauId IS NULL;
-- 6 records instead of 4
-- 16
SELECT
	s.libelle,
	r.qteReleve,
	s.qteMax,
	a.dateAnalyse
FROM
	substance s
	LEFT JOIN releve r ON s.substanceId = r.substanceId
	LEFT JOIN analyseeau a ON r.analyseEauId = a.analyseEauId
ORDER BY
	s.libelle;
-- 17
SELECT
	MONTH(a.dateAnalyse),
	AVG(r.qteReleve)
FROM
	releve r
	INNER JOIN substance s ON r.substanceId = s.substanceId
	INNER JOIN analyseeau a ON r.analyseEauId = a.analyseEauId
	INNER JOIN reservoir re ON a.reservoirId = re.reservoirId
WHERE
	s.libelle = 'Nitrates'
	AND a.dateAnalyse BETWEEN '2019-01-01' AND '2019-12-31'
	AND re.typeReservoir = 'enterré'
	AND re.capaciteMax < 20000
GROUP BY
	MONTH(a.dateAnalyse)
ORDER BY
	1;
-- 20000 instead of 10000
-- 18
SELECT
	t.nom,
	t.prenom,
	COUNT(*)
FROM
	technicien t
	INNER JOIN analyseeau a ON t.technicienId = a.technicienId
GROUP BY
	t.nom,
	t.prenom
HAVING
	COUNT(*) >= ALL (
		SELECT
			COUNT(*)
		FROM
			analyseeau
		GROUP BY
			technicienId
	);
-- 19
SELECT
	s.libelle,
	COUNT(r.analyseEauId)
FROM
	substance s
	INNER JOIN releve r ON s.substanceId = r.substanceId
GROUP BY
	s.libelle
HAVING
	COUNT(r.analyseEauId) <= ALL (
		SELECT
			COUNT(r.analyseEauId)
		FROM
			substance s
			INNER JOIN releve r ON s.substanceId = r.substanceId
		GROUP BY
			s.substanceId
	);
-- 20
SELECT
	r.nom,
	COUNT(DISTINCT a.technicienId)
FROM
	reservoir r
	INNER JOIN analyseeau a ON r.reservoirId = a.reservoirId
WHERE
	r.typeReservoir = 'enterré'
	AND a.dateAnalyse BETWEEN '2018-07-01' AND '2018-12-31'
GROUP BY
	r.reservoirId,
	r.nom;
-- 21
ALTER TABLE
	technicien
ADD
	telephone VARCHAR(20);
ALTER TABLE
	technicien
ADD
	email VARCHAR(100);
ALTER TABLE
	technicien
ADD
	CONSTRAINT chk_technicien_email CHECK (
		email IS NULL
		OR email LIKE '%@%'
	);
-- 22
ALTER TABLE
	analyseeau
ADD
	commentaire VARCHAR(250) NULL;
-- 23
CREATE INDEX idx_technicien_nom_prenom ON technicien(nom, prenom);