-- 2a
ALTER TABLE
	inscription
MODIFY
	inscriptionid INT(11) NOT NULL AUTO_INCREMENT;
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
INSERT INTO
	inscription (congresid, participantid, dateinscription, etat)
VALUES
	(
		p_congresid,
		p_participantid,
		CURDATE(),
		'VALIDE'
	);
SET
	v_id = LAST_INSERT_ID();
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