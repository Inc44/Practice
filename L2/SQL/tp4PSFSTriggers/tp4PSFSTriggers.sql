-- 2a
DELIMITER
$$
CREATE
OR REPLACE PROCEDURE inscrire_participant(
	IN p_congresid INT,
	IN p_participantid INT
)
BEGIN
DECLARE
v_count INT;
DECLARE
v_id INT;
SELECT
	COUNT(*) INTO v_count
FROM
	inscription
WHERE
	congresid = p_congresid
	AND participantid = p_participantid;
IF v_count > 0 THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
ELSE
SELECT
	IFNULL(MAX(inscriptionid), 0) + 1 INTO v_id -- inscriptionid is not AUTO_INCREMENT
FROM
	inscription
WHERE
	congresid = p_congresid;
INSERT INTO
	inscription (
		congresid,
		inscriptionid,
		participantid,
		dateinscription,
		etat
	)
VALUES
	(
		p_congresid,
		v_id,
		p_participantid,
		CURDATE(),
		'VALIDE'
	);
SELECT
	v_id AS message;
END IF;
END
$$
DELIMITER;
-- ` ;` instead of `;`
-- 2b
CALL inscrire_participant(2, 2);
CALL inscrire_participant(2, 2);
CALL inscrire_participant(2, 24);
-- 3a
SELECT
	personneid,
	nom,
	prenom,
	COUNT(articleid)
FROM
	auteur
	JOIN rediger ON personneid = auteurid
GROUP BY
	personneid,
	nom,
	prenom;
-- 3b
DELIMITER
$$
CREATE
OR REPLACE FUNCTION nombre_articles(p_auteurid INT) RETURNS INT
BEGIN
DECLARE
v_count INT;
SELECT
	COUNT(articleid) INTO v_count
FROM
	rediger
WHERE
	auteurid = p_auteurid;
RETURN v_count;
END
$$
DELIMITER;
-- ` ;` instead of `;`
-- 3c
SELECT
	personneid,
	nom,
	prenom,
	nombre_articles(personneid)
FROM
	auteur;
-- 4a
DELIMITER
$$
CREATE
OR REPLACE TRIGGER congres_date_insert BEFORE
INSERT
	ON congres FOR EACH ROW
BEGIN
IF NEW.datedebut > NEW.datefin THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
END
$$
DELIMITER;
-- ` ;` instead of `;`
-- 4b
DELIMITER
$$
CREATE
OR REPLACE TRIGGER congres_date_update BEFORE
UPDATE
	ON congres FOR EACH ROW
BEGIN
IF NEW.datedebut > NEW.datefin THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
END
$$
DELIMITER;
-- ` ;` instead of `;`
-- 4c
INSERT INTO
	congres (
		domaineid,
		batimentid,
		nom,
		datedebut,
		datefin,
		prixSejourHT
	)
VALUES
	(
		1,
		10,
		'ICPR',
		'2025-12-31',
		'2025-07-05',
		750
	);
UPDATE
	congres
SET
	datedebut = '2025-12-31'
WHERE
	congresid = 1;
-- 4d
ALTER TABLE
	congres
ADD
	CONSTRAINT chk_congres_date CHECK (datedebut <= datefin);
-- Standard declarative method, simpler and more optimized than triggers
-- 5
DELIMITER
$$
CREATE
OR REPLACE TRIGGER session_date_insert BEFORE
INSERT
	ON session FOR EACH ROW
BEGIN
DECLARE
v_datedebut DATE;
DECLARE
v_datefin DATE;
DECLARE
CONTINUE HANDLER FOR NOT FOUND
BEGIN
SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END;
SELECT
	datedebut,
	datefin INTO v_datedebut,
	v_datefin
FROM
	congres
WHERE
	congresid = NEW.congresid;
IF DATE(NEW.datehrsession) NOT BETWEEN v_datedebut AND v_datefin THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
END
$$
CREATE
OR REPLACE TRIGGER session_date_update BEFORE
UPDATE
	ON session FOR EACH ROW
BEGIN
DECLARE
v_datedebut DATE;
DECLARE
v_datefin DATE;
DECLARE
CONTINUE HANDLER FOR NOT FOUND
BEGIN
SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END;
SELECT
	datedebut,
	datefin INTO v_datedebut,
	v_datefin
FROM
	congres
WHERE
	congresid = NEW.congresid;
IF DATE(NEW.datehrsession) NOT BETWEEN v_datedebut AND v_datefin THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
END
$$
DELIMITER;
-- ` ;` instead of `;`
INSERT INTO
	session (
		congresid,
		articleid,
		chairmanid,
		datehrsession,
		duree
	)
VALUES
	(1, 1, 27, '2025-12-31 08:00:00', 60);
UPDATE
	session
SET
	datehrsession = '2025-12-31 08:00:00'
WHERE
	congresid = 1
	AND articleid = 1;
-- 6a
DELIMITER
$$
CREATE
OR REPLACE TRIGGER participant_insert BEFORE
INSERT
	ON participant FOR EACH ROW
BEGIN
INSERT INTO
	personne (nom, prenom, email)
VALUES
	(NEW.nom, NEW.prenom, NEW.email);
SET
	NEW.personneid = LAST_INSERT_ID();
END
$$
DELIMITER;
-- ` ;` instead of `;`
-- 6b
DELIMITER
$$
CREATE
OR REPLACE TRIGGER participant_update BEFORE
UPDATE
	ON participant FOR EACH ROW
BEGIN
UPDATE
	personne
SET
	nom = NEW.nom,
	prenom = NEW.prenom,
	email = NEW.email
WHERE
	personneid = OLD.personneid;
