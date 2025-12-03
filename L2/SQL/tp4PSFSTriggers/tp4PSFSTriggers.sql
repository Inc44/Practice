-- 2a
DELIMITER
$$
CREATE
OR REPLACE PROCEDURE inscrire_participant(
	IN p_congresid INT,
	IN p_participantid INT,
	IN p_dateinscription DATE
)
BEGIN
DECLARE
v_count INT;
DECLARE
v_id INT;
DECLARE
v_date DATE;
SET
	v_date = IFNULL(p_dateinscription, CURDATE());
SELECT
	COUNT(*) INTO v_count
FROM
	congres
WHERE
	congresid = p_congresid;
IF v_count = 0 THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
SELECT
	COUNT(*) INTO v_count
FROM
	participant
WHERE
	personneid = p_participantid;
IF v_count = 0 THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
SELECT
	COUNT(*) INTO v_count
FROM
	inscription
WHERE
	congresid = p_congresid
	AND participantid = p_participantid
	AND etat = 'VALIDE';
IF v_count > 0 THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
END IF;
SELECT
	COUNT(*) INTO v_count
FROM
	inscription
WHERE
	congresid = p_congresid
	AND participantid = p_participantid
	AND etat = 'ANNULE';
IF v_count > 0 THEN
UPDATE
	inscription
SET
	dateinscription = v_date,
	etat = 'VALIDE'
WHERE
	congresid = p_congresid
	AND participantid = p_participantid;
SELECT
	CONCAT('Modification ', p_participantid) AS message;
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
		v_date,
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
CALL inscrire_participant(2, 2, NULL);
CALL inscrire_participant(2, 2, NULL);
CALL inscrire_participant(2, 24, NULL);
DELETE FROM
	inscription
WHERE
	congresid = 4
	AND participantid = 35;
CALL inscrire_participant(4, 35, '2025-09-10');
CALL inscrire_participant(4, 23, '2025-09-10');
CALL inscrire_participant(4, 24, '2025-09-10');
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
-- 10a
DELIMITER
$$
CREATE
OR REPLACE PROCEDURE programme_congres(IN p_congresid INT)
BEGIN
DECLARE
v_count INT;
SELECT
	COUNT(*) INTO v_count
FROM
	congres
WHERE
	congresid = p_congresid;
IF v_count = 0 THEN SIGNAL SQLSTATE '45000'
SET
	MESSAGE_TEXT = 'Erreur';
ELSE
SELECT
	(
		SELECT
			COUNT(*)
		FROM
			session
		WHERE
			congresid = p_congresid
	),
	nosession,
	datehrsession,
	duree,
	titre,
	nom,
	prenom
FROM
	session s
	JOIN article a ON s.articleid = a.articleid
	LEFT JOIN participant ON chairmanid = personneid
WHERE
	congresid = p_congresid
ORDER BY
	datehrsession;
END IF;
END
$$
DELIMITER;
-- ` ;` instead of `;`
-- 10b
CALL programme_congres(1);
-- 11a
DELIMITER
$$
CREATE
OR REPLACE FUNCTION nombre_sessions(p_congresid INT) RETURNS INT
BEGIN
DECLARE
v_count INT;
SELECT
	COUNT(*) INTO v_count
FROM
	session
WHERE
	congresid = p_congresid;
RETURN v_count;
END
$$
DELIMITER;
-- ` ;` instead of `;`
-- 11b
SELECT
	congresid,
	nombre_sessions(congresid)
FROM
	congres
WHERE
	YEAR(datedebut) = 2025
	OR YEAR(datefin) = 2025;
-- 12a
DELIMITER
$$
CREATE
OR REPLACE FUNCTION personne_identite(p_personneid INT) RETURNS VARCHAR(161)
BEGIN
DECLARE
v_identite VARCHAR(161);
SELECT
	CONCAT(UPPER(nom), ' ', prenom) INTO v_identite
FROM
	personne
WHERE
	personneid = p_personneid;
RETURN v_identite;
END
$$
DELIMITER;
-- ` ;` instead of `;`
-- 12b
SELECT
	DISTINCT personne_identite(personneid)
FROM
	participant
	JOIN assister a ON personneid = participantid
	JOIN session s ON a.nosession = s.nosession
	JOIN congres c ON s.congresid = c.congresid
WHERE
	c.nom = 'ICPR';
