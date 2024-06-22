CREATE TABLE clients (-- Clientes registrados
  id int NOT NULL,
  clientName varchar(30) NOT NULL,
  lastName varchar(30) NOT NULL,
  address varchar(30)NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE orders (-- Ordenes realizadas por los clientes
  id SERIAL NOT NULL,
  idClient int NOT NULL,
  total int NOT NULL,
  orderDate date NOT NULL,
  status varchar(15) DEFAULT 'Pending', -- La primera vez que se ingresa una orden aparace como pendiente por pagar
  constraint CHK_status CHECK (status in ('Pending','Paid')), -- Asegurar los unicos dos estados posibles para una compra 
  PRIMARY KEY (id),
  FOREIGN KEY (idClient) REFERENCES clients(id)
);

CREATE TABLE product (-- Productos disponibles
  id SERIAL NOT NULL,
  productName varchar(30) NOT NULL UNIQUE, -- Para evitar nombres de productos duplicados
  price int NOT NULL,
  stock int NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE order_product ( -- Tabla de rompimiento para la relacion muchos a muchos entre order y product
  idOrder int NOT NULL,
  idProduct int NOT NULL,
  quantity int NOT NULL,
  PRIMARY KEY (idOrder,idProduct),
  FOREIGN KEY (idOrder) REFERENCES orders(id),
  FOREIGN KEY (idProduct) REFERENCES product(id)
);


