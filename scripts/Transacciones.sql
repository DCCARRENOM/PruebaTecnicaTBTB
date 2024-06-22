-- SCRIPT LLENADO (INSERTS)
INSERT INTO clients VALUES (1065420942, 'Juan', 'Rodriguez', 'calle 70 #1-28');
INSERT INTO clients VALUES (1951736268, 'Sebastián', 'Morales', 'calle 22 #2-30');
INSERT INTO clients VALUES (1987321658, 'Laura', 'Gomez', 'calle 10 #1-10');
INSERT INTO clients VALUES (1654951753, 'Sonia', 'Garcia', 'calle 15 #2-28');
INSERT INTO clients VALUES (1321159874, 'Carlos', 'Hernandez', 'calle 20a #1-07');
INSERT INTO clients VALUES (1684215937, 'Patricia', 'Reyes', 'calle 22a #2-15');

INSERT INTO orders(idClient,total,orderDate) VALUES (1951736268,150000,TO_DATE('15/05/2024','DD/MM/YYYY'));
INSERT INTO orders(idClient,total,orderDate) VALUES (1654951753,20000,TO_DATE('20/06/2024','DD/MM/YYYY'));
INSERT INTO orders(idClient,total,orderDate) VALUES (1987321658,10000,TO_DATE('20/05/2024','DD/MM/YYYY'));
INSERT INTO orders(idClient,total,orderDate) VALUES (1321159874,25000,TO_DATE('21/06/2024','DD/MM/YYYY'));
INSERT INTO orders(idClient,total,orderDate) VALUES (1321159874,15000,TO_DATE('10/05/2024','DD/MM/YYYY'));

INSERT INTO product (productName,price,stock) VALUES ('Cereal Kellogs', 5000, 50);
INSERT INTO product (productName,price,stock) VALUES ('Chocoramo', 2500, 100);
INSERT INTO product (productName,price,stock) VALUES ('Arroz blanco', 10000, 200);
INSERT INTO product (productName,price,stock) VALUES ('Huevo Rojo', 15000, 25);
INSERT INTO product (productName,price,stock) VALUES ('Atun', 5000, 50);
INSERT INTO product (productName,price,stock) VALUES ('Queso', 3000, 50);

-- Productos orden 1
INSERT INTO order_product VALUES (1,3,13);
INSERT INTO order_product VALUES (1,2,4);
INSERT INTO order_product VALUES (1,5,2);

-- Productos orden 2
INSERT INTO order_product VALUES (2,2,2);
INSERT INTO order_product VALUES (2,4,1);

-- Productos orden 3
INSERT INTO order_product VALUES (3,5,2);

-- Productos orden 4
INSERT INTO order_product VALUES (4,2,2);
INSERT INTO order_product VALUES (4,4,1);
INSERT INTO order_product VALUES (4,5,1);

-- Productos orden 5 
INSERT INTO order_product VALUES (5,1,2);
INSERT INTO order_product VALUES (5,2,2);

-- Consultas (SELECTS)
-- Consulta que lista todos los clientes y cuantas compras han realizado
SELECT clients.id, clients.clientName, clients.lastName, COUNT(orders.id) as ComprasRealizadas
FROM clients
LEFT JOIN orders ON clients.id = orders.idClient
GROUP BY clients.id
ORDER BY ComprasRealizadas DESC

-- Consulta que lista unicamente aquellos productos que han sido comprados 
SELECT product.id, product.productName, COUNT(order_product.idProduct) as VecesComprado
FROM product
INNER JOIN order_product ON product.id = order_product.idProduct
GROUP BY product.id
ORDER BY VecesComprado DESC;

-- Consulta clientes y productos clasificando su tipo
SELECT 'Cliente' as tipo, CONCAT(clients.clientName,' ',clients.lastName) as Name
FROM clients
UNION
SELECT 'Producto' as tipo, product.productName as Name
FROM product;


-- Consulta los productos enseñando cuanto stock aproximadamente se tiene de ese producto
SELECT product.id, product.productName,
CASE
    WHEN product.stock >= 100 THEN 'Hay 100 o mas unidades en stock'
    WHEN product.stock >= 50 THEN 'Hay entre 50 y 100 unidades en stock'
    ELSE 'Hay menos de 50 unidades en stock'
END AS UnidadesStock
FROM product;

-- UPDATE
-- Se actualiza el estado de aquellas ordenes pagadas
UPDATE orders SET status='Paid' WHERE orders.id=1;
UPDATE orders SET status='Paid' WHERE orders.id=3;
UPDATE orders SET status='Paid' WHERE orders.id=5;


-- DELETE
-- Se borra al cliente de nombre Patricia Reyes
DELETE FROM clients WHERE clients.id=1684215937;