-- 13a
DELIMITER
$$
CREATE
OR REPLACE TRIGGER auteur_insert BEFORE
INSERT
	ON auteur FOR EACH ROW
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
INSERT INTO
	auteur (telephone, nom, prenom, email)
VALUES
	(
		'1425789124',
		'AZERTY',
		'Stephane',
		'stephane.qwerty@univ-tours.fr'
	);
SELECT
	*
FROM
	personne
WHERE
	email = 'stephane.qwerty@univ-tours.fr';
-- 13b
DELIMITER
$$
CREATE
OR REPLACE TRIGGER auteur_update
AFTER
UPDATE
	ON auteur FOR EACH ROW
BEGIN
UPDATE
	personne
SET
	nom = NEW.nom,
	prenom = NEW.prenom,
	email = NEW.email
WHERE
	personneid = NEW.personneid;
END
$$
DELIMITER;
-- ` ;` instead of `;`
UPDATE
	auteur
SET
	nom = 'QWERTY'
WHERE
	email = 'stephane.qwerty@univ-tours.fr';
SELECT
	*
FROM
	personne
WHERE
	email = 'stephane.qwerty@univ-tours.fr';
-- 13c
DELIMITER
$$
CREATE
OR REPLACE TRIGGER auteur_delete
AFTER
	DELETE ON auteur FOR EACH ROW
BEGIN
DELETE FROM
	personne
WHERE
	personneid = OLD.personneid;
END
$$
DELIMITER;
-- ` ;` instead of `;`
DELETE FROM
	auteur
WHERE
	email = 'stephane.qwerty@univ-tours.fr';
SELECT
	*
FROM
	personne
WHERE
	email = 'stephane.qwerty@univ-tours.fr';
-- 14
CREATE TABLE IF NOT EXISTS historisation (
	articleid INT(11),
	themeid INT(11),
	typeid INT(11),
	titre VARCHAR(100),
	contenu TEXT,
	nbsignes INT(11),
	personneid INT(11),
	telephone VARCHAR(20),
	nom VARCHAR(80),
	prenom VARCHAR(80),
	email VARCHAR(255),
	datearchivage DATETIME
);
DELIMITER
$$
CREATE
OR REPLACE TRIGGER article_delete BEFORE DELETE ON article FOR EACH ROW
BEGIN
DECLARE
done INT DEFAULT FALSE;
DECLARE
v_auteurid INT;
DECLARE
v_count INT;
DECLARE
cur_auteurs CURSOR FOR
SELECT
	auteurid
FROM
	rediger
WHERE
	articleid = OLD.articleid;
DECLARE
CONTINUE HANDLER FOR NOT FOUND
SET
	done = TRUE;
INSERT INTO
	historisation (
		articleid,
		themeid,
		typeid,
		titre,
		contenu,
		nbsignes,
		personneid,
		telephone,
		nom,
		prenom,
		email,
		datearchivage
	)
SELECT
	OLD.articleid,
	OLD.themeid,
	OLD.typeid,
	OLD.titre,
	OLD.contenu,
	OLD.nbsignes,
	personneid,
	telephone,
	nom,
	prenom,
	email,
	NOW()
FROM
	auteur
	JOIN rediger ON personneid = auteurid
WHERE
	articleid = OLD.articleid;
DELETE FROM
	assister
WHERE
	nosession IN (
		SELECT
			nosession
		FROM
			session
		WHERE
			articleid = OLD.articleid
	);
DELETE FROM
	presenter
WHERE
	nosession IN (
		SELECT
			nosession
		FROM
			session
		WHERE
			articleid = OLD.articleid
	);
DELETE FROM
	session
WHERE
	articleid = OLD.articleid;
OPEN cur_auteurs;
auteur_loop: LOOP FETCH cur_auteurs INTO v_auteurid;
IF done THEN LEAVE auteur_loop;
END IF;
DELETE FROM
	rediger
WHERE
	articleid = OLD.articleid
	AND auteurid = v_auteurid;
SELECT
	COUNT(*) INTO v_count
FROM
	rediger
WHERE
	auteurid = v_auteurid;
IF v_count = 0 THEN
DELETE FROM
	auteur
WHERE
	personneid = v_auteurid;
END IF;
END LOOP;
CLOSE cur_auteurs;
END
$$
DELIMITER;
-- ` ;` instead of `;`
DELETE FROM
	article
WHERE
	articleid = 7;
SELECT
	*
FROM
	historisation
WHERE
	articleid = 7;