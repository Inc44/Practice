-- 1
SELECT
	firstPlace
FROM
	A_GROUPS
WHERE
	cup = 2010;
-- 2
SELECT
	firstPlace
FROM
	A_GROUPS
WHERE
	cup = 2010
UNION
SELECT
	secondPlace
FROM
	A_GROUPS
WHERE
	cup = 2010;
-- 3
SELECT
	firstPlace,
	secondPlace,
	thirdPlace,
	fourthPlace
FROM
	A_GROUPS
WHERE
	cup = 2010
	AND groupId = 'H';
-- 4
SELECT
	groupId
FROM
	A_GROUPS
WHERE
	cup = 2010
	AND (
		firstPlace = 'France'
		OR secondPlace = 'France'
		OR thirdPlace = 'France'
		OR fourthPlace = 'France'
	);
-- 5
SELECT
	groupId
FROM
	A_GROUPS g
	INNER JOIN A_TOP t ON t.cup = g.cup
WHERE
	g.cup = 2010
	AND (
		firstPlace = host
		OR secondPlace = host
		OR g.thirdPlace = host
		OR g.fourthPlace = host
	);
-- 6
SELECT
	team1,
	team2
FROM
	A_MATCHES
WHERE
	matchDate = '22/6';
-- 7
SELECT
	team1
FROM
	A_MATCHES
WHERE
	matchDate = '22/6'
	AND goals NOT LIKE '0%'
UNION
SELECT
	team2
FROM
	A_MATCHES
WHERE
	matchDate = '22/6'
	AND goals NOT LIKE '0%';
-- 8
SELECT
	team1
FROM
	A_MATCHES
WHERE
	matchDate = '22/6'
	AND LEFT(goals, 1) > RIGHT(goals, 1)
UNION
SELECT
	team2
FROM
	A_MATCHES
WHERE
	matchDate = '22/6'
	AND LEFT(goals, 1) < RIGHT(goals, 1);
-- 9
SELECT
	team1
FROM
	A_MATCHES
WHERE
	LEFT(goals, 1) > 3
UNION
SELECT
	team2
FROM
	A_MATCHES
WHERE
	RIGHT(goals, 1) > 3;
-- 10
SELECT
	SUBSTRING_INDEX(stadium, ',', -1)
FROM
	A_MATCHES
WHERE
	team1 = 'France'
	OR team2 = 'France';
-- 11
SELECT
	DISTINCT winner
FROM
	A_TOP
WHERE
	winner is NOT NULL;
-- 12
SELECT
	DISTINCT t.winner
FROM
	A_TOP t
	INNER JOIN A_TOP t2 ON t.winner = t2.host
WHERE
	t.winner is NOT NULL;