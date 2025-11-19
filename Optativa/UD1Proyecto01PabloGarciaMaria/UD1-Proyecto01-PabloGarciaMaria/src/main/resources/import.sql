INSERT INTO usuarios (nombre, apellidos, email, password, fecha_creacion, estado) VALUES ('Usuario', 'pruebas', 'pruebas@gmail.com','1234','2025-11-13',0);
INSERT INTO usuarios (nombre, apellidos, email, password, fecha_creacion, estado) VALUES ('Usuario', 'relleno', 'pruebas2@gmail.com','1234','2025-11-18',0);

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

-- SUSCRIPCIONES - USUARIO 1 (todas en un solo bloque)

-- NETFLIX (planes 1, 2)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 1, '2025-01-01', '2025-02-01', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 2, '2025-03-01', '2025-04-01', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 2, '2025-10-01', '2025-11-01', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 2, '2025-11-01', '2025-12-01', true, true);

-- HBO MAX (planes 3, 4)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 3, '2025-04-10', '2025-05-10', false, false);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 4, '2025-07-10', '2025-08-10', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 4, '2025-10-10', '2025-11-10', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 4, '2025-11-10', '2025-12-10', true, true);

-- DISNEY+ (plan 5)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 5, '2025-02-05', '2025-03-05', false, false);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 5, '2025-08-05', '2025-09-05', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 5, '2025-11-05', '2025-12-05', true, true);

-- COURSERA (planes 6, 7)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 6, '2025-01-20', '2025-02-20', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 7, '2025-02-20', '2025-03-20', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 7, '2025-10-20', '2025-11-20', true, true);

-- KHAN ACADEMY (plan 8)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 8, '2025-06-01', '2025-07-01', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 8, '2025-09-01', '2025-10-01', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 8, '2025-11-01', '2025-12-01', true, true);

-- ESPN+ (planes 9, 10)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 9, '2025-03-15', '2025-04-15', false, false);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 10, '2025-09-15', '2025-10-15', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 10, '2025-11-15', '2025-12-15', true, true);

-- DAZN (plan 11)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 11, '2025-04-01', '2025-05-01', false, false);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 11, '2025-09-01', '2025-10-01', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 11, '2025-11-01', '2025-12-01', true, true);

-- SPOTIFY (planes 12, 13)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 12, '2025-01-10', '2025-02-10', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 13, '2025-02-10', '2025-03-10', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 13, '2025-05-10', '2025-06-10', false, false);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 13, '2025-10-10', '2025-11-10', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 13, '2025-11-10', '2025-12-10', true, true);

-- APPLE MUSIC (plan 14)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 14, '2025-03-05', '2025-04-05', false, false);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 14, '2025-08-05', '2025-09-05', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 14, '2025-11-05', '2025-12-05', true, true);

-- NY TIMES (planes 15, 16)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 15, '2025-01-01', '2025-02-01', false, false);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 16, '2025-06-01', '2025-07-01', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 16, '2025-10-01', '2025-11-01', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 16, '2025-11-01', '2025-12-01', true, true);

-- EL PAÍS (plan 17)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 17, '2025-02-12', '2025-03-12', false, false);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 17, '2025-10-12', '2025-11-12', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 17, '2025-11-12', '2025-12-12', true, true);

-- TWITCH (planes 18, 19)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 18, '2025-03-20', '2025-04-20', false, false);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 19, '2025-08-20', '2025-09-20', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 19, '2025-10-20', '2025-11-20', true, true);

-- PATREON (plan 20)
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 20, '2025-04-01', '2025-05-01', false, false);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 20, '2025-10-01', '2025-11-01', false, true);
INSERT INTO suscripcion (usuario_id, plan_id, fecha_inicio, fecha_fin, activa, renovacion_automatica) VALUES (1, 20, '2025-11-01', '2025-12-01', true, true);

ALTER TABLE plataformas ALTER COLUMN id RESTART WITH 14;
