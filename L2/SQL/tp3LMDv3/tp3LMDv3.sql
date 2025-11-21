-- 2
ALTER TABLE
	detailscommandes
ADD
	CONSTRAINT fk_detailscommandes_produitId FOREIGN KEY (produitId) REFERENCES produits (produitId) ON UPDATE CASCADE;
-- 3
SELECT
	nom,
	'client' AS type
FROM
	clients
UNION
SELECT
	nom,
	'fournisseur' AS type
FROM
	fournisseurs
UNION
SELECT
	nom,
	'transporteur' AS type
FROM
	transporteurs
ORDER BY
	type,
	nom;
-- 4
SELECT
	nom,
	ville,
	Pays
FROM
	clients
EXCEPT
SELECT
	nom,
	ville,
	Pays
FROM
	clients c
	JOIN commandes co ON c.clientId = co.clientId
ORDER BY
	nom;
-- 5
SELECT
	nom,
	nomContact,
	adresse,
	ville,
	Pays
FROM
	clients
INTERSECT
SELECT
	nom,
	nomContact,
	adresse,
	ville,
	pays
FROM
	fournisseurs;
SELECT
	c.nom,
	c.nomContact,
	c.adresse,
	c.ville,
	c.Pays
FROM
	clients c
	JOIN fournisseurs f ON c.nom = f.nom
	AND c.nomContact = f.nomContact;
-- 6
SELECT
	'2025 Nombre de clients différents qui ont commandé' AS type,
	COUNT(DISTINCT clientId) AS value
FROM
	commandes
WHERE
	YEAR(dateCommande) = 2025
UNION
SELECT
	'2025 Nombre total de commandes' AS type,
	COUNT(commandeId) AS value
FROM
	commandes
WHERE
	YEAR(dateCommande) = 2025
UNION
SELECT
	'2025 Ventes totales' AS type,
	SUM(quantite * prix) AS value
FROM
	commandes c
	JOIN detailscommandes d ON c.commandeId = d.commandeId
	JOIN produits p ON d.produitId = p.produitId
WHERE
	YEAR(dateCommande) = 2025;
-- 7
SELECT
	nom,
	prenom
FROM
	employes
WHERE
	employeId NOT IN (
		SELECT
			DISTINCT responsableId
		FROM
			commandes co
			JOIN clients c ON co.clientId = c.clientId
		WHERE
			Pays = 'France'
	);
SELECT
	nom,
	prenom
FROM
	employes
WHERE
	NOT EXISTS (
		SELECT
			1
		FROM
			commandes co
			JOIN clients c ON co.clientId = c.clientId
		WHERE
			responsableId = employeId
			AND Pays = 'France'
	);
SELECT
	nom,
	prenom
FROM
	employes
EXCEPT
SELECT
	e.nom,
	prenom
FROM
	employes e
	JOIN commandes co ON employeId = responsableId
	JOIN clients c ON co.clientId = c.clientId
WHERE
	Pays = 'France';
SELECT
	e.nom,
	prenom
FROM
	employes e
	LEFT JOIN (
		SELECT
			DISTINCT responsableId
		FROM
			commandes co
			JOIN clients c ON co.clientId = c.clientId
		WHERE
			Pays = 'France'
	) AS commandes_france ON employeId = commandes_france.responsableId
WHERE
	commandes_france.responsableId IS NULL;
-- 8
SELECT
	p.libelle,
	prix,
	c.libelle,
	(
		SELECT
			AVG(prix)
		FROM
			produits p2
		WHERE
			p2.categorieId = p.categorieId
	)
FROM
	produits p
	JOIN categories c ON p.categorieId = c.categorieId
WHERE
	prix > (
		SELECT
			AVG(prix)
		FROM
			produits p2
		WHERE
			p2.categorieId = p.categorieId
	);
-- 9
SELECT
	nom,
	COUNT(DISTINCT co.commandeId),
	SUM(quantite * prix)
FROM
	clients c
	JOIN commandes co ON c.clientId = co.clientId
	JOIN detailscommandes d ON co.commandeId = d.commandeId
	JOIN produits p ON d.produitId = p.produitId
GROUP BY
	nom
ORDER BY
	SUM(quantite * prix) DESC
LIMIT
	5;
-- 10
SELECT
	nom,
	MAX(dateCommande),
	DATEDIFF(CURDATE(), MAX(dateCommande)),
	COUNT(commandeId)
FROM
	clients c
	JOIN commandes co ON c.clientId = co.clientId
GROUP BY
	nom
HAVING
	DATEDIFF(CURDATE(), MAX(dateCommande)) >= 730
ORDER BY
	DATEDIFF(CURDATE(), MAX(dateCommande)) DESC;
-- 11
SELECT
	c.libelle,
	MONTHNAME(dateCommande),
	YEAR(dateCommande),
	SUM(quantite * prix)
FROM
	categories c
	JOIN produits p ON c.categorieId = p.categorieId
	JOIN detailscommandes d ON p.produitId = d.produitId
	JOIN commandes co ON d.commandeId = co.commandeId
WHERE
	YEAR(dateCommande) = 2025
GROUP BY
	c.libelle,
	MONTHNAME(dateCommande),
	YEAR(dateCommande);
-- 12
SELECT
	nom,
	COUNT(commandeId),  -- 5 instead of 7 for La maison d'Asie
	DENSE_RANK() OVER (
		ORDER BY
			COUNT(commandeId) DESC -- Otherwise, rank 5 instead of 4 for La maison d'Asie
	)
FROM
	clients c
	JOIN commandes co ON c.clientId = co.clientId
