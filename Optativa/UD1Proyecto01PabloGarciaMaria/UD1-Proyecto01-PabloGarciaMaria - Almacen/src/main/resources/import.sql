INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Basico', 5.99, 1, false, 1);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Basico', 10.99, 1, false, 2);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Basico', 15.99, 1, false, 3);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Basico', 29.99, 1, false, 6);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Basico', 49.99, 1, false, 12);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Estandar', 9.99, 5, false, 1);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Estandar', 18.99, 5, false, 2);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Estandar', 27.99, 5, false, 3);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Estandar', 53.99, 5, false, 6);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Estandar', 99.99, 5, false, 12);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Premium', 14.99, 15, true, 1);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Premium', 28.99, 15, true, 2);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Premium', 41.99, 15, true, 3);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Premium', 79.99, 15, true, 6);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Premium', 149.99, 15, true, 12);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Empresarial', 29.99, 50, true, 1);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Empresarial', 57.99, 50, true, 2);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Empresarial', 83.99, 50, true, 3);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Empresarial', 159.99, 50, true, 6);
INSERT INTO subscripciones (nombre, precio, num_almacenes, soporte_prioritario, duracion_meses) VALUES ('Empresarial', 299.99, 50, true, 12);




INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Carlos', 'Aguado Valenzuela', 'aguado.vaca@example.com', 'aguado.vaca', 'P1|57GN+tu&M', True, '2024-12-31')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (0, 5, '2021-02-20', '2021-03-20', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (0, 11, '2024-03-18', '2024-05-18', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (0, 0, '2025-07-28', '2025-08-28', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (0, 12, '2025-10-10', '2026-01-10', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Irene', 'Alvarado Ponce', 'alvarado.poir@example.com', 'alvarado.poir', '#Qr,3oRy.nti', False, '2022-05-09')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (1, 5, '2018-07-19', '2018-08-19', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (1, 9, '2021-01-21', '2022-01-21', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (1, 2, '2022-05-14', '2022-08-14', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (1, 14, '2024-01-02', '2025-01-02', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (1, 16, '2025-12-21', '2026-02-21', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Adrián', 'Santillán Carrillo', 'santillan.caad@example.com', 'santillan.caad', 'Il=m=GsD%oG5', False, '2016-07-27')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (2, 5, '2022-02-04', '2022-03-04', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (2, 13, '2023-12-25', '2024-06-25', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (2, 15, '2024-09-26', '2024-10-26', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (2, 3, '2025-05-20', '2025-11-20', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Beatriz', 'Orozco García', 'orozco.gabe@example.com', 'orozco.gabe', 'oY>\+4X&u&>+', True, '2022-03-11')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (3, 8, '2016-05-08', '2016-11-08', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (3, 3, '2024-10-16', '2025-04-16', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (3, 17, '2024-11-05', '2025-02-05', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (3, 10, '2025-02-27', '2025-03-27', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Florencia', 'Pizarro Sandoval', 'pizarro.safl@example.com', 'pizarro.safl', 'Q2[B1g|3g{%Q', True, '2017-03-06')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (4, 1, '2025-10-05', '2025-12-05', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Celeste', 'Núñez Pineda', 'nunez.pice@example.com', 'nunez.pice', '"uvwTMkkXCyX', True, '2018-05-17')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (5, 4, '2019-02-05', '2020-02-05', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (5, 18, '2025-11-05', '2026-05-05', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Belén', 'Herrera Mata', 'herrera.mabe@example.com', 'herrera.mabe', 'qcx$@X<H[8KH', False, '2020-08-30')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (6, 12, '2016-01-16', '2016-04-16', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (6, 8, '2025-01-02', '2025-07-02', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (6, 12, '2025-02-11', '2025-05-11', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (6, 16, '2025-02-26', '2025-04-26', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (6, 10, '2025-12-29', '2026-01-29', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Sebastián', 'Olivares Becerra', 'olivares.bese@example.com', 'olivares.bese', '`"Q2~Cr^3b)>', True, '2022-09-09')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (7, 5, '2025-08-28', '2025-09-28', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Sara', 'Cuevas Marín', 'cuevas.masa@example.com', 'cuevas.masa', '4mp&)!L}FNd?', False, '2023-07-04')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (8, 3, '2022-10-25', '2023-04-25', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (8, 10, '2022-11-03', '2022-12-03', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (8, 2, '2024-12-17', '2025-03-17', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (8, 6, '2025-10-23', '2025-12-23', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Nerea', 'Suárez Pizarra', 'suarez.pine@example.com', 'suarez.pine', ';l;mFagPC,!*', False, '2021-12-22')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (9, 2, '2021-06-06', '2021-09-06', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (9, 12, '2025-11-14', '2026-02-14', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Verónica', 'Plaza Téllez', 'plaza.teve@example.com', 'plaza.teve', 'O~V,bsAgF!ou', False, '2018-02-05')



    INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Miguel', 'Pizarra Sánchez', 'pizarra.sami@example.com', 'pizarra.sami', 'KsH&q&|<NOJ]', True, '2018-03-19')



INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Raúl', 'Díaz Villanueva', 'diaz.vira@example.com', 'diaz.vira', '9SX1r)aqgS&)', False, '2019-12-02')

INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (12, 14, '2017-11-26', '2018-11-26', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (12, 14, '2023-11-11', '2024-11-11', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (12, 9, '2025-03-17', '2026-03-17', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Valentina', 'Molina Huerta', 'molina.huva@example.com', 'molina.huva', 'CG:Y%]dZ@*dM', False, '2021-12-07')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (13, 1, '2023-09-25', '2023-11-25', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (13, 19, '2024-05-25', '2025-05-25', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (13, 0, '2025-09-02', '2025-10-02', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (13, 19, '2025-12-17', '2026-12-17', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Camila', 'Del Ángel Reynoso', 'del_angel.reca@example.com', 'del_angel.reca', 'R7D-k&rnhNOs', False, '2019-01-12')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (14, 4, '2018-03-09', '2019-03-09', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (14, 19, '2020-03-12', '2021-03-12', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Antonio', 'Sepúlveda Pastrana', 'sepulveda.paan@example.com', 'sepulveda.paan', '}jazE/4A-A-t', False, '2019-10-19')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (15, 13, '2020-11-03', '2021-05-03', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (15, 9, '2022-03-04', '2023-03-04', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (15, 17, '2023-06-20', '2023-09-20', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (15, 1, '2024-02-18', '2024-04-18', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (15, 3, '2025-04-18', '2025-10-18', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (15, 8, '2025-10-02', '2026-04-02', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Javier', 'Jiménez Téllez', 'jimenez.teja@example.com', 'jimenez.teja', 'uhW(wt?u5$2o', True, '2019-01-19')



    INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Adela', 'Pizarro Izquierdo', 'pizarro.izad@example.com', 'pizarro.izad', 'C@6EHH**crct', False, '2023-02-13')

INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (17, 4, '2025-10-02', '2026-10-02', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Ángela', 'González Pizarra', 'gonzalez.pian@example.com', 'gonzalez.pian', '${j!}SO$$_*.', False, '2023-11-22')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (18, 0, '2021-10-24', '2021-11-24', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (18, 17, '2024-11-08', '2025-02-08', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (18, 6, '2025-11-25', '2026-01-25', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Mateo', 'García Del Olmo', 'garcia.dema@example.com', 'garcia.dema', 'j5j?%ez,?YU+', True, '2016-08-06')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (19, 12, '2018-07-20', '2018-10-20', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (19, 4, '2023-12-18', '2024-12-18', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (19, 4, '2025-10-06', '2026-10-06', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Rocío', 'Cuesta Gálvez', 'cuesta.garo@example.com', 'cuesta.garo', ';F-5IIQ}#;F/', False, '2016-05-16')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (20, 3, '2023-05-31', '2023-11-30', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (20, 6, '2024-07-17', '2024-09-17', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (20, 0, '2025-01-04', '2025-02-04', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (20, 8, '2025-04-09', '2025-10-09', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (20, 13, '2025-05-22', '2025-11-22', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Antonio', 'Cabrera Tobar', 'cabrera.toan@example.com', 'cabrera.toan', 'wEi&8Sy-(?>0', True, '2025-08-25')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (21, 9, '2016-01-12', '2017-01-12', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (21, 8, '2018-05-06', '2018-11-06', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (21, 10, '2019-12-25', '2020-01-25', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (21, 8, '2022-03-04', '2022-09-04', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Beatriz', 'Sepúlveda Arellano', 'sepulveda.arbe@example.com', 'sepulveda.arbe', '$uoEM(<pF2{H', True, '2019-08-29')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (22, 17, '2017-01-11', '2017-04-11', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (22, 5, '2024-12-15', '2025-01-15', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (22, 15, '2024-12-25', '2025-01-25', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Marcos', 'Guerrero Avila', 'guerrero.avma@example.com', 'guerrero.avma', '%;3B+;PW"Z0.', False, '2017-05-07')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (23, 16, '2017-08-07', '2017-10-07', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (23, 3, '2025-07-24', '2026-01-24', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Rubén', 'Loyola Valdez', 'loyola.varu@example.com', 'loyola.varu', '2R7AvFj8&.#j', False, '2022-02-26')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (24, 0, '2023-11-07', '2023-12-07', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (24, 0, '2024-09-30', '2024-10-30', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (24, 14, '2024-10-26', '2025-10-26', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (24, 11, '2025-01-09', '2025-03-09', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (24, 6, '2025-07-13', '2025-09-13', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (24, 19, '2025-09-25', '2026-09-25', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Francisco', 'Rojo Cuevas', 'rojo.cufr@example.com', 'rojo.cufr', '6loL@R,TX5>n', True, '2019-06-23')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (25, 13, '2025-04-28', '2025-10-28', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (25, 5, '2025-12-13', '2026-01-13', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Carlos', 'Lozano Soto', 'lozano.soca@example.com', 'lozano.soca', 'H}NtD^Z78R>(', False, '2020-09-27')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (26, 11, '2022-07-15', '2022-09-15', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (26, 16, '2023-06-19', '2023-08-19', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (26, 2, '2025-09-17', '2025-12-17', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Liliana', 'Figueroa Camino', 'figueroa.cali@example.com', 'figueroa.cali', ':b7{J3v3<&pF', True, '2023-01-27')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (27, 17, '2020-10-31', '2021-01-31', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (27, 8, '2023-03-05', '2023-09-05', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (27, 2, '2025-07-26', '2025-10-26', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (27, 8, '2025-08-25', '2026-02-25', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Víctor', 'Peralta Basurto', 'peralta.bavi@example.com', 'peralta.bavi', 'N](L`F|kiKT6', False, '2025-10-02')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (28, 2, '2021-10-31', '2022-01-31', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (28, 15, '2022-09-12', '2022-10-12', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (28, 3, '2025-06-09', '2025-12-09', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Fabián', 'Gaitán Cuesta', 'gaitan.cufa@example.com', 'gaitan.cufa', 'q)$stgh/#@Wm', False, '2017-03-03')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (29, 14, '2020-10-27', '2021-10-27', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (29, 15, '2021-12-14', '2022-01-14', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Manuel', 'Coronel Haro', 'coronel.hama@example.com', 'coronel.hama', 'B>g!A?l;.If&', True, '2020-04-15')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (30, 11, '2016-02-24', '2016-04-24', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Sebastián', 'Medina Benítez', 'medina.bese@example.com', 'medina.bese', '8ws7BHpsYhX`', True, '2016-06-04')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (31, 10, '2021-01-30', '2021-02-28', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (31, 19, '2024-06-11', '2025-06-11', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (31, 16, '2024-11-24', '2025-01-24', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (31, 11, '2025-01-30', '2025-03-30', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (31, 6, '2025-10-02', '2025-12-02', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Inés', 'Palma Ochoa', 'palma.ocin@example.com', 'palma.ocin', 'x{mGpFH]3_c<', False, '2022-08-29')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (32, 15, '2025-11-06', '2025-12-06', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Cecilia', 'Sáenz Becerra', 'saenz.bece@example.com', 'saenz.bece', ':&Q6m2;B=l4&', True, '2016-12-04')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (33, 17, '2017-02-23', '2017-05-23', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (33, 2, '2017-05-24', '2017-08-24', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (33, 15, '2022-05-08', '2022-06-08', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (33, 1, '2023-01-13', '2023-03-13', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (33, 10, '2023-04-21', '2023-05-21', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Luis', 'Robledo Escobar', 'robledo.eslu@example.com', 'robledo.eslu', 'QjHDvQ^}K9kU', True, '2019-12-12')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (34, 0, '2020-01-08', '2020-02-08', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (34, 1, '2024-03-28', '2024-05-28', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (34, 5, '2025-10-12', '2025-11-12', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Cristian', 'Tapia Rodríguez', 'tapia.rocr@example.com', 'tapia.rocr', 'YUTnSSH/g=T^', True, '2016-04-06')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (35, 1, '2023-06-22', '2023-08-22', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (35, 2, '2024-12-10', '2025-03-10', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Tamara', 'Luna Romero', 'luna.rota@example.com', 'luna.rota', 'HWX0O"nXT6iR', True, '2022-07-14')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (36, 7, '2024-11-10', '2025-02-10', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Lorena', 'Núñez Grimaldo', 'nunez.grlo@example.com', 'nunez.grlo', '.L4"v[>?|WOk', False, '2019-10-08')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (37, 8, '2024-02-18', '2024-08-18', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (37, 6, '2025-05-18', '2025-07-18', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (37, 5, '2025-09-22', '2025-10-22', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (37, 17, '2025-11-11', '2026-02-11', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Álvaro', 'Manso Montero', 'manso.moal@example.com', 'manso.moal', '\/K0e((mQl^N', False, '2018-08-01')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (38, 12, '2021-10-05', '2022-01-05', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (38, 10, '2021-10-26', '2021-11-26', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (38, 17, '2022-05-18', '2022-08-18', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (38, 12, '2025-03-30', '2025-06-30', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Renata', 'Manso Cervantes', 'manso.cere@example.com', 'manso.cere', 'dK"KC_kZj!Vs', False, '2016-01-31')



    INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Óscar', 'Miranda Aguilera', 'miranda.agos@example.com', 'miranda.agos', 'h[YY4m2~Su#4', True, '2021-11-04')

INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (40, 12, '2021-03-23', '2021-06-23', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Claudia', 'Del Río Soria', 'del_rio.socl@example.com', 'del_rio.socl', 'yv/01.bk.f4{', True, '2018-10-13')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (41, 19, '2017-05-16', '2018-05-16', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (41, 1, '2020-10-04', '2020-12-04', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (41, 3, '2022-04-01', '2022-10-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (41, 10, '2025-08-08', '2025-09-08', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (41, 2, '2025-12-01', '2026-03-01', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Marcos', 'Cárdenas Llamas', 'cardenas.llma@example.com', 'cardenas.llma', '~Lq"wPtS"VDT', True, '2016-10-28')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (42, 7, '2019-01-30', '2019-04-30', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (42, 9, '2020-09-08', '2021-09-08', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (42, 13, '2021-08-06', '2022-02-06', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (42, 7, '2025-08-01', '2025-11-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (42, 18, '2025-08-23', '2026-02-23', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Ramiro', 'Juárez Castillo', 'juarez.cara@example.com', 'juarez.cara', 'y?9*6u:bhHPx', True, '2018-10-27')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (43, 2, '2021-11-17', '2022-02-17', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (43, 9, '2024-10-27', '2025-10-27', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (43, 17, '2025-08-29', '2025-11-29', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Víctor', 'Loyola Flores', 'loyola.flvi@example.com', 'loyola.flvi', '\`fb*B~*Z(1s', True, '2016-01-09')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (44, 11, '2019-07-19', '2019-09-19', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (44, 3, '2023-03-19', '2023-09-19', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (44, 9, '2023-06-07', '2024-06-07', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (44, 12, '2024-10-12', '2025-01-12', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (44, 5, '2025-07-30', '2025-08-30', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (44, 12, '2025-12-28', '2026-03-28', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Marta', 'Juárez Velázquez', 'juarez.vema@example.com', 'juarez.vema', 'z;19g#4Pbv/L', True, '2020-05-02')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (45, 6, '2023-09-06', '2023-11-06', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (45, 8, '2024-05-16', '2024-11-16', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (45, 16, '2025-05-26', '2025-07-26', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (45, 18, '2025-09-06', '2026-03-06', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Jorge', 'Ledesma Solís', 'ledesma.sojo@example.com', 'ledesma.sojo', '((Vn^4$60({r', True, '2024-02-22')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (46, 7, '2016-04-03', '2016-07-03', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Nerea', 'Pineda Moraes', 'pineda.mone@example.com', 'pineda.mone', 'kXK3zy3CTqSg', True, '2024-10-30')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (47, 15, '2021-08-19', '2021-09-19', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (47, 1, '2022-05-02', '2022-07-02', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (47, 11, '2023-09-29', '2023-11-29', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (47, 9, '2023-11-08', '2024-11-08', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (47, 17, '2024-03-10', '2024-06-10', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (47, 14, '2025-07-31', '2026-07-31', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Nerea', 'Aguilera Escudero', 'aguilera.esne@example.com', 'aguilera.esne', 'q:ETfROek+^I', False, '2023-04-11')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (48, 12, '2021-09-18', '2021-12-18', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (48, 14, '2024-03-02', '2025-03-02', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (48, 13, '2024-08-19', '2025-02-19', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (48, 2, '2025-08-24', '2025-11-24', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Daniela', 'Galán Marín', 'galan.mada@example.com', 'galan.mada', 'H,xE!h0y1GEp', True, '2020-10-05')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (49, 5, '2022-03-09', '2022-04-09', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (49, 11, '2025-11-25', '2026-01-25', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Beatriz', 'Aranda Coronel', 'aranda.cobe@example.com', 'aranda.cobe', 'uIdB>|G[3p+0', False, '2024-11-16')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (50, 17, '2022-07-27', '2022-10-27', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (50, 2, '2024-02-28', '2024-05-28', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (50, 9, '2024-04-08', '2025-04-08', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (50, 9, '2025-05-05', '2026-05-05', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Ángela', 'Del Valle Quijano', 'del_valle.quan@example.com', 'del_valle.quan', '%d6-b)gBfZGi', True, '2016-09-23')



    INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Hugo', 'Lombardo Otero', 'lombardo.othu@example.com', 'lombardo.othu', 'Uo$)*/X2!wh9', False, '2025-09-22')

INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (52, 4, '2020-05-09', '2021-05-09', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (52, 7, '2024-07-31', '2024-10-31', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (52, 0, '2025-02-05', '2025-03-05', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (52, 12, '2025-08-04', '2025-11-04', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Víctoria', 'Sáenz Carrillo', 'saenz.cavi@example.com', 'saenz.cavi', 'O@)g|ss6;s\q', True, '2023-05-14')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (53, 11, '2022-06-04', '2022-08-04', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (53, 0, '2025-06-28', '2025-07-28', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Antonio', 'Reina Sierra', 'reina.sian@example.com', 'reina.sian', 'Fmh7[bq#VFRT', True, '2023-06-08')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (54, 1, '2019-01-18', '2019-03-18', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (54, 11, '2023-08-13', '2023-10-13', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (54, 13, '2024-07-08', '2025-01-08', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (54, 14, '2024-09-21', '2025-09-21', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Rocío', 'Del Valle Franco', 'del_valle.frro@example.com', 'del_valle.frro', 'L/=_y8a#XDBk', True, '2022-11-28')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (55, 16, '2018-06-12', '2018-08-12', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Marta', 'Barrera Pérez', 'barrera.pema@example.com', 'barrera.pema', '~F]\nd%|HU`S', False, '2025-03-06')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (56, 2, '2022-04-09', '2022-07-09', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (56, 14, '2025-06-05', '2026-06-05', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Simón', 'Varela Ramírez', 'varela.rasi@example.com', 'varela.rasi', 'fJ1r"6<7IpL&', True, '2017-04-17')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (57, 5, '2020-07-11', '2020-08-11', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (57, 16, '2021-07-03', '2021-09-03', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (57, 14, '2024-05-16', '2025-05-16', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (57, 5, '2024-07-12', '2024-08-12', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (57, 8, '2025-11-22', '2026-05-22', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Raúl', 'Acevedo Gálvez', 'acevedo.gara@example.com', 'acevedo.gara', 'OhYoA$qR2yFU', True, '2018-05-30')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (58, 9, '2018-09-22', '2019-09-22', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (58, 0, '2024-06-03', '2024-07-03', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (58, 1, '2025-05-24', '2025-07-24', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (58, 11, '2025-08-14', '2025-10-14', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (58, 2, '2025-12-04', '2026-03-04', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Valentina', 'Rivas Núñez', 'rivas.nuva@example.com', 'rivas.nuva', 'RU3E-5U#VJv+', False, '2023-08-27')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (59, 2, '2023-02-05', '2023-05-05', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (59, 16, '2024-12-25', '2025-02-25', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (59, 18, '2025-05-11', '2025-11-11', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Domingo', 'Rivas Ponce', 'rivas.podo@example.com', 'rivas.podo', 'F~o<UquNr$T&', True, '2024-04-04')



    INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Paula', 'Padilla Morales', 'padilla.mopa@example.com', 'padilla.mopa', 'fBf#D(BOUn<)', True, '2019-03-19')

INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (61, 15, '2022-03-27', '2022-04-27', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (61, 14, '2025-06-01', '2026-06-01', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Rafael', 'Osorio Grimaldo', 'osorio.grra@example.com', 'osorio.grra', 'G#@y>v5_l>{R', True, '2023-06-01')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (62, 9, '2021-08-27', '2022-08-27', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (62, 14, '2023-01-25', '2024-01-25', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (62, 18, '2023-08-12', '2024-02-12', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (62, 17, '2025-06-16', '2025-09-16', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (62, 4, '2025-06-17', '2026-06-17', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Cristina', 'Meléndez Montes', 'melendez.mocr@example.com', 'melendez.mocr', '\\Qn@l6:40![', True, '2024-11-03')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (63, 14, '2023-03-01', '2024-03-01', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (63, 2, '2025-06-13', '2025-09-13', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (63, 1, '2025-11-14', '2026-01-14', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Tomás', 'Esquivel Calderón', 'esquivel.cato@example.com', 'esquivel.cato', 'H7c>"[)w"Q&h', True, '2024-05-05')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (64, 7, '2019-10-28', '2020-01-28', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (64, 7, '2022-09-01', '2022-12-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (64, 12, '2023-11-21', '2024-02-21', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (64, 6, '2024-12-13', '2025-02-13', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (64, 16, '2025-05-11', '2025-07-11', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Manuel', 'Salazar Rocha', 'salazar.roma@example.com', 'salazar.roma', 'Yis0/Cls#QI!', True, '2018-04-16')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (65, 16, '2025-06-23', '2025-08-23', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (65, 10, '2025-07-13', '2025-08-13', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (65, 17, '2025-10-19', '2026-01-19', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Noelia', 'Sepúlveda Medina', 'sepulveda.meno@example.com', 'sepulveda.meno', 'T#^xxP0zECGM', False, '2018-03-20')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (66, 4, '2022-06-14', '2023-06-14', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (66, 14, '2023-04-29', '2024-04-29', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (66, 15, '2024-09-08', '2024-10-08', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (66, 15, '2025-02-22', '2025-03-22', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (66, 7, '2025-03-22', '2025-06-22', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (66, 0, '2025-05-29', '2025-06-29', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (66, 3, '2025-08-02', '2026-02-02', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Alicia', 'Zapata Arriaga', 'zapata.aral@example.com', 'zapata.aral', 'Pn^{uB:/>HRV', True, '2024-01-16')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (67, 13, '2019-04-22', '2019-10-22', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (67, 11, '2023-05-09', '2023-07-09', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (67, 16, '2024-09-09', '2024-11-09', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (67, 1, '2025-02-06', '2025-04-06', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (67, 8, '2025-03-09', '2025-09-09', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (67, 15, '2025-08-22', '2025-09-22', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (67, 16, '2025-12-31', '2026-02-28', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Florencia', 'Zamora Prado', 'zamora.prfl@example.com', 'zamora.prfl', 'p"Cp0YFvAyX%', False, '2020-09-11')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (68, 13, '2024-07-15', '2025-01-15', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (68, 11, '2025-08-17', '2025-10-17', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (68, 14, '2025-12-14', '2026-12-14', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Mónica', 'Meléndez Bautista', 'melendez.bamo@example.com', 'melendez.bamo', 'D>:aS1@`8nr[', True, '2018-01-14')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (69, 17, '2017-11-28', '2018-02-28', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (69, 15, '2018-10-06', '2018-11-06', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (69, 4, '2022-04-07', '2023-04-07', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (69, 19, '2025-09-15', '2026-09-15', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Sergio', 'Castro Juárez', 'castro.juse@example.com', 'castro.juse', '.-w"<{8p{F;I', True, '2020-07-10')



    INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Renata', 'Acosta Camacho', 'acosta.care@example.com', 'acosta.care', ')D4A|k7D!8C4', True, '2023-06-04')

INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (71, 18, '2021-06-17', '2021-12-17', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (71, 9, '2021-12-06', '2022-12-06', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (71, 15, '2025-04-15', '2025-05-15', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (71, 11, '2025-06-20', '2025-08-20', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (71, 11, '2025-06-26', '2025-08-26', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (71, 10, '2025-10-13', '2025-11-13', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Rodrigo', 'Correa Cuesta', 'correa.curo@example.com', 'correa.curo', 'mCvE,@4jPzQn', True, '2016-12-24')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (72, 14, '2021-04-08', '2022-04-08', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (72, 18, '2023-12-13', '2024-06-13', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (72, 19, '2025-02-17', '2026-02-17', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Sofía', 'Barrera Pardo', 'barrera.paso@example.com', 'barrera.paso', 'iO8>1:n^oPn.', False, '2021-04-11')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (73, 12, '2020-01-28', '2020-04-28', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (73, 15, '2024-01-08', '2024-02-08', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (73, 15, '2024-04-11', '2024-05-11', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (73, 11, '2025-08-02', '2025-10-02', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (73, 17, '2025-09-01', '2025-12-01', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Lucía', 'Paredes Pizarro', 'paredes.pilu@example.com', 'paredes.pilu', '6,0:NC!Rh`.x', False, '2016-09-27')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (74, 9, '2022-08-07', '2023-08-07', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (74, 4, '2025-08-15', '2026-08-15', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Víctoria', 'Garrido Torres', 'garrido.tovi@example.com', 'garrido.tovi', 'miOin-K;"aT~', False, '2023-03-20')



    INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Belén', 'Becerra Sáenz', 'becerra.sabe@example.com', 'becerra.sabe', '*Z{${;"3xPZL', True, '2020-03-03')

INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (76, 16, '2025-05-12', '2025-07-12', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (76, 6, '2025-09-30', '2025-11-30', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Marcos', 'Quintero Navarro', 'quintero.nama@example.com', 'quintero.nama', 'c(:Axjw7"Cv=', False, '2020-06-24')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (77, 3, '2017-08-30', '2018-02-28', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (77, 11, '2018-10-15', '2018-12-15', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (77, 2, '2021-07-18', '2021-10-18', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (77, 14, '2024-09-12', '2025-09-12', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Liliana', 'Barrios Haro', 'barrios.hali@example.com', 'barrios.hali', 'gt=UN^_xnewY', False, '2024-04-29')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (78, 7, '2023-08-14', '2023-11-14', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (78, 10, '2025-11-11', '2025-12-11', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Cristina', 'Fuentes Palomino', 'fuentes.pacr@example.com', 'fuentes.pacr', '*,5gM<SVF7(U', True, '2018-06-24')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (79, 19, '2020-02-01', '2021-02-01', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (79, 18, '2024-10-26', '2025-04-26', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (79, 10, '2025-12-04', '2026-01-04', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Alejandro', 'Segura Aguado', 'segura.agal@example.com', 'segura.agal', '|vzSHu\[TtBq', True, '2025-11-06')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (80, 18, '2020-10-09', '2021-04-09', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (80, 11, '2024-02-25', '2024-04-25', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (80, 4, '2025-09-29', '2026-09-29', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Marta', 'Palma Avila', 'palma.avma@example.com', 'palma.avma', '}W0uyngR"rDy', False, '2016-02-24')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (81, 11, '2024-03-21', '2024-05-21', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (81, 19, '2025-05-02', '2026-05-02', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Ricardo', 'Rivera Álvarez', 'rivera.alri@example.com', 'rivera.alri', 'm0SFJD)6/9jw', True, '2023-07-05')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (82, 4, '2025-12-23', '2026-12-23', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Rafael', 'Rivera Villalobos', 'rivera.vira@example.com', 'rivera.vira', '&mK>HbjGf%e1', False, '2016-04-06')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (83, 1, '2017-12-17', '2018-02-17', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (83, 11, '2025-07-02', '2025-09-02', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (83, 4, '2025-08-12', '2026-08-12', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Ignacio', 'Godoy Toledo', 'godoy.toig@example.com', 'godoy.toig', 'X/qNU5_j!<n"', False, '2020-03-20')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (84, 17, '2016-07-16', '2016-10-16', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (84, 18, '2022-07-06', '2023-01-06', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (84, 6, '2022-11-22', '2023-01-22', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (84, 7, '2023-06-16', '2023-09-16', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (84, 2, '2024-11-13', '2025-02-13', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (84, 3, '2025-10-21', '2026-04-21', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Adrián', 'Rosales Gómez', 'rosales.goad@example.com', 'rosales.goad', 'JxK~"*U9=oR^', False, '2020-06-02')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (85, 1, '2020-05-22', '2020-07-22', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (85, 19, '2021-02-27', '2022-02-27', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (85, 14, '2021-03-03', '2022-03-03', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (85, 6, '2024-06-09', '2024-08-09', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Diego', 'Villanueva Lozano', 'villanueva.lodi@example.com', 'villanueva.lodi', 'C{4sFESwtl@l', True, '2024-11-16')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (86, 16, '2022-12-12', '2023-02-12', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (86, 3, '2023-10-08', '2024-04-08', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Noelia', 'Álvarez Flores', 'alvarez.flno@example.com', 'alvarez.flno', 'mb4Lh}:\vbJ7', True, '2021-05-27')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (87, 14, '2019-05-31', '2020-05-31', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (87, 9, '2020-09-17', '2021-09-17', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (87, 0, '2025-11-01', '2025-12-01', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Claudia', 'Peña Arias', 'pena.arcl@example.com', 'pena.arcl', '`V6$CI]<O]]#', False, '2019-03-30')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (88, 0, '2018-11-27', '2018-12-27', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (88, 13, '2019-01-09', '2019-07-09', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (88, 4, '2022-02-08', '2023-02-08', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (88, 11, '2022-03-21', '2022-05-21', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (88, 5, '2022-08-05', '2022-09-05', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (88, 1, '2024-11-13', '2025-01-13', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (88, 14, '2025-03-07', '2026-03-07', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Nerea', 'Carvajal Del Valle', 'carvajal.dene@example.com', 'carvajal.dene', 's*G;$?nzQczE', False, '2018-08-24')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (89, 7, '2024-05-06', '2024-08-06', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Pedro', 'Arellano Pérez', 'arellano.pepe@example.com', 'arellano.pepe', 'N|dJTfi!ACb{', True, '2025-07-22')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (90, 14, '2019-04-19', '2020-04-19', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (90, 0, '2024-12-24', '2025-01-24', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (90, 2, '2025-08-29', '2025-11-29', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Fernando', 'Suárez Aguado', 'suarez.agfe@example.com', 'suarez.agfe', '~v;PW.<H$<N2', False, '2019-01-20')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (91, 6, '2020-07-22', '2020-09-22', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (91, 13, '2020-10-19', '2021-04-19', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (91, 11, '2024-05-08', '2024-07-08', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (91, 12, '2025-08-18', '2025-11-18', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Fernando', 'Linares Jiménez', 'linares.jife@example.com', 'linares.jife', 'O-y\1{E;%E{Y', True, '2021-08-19')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (92, 14, '2017-08-14', '2018-08-14', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (92, 4, '2021-10-27', '2022-10-27', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (92, 10, '2025-04-16', '2025-05-16', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (92, 1, '2025-06-04', '2025-08-04', false, true);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Paula', 'Chávez Gómez', 'chavez.gopa@example.com', 'chavez.gopa', 'znt0eg;U]F8Q', True, '2021-11-06')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (93, 4, '2023-05-07', '2024-05-07', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (93, 1, '2024-01-27', '2024-03-27', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (93, 9, '2024-05-02', '2025-05-02', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (93, 17, '2024-12-28', '2025-03-28', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (93, 8, '2025-07-26', '2026-01-26', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Andrés', 'Del Ángel Mata', 'del_angel.maan@example.com', 'del_angel.maan', 'G$t3~@lr#l~l', False, '2024-11-07')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (94, 12, '2019-11-27', '2020-02-27', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (94, 3, '2024-03-18', '2024-09-18', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (94, 10, '2024-05-21', '2024-06-21', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (94, 7, '2025-08-21', '2025-11-21', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Mauricio', 'Cortés Espinoza', 'cortes.esma@example.com', 'cortes.esma', 'g^u=G`w}l%Br', True, '2023-05-15')



    INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Marcos', 'Nieto Serrano', 'nieto.sema@example.com', 'nieto.sema', '2~&NIi|O>4"B', False, '2024-07-10')

INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (96, 11, '2023-03-20', '2023-05-20', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (96, 12, '2025-10-06', '2026-01-06', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Francisco', 'Varela Santillán', 'varela.safr@example.com', 'varela.safr', '=zBq<`Ng7#^v', False, '2025-02-24')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (97, 9, '2020-06-16', '2021-06-16', false, false);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (97, 14, '2023-12-13', '2024-12-13', false, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Tomás', 'Palma Llamas', 'palma.llto@example.com', 'palma.llto', '4&BXY{b7Qbl#', True, '2020-07-29')

    INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (98, 12, '2023-05-18', '2023-08-18', false, true);
INSERT INTO membresia (usuario_id, subscripcion_id, fecha_inicio, fecha_fin, activa, cancelado) VALUES (98, 8, '2025-09-10', '2026-03-10', true, false);


INSERT INTO usuarios (nombre, apellidos, email, username, password, activo, fecha_creacion) VALUES ('Javier', 'Reyes Espinoza', 'reyes.esja@example.com', 'reyes.esja', 'WT4_h$TG!lL2', True, '2020-06-26')


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
