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