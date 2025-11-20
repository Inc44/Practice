-- 2
ALTER TABLE
	detailscommandes
ADD
	CONSTRAINT fk_detailscommandes_produitId FOREIGN KEY (produitId) REFERENCES produits (produitId) ON UPDATE CASCADE;