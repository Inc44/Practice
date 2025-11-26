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