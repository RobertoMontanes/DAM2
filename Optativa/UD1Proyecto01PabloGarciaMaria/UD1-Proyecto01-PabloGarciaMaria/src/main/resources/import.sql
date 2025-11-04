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

INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Central Madrid', 'Madrid', 4200.5, true, 0, 3);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Norte', 'Bilbao', 2100.2, false, 1, 8);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Logístico Sur', 'Sevilla', 3500.0, true, 0, 15);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Zaragoza', 'Zaragoza', 1850.4, true, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Valencia', 'Valencia', 2650.3, false, 1, 10);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Galicia', 'A Coruña', 3100.0, true, 0, 6);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Plataforma Norte', 'Burgos', 900.6, false, 2, 1);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Central Barcelona', 'Barcelona', 4800.7, true, 0, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Este', 'Valencia', 2100.1, false, 1, 5);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Industrial Sevilla', 'Sevilla', 3950.8, true, 0, 2);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Sur', 'Málaga', 1300.4, false, 1, 12);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro de Distribución Toledo', 'Toledo', 2700.9, true, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Norte Valladolid', 'Valladolid', 4500.0, true, 0, 9);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Oeste', 'Badajoz', 1750.2, false, 1, 4);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Logístico Central', 'Madrid', 5000.0, true, 0, 16);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Andalucía', 'Granada', 2950.3, false, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Castilla', 'Salamanca', 1850.7, true, 0, 7);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Levante', 'Alicante', 3150.6, false, 1, 14);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Baleares', 'Palma de Mallorca', 2450.4, true, 0, 20);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Canarias', 'Santa Cruz', 2750.0, true, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Norte', 'León', 1250.1, false, 1, 18);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Industrial Cáceres', 'Cáceres', 3850.9, true, 0, 11);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Montaña', 'Huesca', 1650.2, false, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Este', 'Murcia', 2350.6, true, 0, 13);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Sierra', 'Jaén', 1980.0, false, 1, 17);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Logístico Vigo', 'Vigo', 3550.5, true, 0, 19);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Sur', 'Córdoba', 2500.2, false, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Oeste II', 'Badajoz', 1850.8, true, 1, 8);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Atlántico', 'Ferrol', 4150.7, true, 0, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Industrial Este', 'Valencia', 2800.9, false, 1, 6);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Norte Bilbao', 'Bilbao', 2950.3, true, 0, 3);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Frontera', 'Irún', 2200.4, false, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Ebro', 'Zaragoza', 3300.1, true, 0, 10);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Sur II', 'Sevilla', 3600.0, false, 1, 15);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Valencia II', 'Valencia', 1550.8, true, 0, 2);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Pirineos', 'Huesca', 1420.6, false, 1, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Toledo', 'Toledo', 2700.3, true, 0, 14);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Aragón', 'Teruel', 3100.7, true, 0, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Levante II', 'Alicante', 2950.5, false, 1, 5);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Central II', 'Madrid', 4100.8, true, 0, 12);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Central Madrid', 'Madrid', 4200.5, true, 0, 3);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Norte', 'Bilbao', 2100.2, false, 1, 8);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Logístico Sur', 'Sevilla', 3500.0, true, 0, 15);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Zaragoza', 'Zaragoza', 1850.4, true, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Valencia', 'Valencia', 2650.3, false, 1, 10);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Galicia', 'A Coruña', 3100.0, true, 0, 6);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Plataforma Norte', 'Burgos', 900.6, false, 2, 1);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Central Barcelona', 'Barcelona', 4800.7, true, 0, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Este', 'Valencia', 2100.1, false, 1, 5);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Industrial Sevilla', 'Sevilla', 3950.8, true, 0, 2);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Sur', 'Málaga', 1300.4, false, 1, 12);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro de Distribución Toledo', 'Toledo', 2700.9, true, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Norte Valladolid', 'Valladolid', 4500.0, true, 0, 9);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Oeste', 'Badajoz', 1750.2, false, 1, 4);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Logístico Central', 'Madrid', 5000.0, true, 0, 16);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Andalucía', 'Granada', 2950.3, false, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Castilla', 'Salamanca', 1850.7, true, 0, 7);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Levante', 'Alicante', 3150.6, false, 1, 14);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Baleares', 'Palma de Mallorca', 2450.4, true, 0, 20);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Canarias', 'Santa Cruz', 2750.0, true, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Norte', 'León', 1250.1, false, 1, 18);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Industrial Cáceres', 'Cáceres', 3850.9, true, 0, 11);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Montaña', 'Huesca', 1650.2, false, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Este', 'Murcia', 2350.6, true, 0, 13);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Sierra', 'Jaén', 1980.0, false, 1, 17);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Logístico Vigo', 'Vigo', 3550.5, true, 0, 19);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Sur', 'Córdoba', 2500.2, false, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Oeste II', 'Badajoz', 1850.8, true, 1, 8);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Atlántico', 'Ferrol', 4150.7, true, 0, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Industrial Este', 'Valencia', 2800.9, false, 1, 6);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Norte Bilbao', 'Bilbao', 2950.3, true, 0, 3);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Frontera', 'Irún', 2200.4, false, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Ebro', 'Zaragoza', 3300.1, true, 0, 10);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Sur II', 'Sevilla', 3600.0, false, 1, 15);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Valencia II', 'Valencia', 1550.8, true, 0, 2);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Pirineos', 'Huesca', 1420.6, false, 1, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Toledo', 'Toledo', 2700.3, true, 0, 14);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Aragón', 'Teruel', 3100.7, true, 0, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Levante II', 'Alicante', 2950.5, false, 1, 5);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Central II', 'Madrid', 4100.8, true, 0, 12);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Mediterráneo', 'Valencia', 2700.1, false, 2, 7);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Atlántica', 'Vigo', 3300.5, true, 0, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Industrial Norte', 'Santander', 2800.2, false, 1, 9);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Sierra II', 'Granada', 1800.4, true, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Logístico Atlántico', 'A Coruña', 3900.0, true, 0, 1);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Guadiana', 'Mérida', 2600.9, false, 1, 11);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Castellano', 'Valladolid', 3400.8, true, 0, 16);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Marítimo', 'Cádiz', 2850.1, false, 1, 13);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Pirineos', 'Huesca', 1750.0, true, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Sierra Nevada', 'Granada', 2600.2, false, 0, 18);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Tajo', 'Toledo', 1950.3, true, 1, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén del Este', 'Valencia', 2800.4, false, 2, 4);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Logístico Guadalquivir', 'Sevilla', 3600.7, true, 0, 19);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito de la Mancha', 'Ciudad Real', 1750.9, false, 1, 2);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Levante III', 'Alicante', 2850.5, true, 0, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Asturias', 'Oviedo', 2400.6, false, 1, 8);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Ibérico', 'Madrid', 4800.9, true, 0, 17);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Mediterráneo II', 'Valencia', 2600.3, false, 1, 6);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Sierra de Gredos', 'Ávila', 1550.4, true, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Atlántico', 'A Coruña', 3850.7, true, 0, 15);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Levante III', 'Valencia', 2200.1, false, 1, 3);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Central Burgos', 'Burgos', 2950.9, true, 0, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Frontera Norte', 'Irún', 3300.5, false, 2, 10);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Mediterráneo', 'Alicante', 3450.8, true, 0, 14);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Sur III', 'Málaga', 1900.6, false, 1, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Este II', 'Murcia', 2550.7, true, 0, 12);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Norte II', 'León', 1800.3, false, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Atlántico II', 'Vigo', 3100.4, true, 0, 5);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Industrial Sur', 'Sevilla', 4050.2, false, 1, 7);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Logístico Norte II', 'Bilbao', 3550.0, true, 0, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Madrid Norte', 'Madrid', 2950.1, false, 2, 9);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Guadalquivir II', 'Córdoba', 2700.8, true, 0, 1);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Levante IV', 'Valencia', 2300.6, false, 1, 11);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Sierra Sur', 'Granada', 2150.2, true, 0, 20);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Toledo II', 'Toledo', 2650.9, false, 1, 2);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Castilla Norte', 'Burgos', 3100.0, true, 0, 8);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Atlántico III', 'Ferrol', 2750.4, false, 2, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Sierra Central', 'Cuenca', 1900.8, true, 0, 19);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Levante IV', 'Valencia', 2200.3, false, 1, 4);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Norte III', 'Bilbao', 2500.1, true, 0, 6);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Almacén Este III', 'Murcia', 2600.6, false, 1, NULL);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Atlántico II', 'A Coruña', 2900.4, true, 0, 18);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Sierra III', 'Jaén', 2300.7, false, 1, 13);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Nave Sur II', 'Sevilla', 3600.8, true, 0, 15);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Madrid Sur', 'Madrid', 4000.5, false, 2, 17);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Centro Ebro II', 'Zaragoza', 3100.2, true, 0, 10);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id) VALUES ('Depósito Levante V', 'Alicante', 2450.3, false, 1, NULL);