GROUP BY
	nom
ORDER BY
	COUNT(commandeId) DESC;
-- 13
SELECT
	nom,
	commandeId,
	dateCommande,
	ROW_NUMBER() OVER (
		PARTITION BY c.clientId
		ORDER BY
			dateCommande
	)
FROM
	clients c
	JOIN commandes co ON c.clientId = co.clientId
ORDER BY
	nom,
	dateCommande;
-- 14
SELECT
	libelle,
	c.commandeId,
	dateCommande,
	quantite,
	SUM(quantite) OVER (
		PARTITION BY p.produitId
		ORDER BY
			dateCommande,
			c.commandeId
	)
FROM
	produits p
	JOIN detailscommandes d ON p.produitId = d.produitId
	JOIN commandes c ON d.commandeId = c.commandeId
ORDER BY
	libelle,
	c.commandeId;
-- 15
SELECT
	nom,
	commandeId,
	dateCommande,
	LAG(dateCommande, 1) OVER (
		PARTITION BY c.clientId
		ORDER BY
			dateCommande
	),
	LEAD(dateCommande, 1) OVER (
		PARTITION BY c.clientId
		ORDER BY
			dateCommande
	),
	DATEDIFF(
		dateCommande,
		LAG(dateCommande, 1) OVER (
			PARTITION BY c.clientId
			ORDER BY
				dateCommande
		)
	)
FROM
	clients c
	JOIN commandes co ON c.clientId = co.clientId
ORDER BY
	nom,
	dateCommande;
-- 16
SELECT
	*
FROM
	(
		SELECT
			c.libelle AS clibelle,
			p.libelle AS plibelle,
			SUM(quantite),
			DENSE_RANK() OVER (
				PARTITION BY c.libelle
				ORDER BY
					SUM(quantite) DESC
			) AS rang
		FROM
			categories c
			JOIN produits p ON c.categorieId = p.categorieId
			JOIN detailscommandes d ON p.produitId = d.produitId
		GROUP BY
			c.libelle,
			p.libelle
	) AS classement
WHERE
	rang <= 3
ORDER BY
	clibelle,
	rang;
-- 17
SELECT
	DISTINCT nom,
	FIRST_VALUE(dateCommande) OVER (
		PARTITION BY c.clientId
		ORDER BY
			dateCommande ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
	),
	LAST_VALUE(dateCommande) OVER (
		PARTITION BY c.clientId
		ORDER BY
			dateCommande ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
	),
	COUNT(commandeId) OVER (PARTITION BY c.clientId)
FROM
	clients c
	JOIN commandes co ON c.clientId = co.clientId;
-- 18
WITH chiffre_affaire AS (
	SELECT
		nom,
		Pays,
		SUM(quantite * prix) AS montant
	FROM
		clients c
		JOIN commandes co ON c.clientId = co.clientId
		JOIN detailscommandes d ON co.commandeId = d.commandeId
		JOIN produits p ON d.produitId = p.produitId
	GROUP BY
		nom,
		Pays
)
SELECT
	nom,
	Pays,
	montant,
	(
		SELECT
			AVG(montant)
		FROM
			chiffre_affaire
	)
FROM
	chiffre_affaire
WHERE
	montant > (
		SELECT
			AVG(montant)
		FROM
			chiffre_affaire
	);
-- 19
WITH tiers AS (
	SELECT
		nom,
		pays
	FROM
		fournisseurs
	UNION
	SELECT
		nom,
		pays
	FROM
		clients
)
SELECT
	pays,
	COUNT(*)
FROM
	tiers
GROUP BY
	pays
ORDER BY
	pays;
-- 20
WITH moyenne AS (
	SELECT
		p.libelle AS plibelle,
		prix,
		c.libelle AS clibelle,
		AVG(prix) OVER (PARTITION BY c.categorieId) AS moyen
	FROM
		produits p
		JOIN categories c ON p.categorieId = c.categorieId
)
SELECT
	plibelle,
	prix,
	clibelle,
	moyen
FROM
	moyenne
WHERE
	prix > moyen;
-- 21
WITH stats AS (
	SELECT
		nom,
		COUNT(commandeId) AS commandes,
		MIN(dateCommande) AS premiere,
		MAX(dateCommande) AS derniere,
		DATEDIFF(MAX(dateCommande), MIN(dateCommande)) AS duree
	FROM
		clients c
		JOIN commandes co ON c.clientId = co.clientId
	GROUP BY
		nom
)
SELECT
	nom,
	commandes,
	premiere,
	derniere,
	duree
FROM
	stats
WHERE
	commandes > 5
	AND duree >= 1095;
-- 6 records instead of 8
-- 22
WITH ventes AS (
	SELECT
		YEAR(dateCommande) AS annee,
		QUARTER(dateCommande) AS trimestre,
		COUNT(DISTINCT c.commandeId) AS commandes,
		SUM(quantite * prix) AS montant
	FROM
		commandes c
		JOIN detailscommandes d ON c.commandeId = d.commandeId
		JOIN produits p ON d.produitId = p.produitId
	GROUP BY
		YEAR(dateCommande),
		QUARTER(dateCommande)
)
SELECT
	annee,
	trimestre,
	commandes,
	montant,
	LAG(montant, 1) OVER (
		ORDER BY
			annee,
			trimestre
	) AS montant_precedent,
	montant - LAG(montant, 1) OVER (
		ORDER BY
			annee,
			trimestre
	) AS difference
FROM
	ventes
ORDER BY
	annee DESC,
	trimestre DESC;
-- 23
-- TODO