-- 1 OK
-- 2
SELECT
	nom,
	prenom
FROM
	personne
EXCEPT
SELECT
	nom,
	prenom
FROM
	personne p
	JOIN possede po ON p.personneid = po.personneid
	JOIN logement l ON po.logementid = l.logementid;
-- 3 OK
SELECT
	nom,
	(
		SELECT
			COUNT(logementid)
		FROM
			logement l
			JOIN ville v2 ON l.villeid = v2.villeid
		WHERE
			v2.villeid = v.villeid
	)
FROM
	ville v
WHERE
	codepostal LIKE '38%'
	AND (
		SELECT
			COUNT(logementid)
		FROM
			logement l
			JOIN ville v2 ON l.villeid = v2.villeid
		WHERE
			v2.villeid = v.villeid
	) >= 3;
-- 4 OK
SELECT
	nom,
	prenom,
	dateagrement
FROM
	agent
WHERE
	personneid NOT IN (
		SELECT
			d.personneid
		FROM
			agent a
			JOIN diagnostique d ON a.personneid = d.personneid
	);
SELECT
	nom,
	prenom,
	dateagrement
FROM
	agent
EXCEPT
SELECT
	nom,
	prenom,
	dateagrement
FROM
	agent a
	JOIN diagnostique d ON a.personneid = d.personneid;
SELECT
	nom,
	prenom,
	dateagrement
FROM
	agent a
	LEFT JOIN diagnostique d ON a.personneid = d.personneid
WHERE
	d.personneid IS NULL;
-- 5 OK
SELECT
	nom,
	surface
FROM
	ville v
	JOIN logement l ON v.villeid = l.villeid
WHERE
	surface = (
		SELECT
			MIN(surface)
		FROM
			logement
	);
-- 6 OK
SELECT
	'Nombre de logement et surface moyenne' AS type,
	COUNT(logementid) AS n,
	AVG(surface) AS s
FROM
	logement
UNION
SELECT
	'Nombre d appartements et surface moyenne' AS type,
	COUNT(logementid) AS n,
	AVG(surface) AS s
FROM
	appartement
UNION
SELECT
	'Nombre de maisons et surface moyenne' AS type,
	COUNT(logementid) AS n,
	AVG(surface) AS s
FROM
	maison;
-- 7
SELECT
	nom,
	prenom,
	RANK() OVER (
		PARTITION BY nom
		ORDER BY
			surface DESC -- otherwise, highest rank for smallest surface area instead of largest
	) as rang,
	m.logementid,
	surface
FROM
	agent a
	JOIN gere g ON a.personneid = g.personneid
	JOIN maison m ON g.logementid = m.logementid
ORDER BY
	nom,
	surface DESC;
-- otherwise, highest rank for smallest surface area instead of largest
-- 8 OK
SELECT
	logementid,
	adresse,
	nom,
	surface,
	NTILE(5) OVER (
		ORDER BY
			surface DESC
	) as quintileSurface
FROM
	appartement a
	JOIN ville v ON a.villeid = v.villeid;
-- 9
WITH stats AS (
	SELECT
		nom AS ville,
		energie AS classeEnergie,
		COUNT(d.logementid) AS nbLogements,
		AVG(surface) AS surfaceMoyenne,
		COUNT(d.logementid) AS nbTotalLogementsDiagnostiques
	FROM
		diagnostique d
		JOIN logement l ON d.logementid = l.logementid
		JOIN ville v ON l.villeid = v.villeid
	GROUP BY
		nom
)
SELECT
	ville,
	classeEnergie,
	nbLogements,
	surfaceMoyenne,
	nbTotalLogementsDiagnostiques
FROM
	stats
ORDER BY
	ville,
	classeEnergie;
-- 10
WITH stats AS (
	SELECT
		nom AS ville,
		CASE
			WHEN COUNT(surface) >= 100 THEN '3-Grand (>100m2)'
			WHEN COUNT(surface) >= 50 THEN '2-Moyen (50-100m2)'
			ELSE '1-Petit (<50m2)'
		END AS tranche,
		COUNT(logementid) AS nbLogements,
		AVG(surface) AS surfaceMoyenne
	FROM
		logement l
		JOIN ville v ON l.villeid = v.villeid
	WHERE
		codepostal LIKE '37%'
	GROUP BY
		nom
)
SELECT
	ville,
	tranche,
	nbLogements,
	surfaceMoyenne
FROM
	stats
ORDER BY
	ville,
	tranche;
-- 11a
DELIMITER
$$
CREATE
OR REPLACE FUNCTION surface_total(p_logementid INT) RETURNS FLOAT
BEGIN
DECLARE
v_sum_terrasse FLOAT;
DECLARE
v_sum_balcon FLOAT;
DECLARE
v_sum_terrain FLOAT;
SELECT
	SUM(surfaceterrasse),
	SUM(surfacebalcon) INTO v_sum_terrasse,
	v_sum_balcon
FROM
	appartement
WHERE
	logementid = p_logementid;
SELECT
	SUM(surfaceterrain) INTO v_sum_terrain
FROM
	maison
WHERE
	logementid = p_logementid;
SET
	v_sum_terrasse = IFNULL(v_sum_terrasse, 0);
SET
	v_sum_balcon = IFNULL(v_sum_balcon, 0);
SET
	v_sum_terrain = IFNULL(v_sum_terrain, 0);
RETURN v_sum_terrasse + v_sum_balcon + v_sum_terrain;
END
$$
DELIMITER;
-- ` ;` instead of `;`
SELECT
	surface_total(logementid)
FROM
	appartement;
SELECT
	surface_total(logementid)
FROM
	maison;
-- 11b
SELECT
	'appartement' AS type,
	surface_total(logementid)
FROM
	appartement
WHERE
	surface_total(logementid) BETWEEN 50 AND 200
UNION
ALL
SELECT
	'maison' AS type,
	surface_total(logementid)
FROM
	maison
WHERE
	surface_total(logementid) BETWEEN 50 AND 200;
-- 11c
-- 12a
-- 12b