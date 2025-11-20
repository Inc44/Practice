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