END
$$
DELIMITER;
-- ` ;` instead of `;`
-- 6c
DELIMITER
$$
CREATE
OR REPLACE TRIGGER participant_delete
AFTER
	DELETE ON participant FOR EACH ROW
BEGIN
DELETE FROM
	personne
WHERE
	personneid = OLD.personneid;
END
$$
DELIMITER;
-- ` ;` instead of `;`
-- 6d
INSERT INTO
	participant (
		villeid,
		noemployeur,
		adresse,
		nom,
		prenom,
		email
	)
VALUES
	(
		14522,
		1,
		'17 bd heurteloup',
		'DUPONT',
		'Pierre',
		'pierre.dupont@test.fr'
	);
SELECT
	*
FROM
	personne
WHERE
	email = 'pierre.dupont@test.fr';
UPDATE
	participant
SET
	nom = 'DURAND'
WHERE
	email = 'pierre.dupont@test.fr';
SELECT
	*
FROM
	personne
WHERE
	email = 'pierre.dupont@test.fr';
DELETE FROM
	participant
WHERE
	email = 'pierre.dupont@test.fr';
SELECT
	*
FROM
	personne
WHERE
	email = 'pierre.dupont@test.fr';
-- 7a
ALTER TABLE
	auteur
ADD
	nbArt INT(11) NOT NULL DEFAULT 0;
-- 7b
DELIMITER
$$
CREATE
OR REPLACE TRIGGER rediger_insert
AFTER
INSERT
	ON rediger FOR EACH ROW
BEGIN
UPDATE
	auteur
SET
	nbArt = nbArt + 1
WHERE
	personneid = NEW.auteurid;
END
$$
CREATE
OR REPLACE TRIGGER rediger_update
AFTER
UPDATE
	ON rediger FOR EACH ROW
BEGIN
IF OLD.auteurid != NEW.auteurid THEN
UPDATE
	auteur
SET
	nbArt = nbArt - 1
WHERE
	personneid = OLD.auteurid;
UPDATE
	auteur
SET
	nbArt = nbArt + 1
WHERE
	personneid = NEW.auteurid;
END IF;
END
$$
CREATE
OR REPLACE TRIGGER rediger_delete
AFTER
	DELETE ON rediger FOR EACH ROW
BEGIN
UPDATE
	auteur
SET
	nbArt = nbArt - 1
WHERE
	personneid = OLD.auteurid;
END
$$
DELIMITER;
-- ` ;` instead of `;`
-- 7c
UPDATE
	auteur
SET
	nbArt = (
		SELECT
			COUNT(*)
		FROM
			rediger
		WHERE
			auteurid = personneid
	);
-- 8a
DELIMITER
$$
CREATE
OR REPLACE TRIGGER presenter_insert BEFORE
INSERT
	ON presenter FOR EACH ROW
BEGIN
DECLARE
v_count INT;
SELECT
	COUNT(*) INTO v_count
FROM
	assister
WHERE
	participantid = NEW.participantid
	AND nosession = NEW.nosession;
IF v_count = 0 THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
END
$$
CREATE
OR REPLACE TRIGGER presenter_update BEFORE
UPDATE
	ON presenter FOR EACH ROW
BEGIN
DECLARE
v_count INT;
SELECT
	COUNT(*) INTO v_count
FROM
	assister
WHERE
	participantid = NEW.participantid
	AND nosession = NEW.nosession;
IF v_count = 0 THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
END
$$
DELIMITER;
-- ` ;` instead of `;`
INSERT INTO
	presenter (participantid, nosession)
VALUES
	(2, 1);
-- 8b
DELIMITER
$$
CREATE
OR REPLACE TRIGGER assister_delete BEFORE DELETE ON assister FOR EACH ROW
BEGIN
DECLARE
v_count INT;
SELECT
	COUNT(*) INTO v_count
FROM
	presenter
WHERE
	participantid = OLD.participantid
	AND nosession = OLD.nosession;
IF v_count > 0 THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
END
$$
CREATE
OR REPLACE TRIGGER assister_update BEFORE
UPDATE
	ON assister FOR EACH ROW
BEGIN
DECLARE
v_count INT;
SELECT
	COUNT(*) INTO v_count
FROM
	presenter
WHERE
	participantid = OLD.participantid
	AND nosession = OLD.nosession;
IF v_count > 0 THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
END
$$
DELIMITER;
-- ` ;` instead of `;`
DELETE FROM
	assister
WHERE
	participantid = 1
	AND nosession = 3;
UPDATE
	assister
SET
	nosession = 4
WHERE
	participantid = 1
	AND nosession = 3;
-- 9
DELIMITER
$$
CREATE
OR REPLACE TRIGGER session_insert BEFORE
INSERT
	ON session FOR EACH ROW
BEGIN
IF NEW.chairmanid IS NOT NULL THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
END
$$
CREATE
OR REPLACE TRIGGER session_update BEFORE
UPDATE
	ON session FOR EACH ROW
BEGIN
DECLARE
v_count INT;
IF NEW.chairmanid IS NOT NULL THEN
SELECT
	COUNT(*) INTO v_count
FROM
	presenter
WHERE
	participantid = NEW.chairmanid
	AND nosession = NEW.nosession;
IF v_count = 0 THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
END IF;
END
$$
DELIMITER;
-- ` ;` instead of `;`
INSERT INTO
	session (
		congresid,
		articleid,
		chairmanid,
		datehrsession,
		duree
	)
VALUES
	(1, 1, 27, '2025-07-01 08:00:00', 60);
UPDATE
	session
SET
	chairmanid = 27
WHERE
	nosession = 10;