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

INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Almacén Premium Madrid', 45000.0, 0, 21.0, 'Control de humedad y temperatura constante, acceso restringido');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Centro Estándar Norte', 30000.0, 1, 22.0, 'Condiciones normales de almacenamiento, mantenimiento mensual');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Depósito Económico Sevilla', 15000.0, 2, 24.0, 'Infraestructura básica, sin control climático');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Cámara Frigorífica Valencia', 12000.0, 3, -10.0, 'Temperatura controlada, requiere generador de respaldo');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Centro Biológico Barcelona', 10000.0, 4, 18.0, 'Ventilación especial y monitoreo continuo de CO₂');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Depósito Químico Bilbao', 8000.0, 5, 20.0, 'Zonas de contención y sensores de gases');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Almacén Multifunción Toledo', 25000.0, 6, 22.0, 'Espacio adaptable a distintos tipos de mercancía');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Centro Logístico de Lujo', 48000.0, 0, 20.0, 'Climatización inteligente y seguridad privada');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Nave Estándar Zaragoza', 32000.0, 1, 22.5, 'Sistema de ventilación natural y piso reforzado');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Depósito Económico Málaga', 14000.0, 2, 24.5, 'Sin climatización, mantenimiento básico anual');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Cámara de Frío Industrial', 16000.0, 3, -18.0, 'Paredes aislantes y control de humedad');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Centro Zoológico Cádiz', 9000.0, 4, 19.0, 'Zonas de luz natural y control de ventilación automática');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Depósito de Residuos Tóxicos', 7000.0, 5, 20.0, 'Cumple normativa ADR, sistemas antiincendios avanzados');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Centro Mixto Alicante', 27000.0, 6, 21.5, 'Secciones separadas para mercancías diversas');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Almacén de Lujo Elite', 42000.0, 0, 20.5, 'Control ambiental inteligente, acceso biométrico');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Depósito Estándar Castilla', 28000.0, 1, 22.0, 'Condiciones óptimas para productos no perecederos');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Centro Económico Norte', 13000.0, 2, 25.0, 'Instalaciones básicas con seguridad limitada');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Cámara Refrigerada Galicia', 15000.0, 3, -5.0, 'Sistemas de respaldo eléctrico y alarmas térmicas');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Vivero Logístico Murcia', 9500.0, 4, 18.5, 'Temperatura y luz reguladas según el tipo de especie');
INSERT INTO tipo_almacen (nombre, capacidad, categoria, temperatura, requisitos_especiales) VALUES ('Depósito de Material Peligroso Sur', 8500.0, 5, 21.0, 'Zonas de aislamiento químico y sensores de movimiento');

INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Almacén Central Madrid', 'Madrid', 4200.5, true, 0, 3, 1);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Norte Bilbao', 'Bilbao', 3100.0, false, 1, 7, 2);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Económico Sevilla', 'Sevilla', 2300.0, false, 0, NULL, 3);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Cámara Fría Valencia', 'Valencia', 1500.0, true, 0, 10, 4);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('BioCentro Barcelona', 'Barcelona', 1200.0, true, 2, 12, 5);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Químico Bilbao', 'Bilbao', 900.0, true, 0, 5, 6);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Multialmacén Toledo', 'Toledo', 2700.0, false, 1, NULL, 7);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Logística Premium Madrid', 'Madrid', 4500.0, true, 0, 1, 8);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Nave Estándar Zaragoza', 'Zaragoza', 3200.0, false, 0, 8, 9);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Económico Málaga', 'Málaga', 2200.0, false, 1, 14, 10);

INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Cámara Frigorífica Industrial', 'Valencia', 1600.0, true, 0, 9, 11);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Zoológico Cádiz', 'Cádiz', 1800.0, true, 2, 11, 12);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Residuos Tóxicos', 'Huelva', 950.0, true, 1, 16, 13);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Mixto Alicante', 'Alicante', 2600.0, false, 0, NULL, 14);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Elite Storage Madrid', 'Madrid', 4800.0, true, 0, 2, 15);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Castilla', 'Valladolid', 3300.0, false, 0, 4, 16);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Económico Norte', 'León', 2100.0, false, 2, NULL, 17);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Cámara Refrigerada Galicia', 'Santiago', 1400.0, true, 0, 15, 18);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Vivero Murcia', 'Murcia', 1000.0, true, 0, 6, 19);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Material Peligroso Sur', 'Granada', 870.0, true, 1, 17, 20);

-- 21–40
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Central Premium Norte', 'Santander', 3900.0, true, 0, NULL, 1);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Logístico Castilla', 'Salamanca', 2900.0, false, 1, 13, 2);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Económico Córdoba', 'Córdoba', 1800.0, false, 0, NULL, 3);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Frío Industrial Norte', 'Burgos', 1400.0, true, 2, 18, 4);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Biológico Granada', 'Granada', 1300.0, true, 0, 19, 5);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Tóxico Centro', 'Madrid', 870.0, true, 0, 20, 6);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Almacén Multiusos Cuenca', 'Cuenca', 2600.0, false, 1, 1, 7);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Premium Storage Valencia', 'Valencia', 4700.0, true, 0, 3, 8);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Estándar Logístico Aragón', 'Zaragoza', 2800.0, false, 2, 10, 9);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Económico Sur', 'Almería', 2400.0, false, 0, NULL, 10);

INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Frío Almería', 'Almería', 1550.0, true, 0, 8, 11);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Reserva Zoológica Toledo', 'Toledo', 1900.0, true, 2, NULL, 12);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Químico Norte', 'Pamplona', 880.0, true, 1, 4, 13);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Logístico Mixto Sur', 'Granada', 2500.0, false, 0, 11, 14);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Luxury Storage Marbella', 'Marbella', 4900.0, true, 0, 2, 15);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Estándar Galicia', 'A Coruña', 3300.0, false, 1, 6, 16);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Económico Baleares', 'Palma', 2100.0, false, 2, NULL, 17);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Frigorífico Cataluña', 'Girona', 1450.0, true, 0, 10, 18);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Biológico Levante', 'Valencia', 1250.0, true, 0, 13, 19);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Químico Este', 'Tarragona', 950.0, true, 1, 5, 20);

INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Central Lujo Norte', 'Oviedo', 4100.0, true, 0, NULL, 1);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Estándar La Rioja', 'Logroño', 2950.0, false, 0, 14, 2);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Económico Aragón', 'Zaragoza', 2150.0, false, 1, 7, 3);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Frigorífico Industrial Oeste', 'Badajoz', 1650.0, true, 2, 17, 4);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Seres Vivos Sur', 'Huelva', 1100.0, true, 0, 9, 5);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Peligrosos Oeste', 'Cáceres', 870.0, true, 0, 20, 6);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Multiusos Andalucía', 'Córdoba', 2750.0, false, 1, NULL, 7);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Lujo Storage Valencia', 'Valencia', 4800.0, true, 0, 3, 8);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Estándar Centro Madrid', 'Madrid', 3050.0, false, 0, 18, 9);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Económico Asturias', 'Gijón', 2250.0, false, 2, 12, 10);

INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Frío Atlántico', 'Vigo', 1500.0, true, 0, 19, 11);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Vivero Sur', 'Málaga', 1700.0, true, 2, 1, 12);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Químico Toledo', 'Toledo', 910.0, true, 1, NULL, 13);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Mixto Este', 'Castellón', 2600.0, false, 0, 15, 14);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Luxury Warehouse Norte', 'Pamplona', 4700.0, true, 0, 8, 15);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Estándar Galicia', 'Lugo', 3150.0, false, 1, 11, 16);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Económico Oeste', 'Badajoz', 2000.0, false, 0, 2, 17);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Cámara Refrigerada Este', 'Valencia', 1400.0, true, 2, 10, 18);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('BioStorage Mediterráneo', 'Alicante', 1150.0, true, 0, 16, 19);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Peligrosos Norte', 'Santander', 890.0, true, 1, 14, 20);

-- 81–100
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Lujo Aragón', 'Zaragoza', 4200.0, true, 0, NULL, 1);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Estándar Baleares', 'Ibiza', 2900.0, false, 1, 7, 2);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Económico Levante', 'Valencia', 2150.0, false, 2, 3, 3);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Frío Sur', 'Sevilla', 1600.0, true, 0, 6, 4);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Biocentro Norte', 'Oviedo', 1250.0, true, 1, 17, 5);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Químico Sur', 'Granada', 910.0, true, 0, 5, 6);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Multiusos Madrid', 'Madrid', 2800.0, false, 0, 4, 7);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Luxury Central Valencia', 'Valencia', 4950.0, true, 0, 2, 8);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Estándar Sur', 'Cádiz', 3100.0, false, 1, NULL, 9);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Económico Este', 'Elche', 2200.0, false, 2, 8, 10);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Frigorífico Sur Industrial', 'Sevilla', 1500.0, true, 0, 10, 11);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Vivero Levante', 'Valencia', 1850.0, true, 2, 12, 12);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Peligrosos Norte', 'Burgos', 880.0, true, 1, 9, 13);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Centro Logístico Mixto Centro', 'Madrid', 2550.0, false, 0, 18, 14);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Elite Storage Canarias', 'Tenerife', 4600.0, true, 0, 15, 15);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Estándar Norte', 'Vitoria', 3200.0, false, 1, NULL, 16);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Económico Galicia', 'Pontevedra', 2050.0, false, 0, 19, 17);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Frigorífico Madrid', 'Madrid', 1500.0, true, 0, 1, 18);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('BioStorage Centro', 'Madrid', 1200.0, true, 2, NULL, 19);
INSERT INTO almacenes (nombre, ubicacion, superficie, seguridad, estado_almacen, usuario_id, tipo_almacen_id) VALUES ('Depósito Químico Central', 'Madrid', 950.0, true, 0, 13, 20);
