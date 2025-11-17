INSERT INTO usuarios (id, nombre, apellidos, email, password, fecha_creacion, estado) VALUES (1, 'Usuario', 'pruebas', 'pruebas@gmail.com','1234','2025-11-13',0);

INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (1, 'Netflix', true, '0', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (2, 'HBO Max', true, '0', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (3, 'Disney+', true, '0', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (4, 'Coursera', true, '1', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (5, 'Khan Academy', true, '1', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (6, 'ESPN+', true, '2', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (7, 'DAZN', true, '2', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (8, 'Spotify', true, '3', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (9, 'Apple Music', true, '3', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (10, 'NY Times', true, '4', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (11, 'El País', true, '4', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (12, 'Twitch', true, '5', 1);
INSERT INTO plataformas (id, nombre, estado, categoria, usuario_id) VALUES (13, 'Patreon', true, '5', 1);

INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 12.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 1);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Premium 4K', 17.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 1);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 8.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 2);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Estándar', 10.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 2);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 7.49, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 3);

INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 0.0, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 4;
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Premium', 19.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 4);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 0.0, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 5);

INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 9.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 6);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Premium', 14.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 6);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 12.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 7);

INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 9.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 8);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Premium Familiar', 14.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 8);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 9.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 9);

INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 5.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 10);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Premium', 9.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 10);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 4.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 11);

INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 0.0, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 12);
INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Premium',4.99,X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078',true,12);

INSERT INTO planes (nombre, precio, frecuencia, activo, plataforma_id) VALUES ('Por defecto', 3.99, X'aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770d0e00000000000000010000000078', true, 13);

ALTER TABLE usuarios ALTER COLUMN id RESTART WITH 2;
ALTER TABLE plataformas ALTER COLUMN id RESTART WITH 14;
