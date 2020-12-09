INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (1, 'Andres', 'Guzman', 'ag@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (2, 'Pedro', 'Pepe', 'pp@hotmail.com', '2017-08-23', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (3, 'Andres', 'Guzman', 'ag@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (4, 'Pedro', 'Pepe', 'pp@hotmail.com', '2017-08-23', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (5, 'Andres', 'Guzman', 'ag@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (6, 'Pedro', 'Pepe', 'pp@hotmail.com', '2017-08-23', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (7, 'Andres', 'Guzman', 'ag@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (8, 'Pedro', 'Pepe', 'pp@hotmail.com', '2017-08-23', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (9, 'Andres', 'Guzman', 'ag@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (10, 'Pedro', 'Pepe', 'pp@hotmail.com', '2017-08-23', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (11, 'Andres', 'Guzman', 'ag@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (12, 'Pedro', 'Pepe', 'pp@hotmail.com', '2017-08-23', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (13, 'Andres', 'Guzman', 'ag@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (14, 'Pedro', 'Pepe', 'pp@hotmail.com', '2017-08-23', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (15, 'Andres', 'Guzman', 'ag@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (16, 'Pedro', 'Pepe', 'pp@hotmail.com', '2017-08-23', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (17, 'Andres', 'Guzman', 'ag@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (18, 'Pedro', 'Pepe', 'pp@hotmail.com', '2017-08-23', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (19, 'Andres', 'Guzman', 'ag@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (20, 'Pedro', 'Pepe', 'pp@hotmail.com', '2017-08-23', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (21, 'Andres', 'Guzman', 'ag@hotmail.com', '2017-08-28', '');
INSERT INTO clientes (id_cliente, nombre, apellido, email, created_at, foto) VALUES (22, 'Pedro', 'Pepe', 'pp@hotmail.com', '2017-08-23', '');

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, id_cliente, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO detalle_factura (cantidad, id_factura, id_producto) VALUES(1, 1, 1);
INSERT INTO detalle_factura (cantidad, id_factura, id_producto) VALUES(2, 1, 4);
INSERT INTO detalle_factura (cantidad, id_factura, id_producto) VALUES(1, 1, 5);
INSERT INTO detalle_factura (cantidad, id_factura, id_producto) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, id_cliente, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO detalle_factura (cantidad, id_factura, id_producto) VALUES(3, 2, 6);

INSERT INTO users (username, password, enable) VALUES('admin', '$2a$10$CGc2//COdG6RRZ7WIHsonOoRwb2JMEQ7mS2.E3ZIv3JM7Ds2ZrPRm', 1);
INSERT INTO users (username, password, enable) VALUES('lucas', '$2a$10$CWDJK5mxjP85WgkqcdDR7eur40K2ZmHD920cxKK7kyBDtazxxtW.W', 0);
INSERT INTO users (username, password, enable) VALUES('prueba', '$2a$10$CWDJK5mxjP85WgkqcdDR7eur40K2ZmHD920cxKK7kyBDtazxxtW.W', 1);

INSERT INTO authorities (id_user, authority) VALUES(1, 'ROLE_ADMIN');
INSERT INTO authorities (id_user, authority) VALUES(1, 'ROLE_USER');
INSERT INTO authorities (id_user, authority) VALUES(2, 'ROLE_USER');

