INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Carlos', 'Pérez', 'carlos.perez@example.com', 'cperez', 'password123', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('María', 'López', 'maria.lopez@example.com', 'mlopez', 'maria2025', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Juan', 'Rodríguez', 'juan.rodriguez@example.com', 'jrodriguez', 'juanpass', false, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Laura', 'Gómez', 'laura.gomez@example.com', 'lgomez', 'laura321', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Andrés', 'Torres', 'andres.torres@example.com', 'atorres', 'andrespass', false, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Sofía', 'Ramírez', 'sofia.ramirez@example.com', 'sramirez', 'sof2025', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Diego', 'Martínez', 'diego.martinez@example.com', 'dmartinez', 'diegopass', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Valentina', 'Ruiz', 'valentina.ruiz@example.com', 'vruiz', 'valen321', false, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Fernando', 'Castillo', 'fernando.castillo@example.com', 'fcastillo', 'ferpass', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Camila', 'Herrera', 'camila.herrera@example.com', 'cherrera', 'camila2025', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Ricardo', 'Díaz', 'ricardo.diaz@example.com', 'rdiaz', 'ricardopass', false, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Lucía', 'Vega', 'lucia.vega@example.com', 'lvega', 'luciapass', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Mateo', 'Morales', 'mateo.morales@example.com', 'mmorales', 'mateo2025', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Paula', 'Navarro', 'paula.navarro@example.com', 'pnavarro', 'paulapass', false, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Javier', 'Soto', 'javier.soto@example.com', 'jsoto', 'javi321', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Natalia', 'Cruz', 'natalia.cruz@example.com', 'ncruz', 'naty2025', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Hugo', 'Vargas', 'hugo.vargas@example.com', 'hvargas', 'hugopass', false, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Elena', 'Rojas', 'elena.rojas@example.com', 'erojas', 'elenapass', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Gabriel', 'Flores', 'gabriel.flores@example.com', 'gflores', 'gab2025', true, '2025-11-02');
INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Daniela', 'Campos', 'daniela.campos@example.com', 'dcampos', 'danipass', false, '2025-11-02');

INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Básico', 9.99, 1, false, 1);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Emprendedor', 19.99, 3, false, 1);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Profesional', 39.99, 10, true, 3);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Empresarial', 79.99, 25, true, 6);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Corporativo', 149.99, 100, true, 12);

-- Usuario 1 (Carlos Pérez)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (1, 1, '2025-08-01', '2025-09-15', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (1, 2, '2025-09-10', '2025-11-10', true, false);

-- Usuario 2 (María López)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (2, 3, '2025-05-01', '2025-08-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (2, 4, '2025-08-01', '2026-02-01', true, false);

-- Usuario 3 (Juan Rodríguez)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (3, 1, '2025-03-01', '2025-04-15', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (3, 2, '2025-04-10', '2025-07-10', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (3, 3, '2025-07-05', '2025-11-05', true, false);

-- Usuario 4 (Laura Gómez)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (4, 2, '2025-06-01', '2025-07-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (4, 4, '2025-07-01', '2026-01-01', true, false);

-- Usuario 5 (Andrés Torres)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (5, 1, '2025-04-01', '2025-05-15', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (5, 3, '2025-05-10', '2025-08-10', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (5, 5, '2025-08-05', '2026-08-05', true, false);

-- Usuario 6 (Sofía Ramírez)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (6, 2, '2025-03-01', '2025-04-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (6, 4, '2025-04-01', '2025-10-01', true, false);

-- Usuario 7 (Diego Martínez)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (7, 1, '2025-02-01', '2025-03-15', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (7, 2, '2025-03-10', '2025-04-10', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (7, 4, '2025-04-05', '2025-10-05', true, false);

-- Usuario 8 (Valentina Ruiz)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (8, 3, '2025-01-01', '2025-04-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (8, 5, '2025-03-25', '2026-03-25', true, false);

-- Usuario 9 (Fernando Castillo)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (9, 2, '2025-05-01', '2025-06-10', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (9, 3, '2025-06-05', '2025-09-05', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (9, 5, '2025-09-01', '2026-09-01', true, false);

-- Usuario 10 (Camila Herrera)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (10, 1, '2025-04-01', '2025-05-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (10, 2, '2025-04-25', '2025-07-25', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (10, 3, '2025-07-10', '2025-12-10', true, false);

-- Usuario 11 (Ricardo Díaz)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (11, 4, '2025-01-01', '2025-07-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (11, 5, '2025-06-25', '2026-06-25', true, false);

-- Usuario 12 (Lucía Vega)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (12, 1, '2025-02-01', '2025-03-15', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (12, 2, '2025-03-10', '2025-06-10', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (12, 4, '2025-06-05', '2025-12-05', true, false);

-- Usuario 13 (Mateo Morales)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (13, 2, '2025-07-01', '2025-08-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (13, 4, '2025-07-25', '2026-01-25', true, false);

-- Usuario 14 (Paula Navarro)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (14, 3, '2025-01-01', '2025-03-15', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (14, 5, '2025-03-10', '2026-03-10', true, false);

-- Usuario 15 (Javier Soto)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (15, 1, '2025-05-01', '2025-06-01', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (15, 3, '2025-05-25', '2025-09-25', true, false);

-- Usuario 16 (Natalia Cruz)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (16, 4, '2025-04-01', '2025-10-01', true, false);

-- Usuario 17 (Hugo Vargas)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (17, 2, '2025-02-01', '2025-05-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (17, 3, '2025-04-25', '2025-07-25', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (17, 4, '2025-07-10', '2026-01-10', true, false);

-- Usuario 18 (Elena Rojas)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (18, 1, '2025-03-01', '2025-04-10', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (18, 3, '2025-04-05', '2025-07-05', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (18, 5, '2025-06-30', '2026-06-30', true, false);

-- Usuario 19 (Gabriel Flores)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (19, 2, '2025-03-01', '2025-04-15', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (19, 4, '2025-04-10', '2025-10-10', true, false);

-- Usuario 20 (Daniela Campos)
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (20, 1, '2025-02-01', '2025-03-10', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (20, 2, '2025-03-05', '2025-06-05', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (20, 3, '2025-05-25', '2025-09-25', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (20, 5, '2025-09-10', '2026-09-10', true, false);