drop table if exists alumno;
drop table if exists proyectoIntegrador;
drop table if exists areas;
drop table if exists administrado;

create table areas (
    codigo int auto_increment primary key,
    nombre varchar(30),
    descripcion varchar(50)
);

create table proyectoIntegrador (
    idProyecto int(5) primary key not null,
    nombreProyecto varchar(30),
    urlProyecto varchar(100),
    nota varchar(4),
    fecha varchar(4),
    curso varchar(4),
    grupo varchar(50),
    areaCorrespondiente int,
    constraint proyecto_area_fk foreign key (areaCorrespondiente) references areas(codigo)
);

create table alumno (
    numExpediente int(5)primary key,
    codigo int(5),
    nombre varchar(20),
    apellidos varchar(20),
    idProyecto int (5), 
    constraint idProyecto_fk foreign key (idProyecto) references proyectoIntegrador (idProyecto)
);

create table administrado (
    idAdministrador int(5) primary key,
    username varchar(20),
    pass varchar(20)
);


INSERT INTO areas (nombre, descripcion) VALUES ('DAW', 'Desarrollo de Aplicaciones Web');
INSERT INTO areas (nombre, descripcion) VALUES ('DAM', 'Desarrollo de Aplicaciones Multiplataforma');
INSERT INTO areas (nombre, descripcion) VALUES ('ASIR','Administración de Sistemas Informáticos en Red');

INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente)
VALUES (1, 'Los Pandas', 'https://github.com/Proyecto_Integrador1.git', 8.5, '2023', 2, 'Grupo PAC', 1);
INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente)
VALUES (2, 'POICS', 'https://github.com/Proyecto_Integrador2.git', 9, '2023', 2, 'Grupo Energía Creativa', 2);
INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente)
VALUES (3, 'Koffee', 'https://github.com/Proyecto_Integrador3.git', 7.5, '2023', 2, 'Grupo Mentes Alquímicas', 3);
INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente)
VALUES (4, 'Jesucristo', 'https://github.com/Proyecto_Integrador4.git', 5, '2023', 2, 'Grupo Los Visionarios', 2);
INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente)
VALUES (5, 'Aris', 'https://github.com/Proyecto_Integrador5.git', 10, '2023', 2, 'Grupo PAC', 1);
INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente)
VALUES (6, 'Racoon', 'https://github.com/Proyecto_Integrador6.git', 4, '2023', 2, 'Grupo Los Cazadores de Tesoros', 2);
INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente)
VALUES (7, 'Roquitas', 'https://github.com/Proyecto_Integrador7.git', 6, '2023', 2, 'Grupo Los Soñadores Perdidos', 3);
INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente)
VALUES (8, 'LOLS', 'https://github.com/Proyecto_Integrador8.git', 9.5, '2023', 2, 'Grupo Los Buscadores de la Verdad', 2);
INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente)
VALUES (9, 'Miss Fortune', 'https://github.com/Proyecto_Integrador9.git', 8.5, '2023', 2, 'Grupo Los Maestros del Sonido', 1);
INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente)
VALUES (10, 'Ahri', 'https://github.com/Proyecto_Integrador10.git', 9, '2023', 2, 'Grupo Los Aventureros del Bosque Encantado', 2);

INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (1, 11122, 'Amelia María', 'Coca López', 1);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (2, 22233, 'Juan', 'Cortés Cortés', 1);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (3, 33344, 'Paula', 'Moure Prado', 1);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (6, 66677, 'James Andrew', 'BEHAN', 2);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (7, 77788, 'Ismael', 'Bodas Díaz', 2);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (8, 88899, 'Jorge', 'Burgos Barrera', 2);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (9, 99900, 'Ali', 'Chalak', 3);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (10, 10011, 'JAVIER', 'Chicano Miguel' ,3);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (11, 11022, 'Santiago Andres', 'Daza Villamizar',3);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (12, 12233, 'Amir Mahdi', 'Dorrani',4);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (13, 13344, 'Aarón Juan', 'Escudero Navas',4);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (14, 14455, 'Daniel', 'Garrido Nuñez',4);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (15, 15566, 'Daniel', 'Herrero Martínez',5);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (16, 16677, 'Alejandro', 'Junyent Romani',5);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (17, 17788, 'Aris', 'Maximilian Kuhs',5);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (18, 18899, 'Lucca', 'Manfredotti García',6);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (19, 19900, 'Ismael', 'Moreno Moral',6);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (20, 20011, 'Juan Diego', 'Motta Moncada',6);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (21, 21122, 'Pablo', 'Naranjo Cid',7);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (22, 22234, 'David', 'Oñate Sánchez',7);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (23, 23344, 'Mario', 'Robles Padua',7);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (24, 24455, 'Gabriel Enrique', 'Rodríguez Padrón',8);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (25, 25566, 'David', 'Rojo Villalba',8);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (26, 26677, 'Celia', 'Rubio Pais',8);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (27, 27788, 'Miguel', 'Sánz Villanueva',9);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (28, 28899, 'Elena', 'Saugar Mayoral',9);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (29, 29900, 'Álvaro', 'Serrano Colomer',9);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (30, 30011, 'Josep', 'Serrano Rayó',10);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (31, 31122, 'Wei', 'Xu',10);
INSERT INTO alumno (codigo, numExpediente, nombre, apellidos, idProyecto) VALUES (32, 32233, 'Guoanqi', 'Yin',10);

INSERT INTO administrado (idAdministrador, username, pass) VALUES (0512, 'SaraV', '1211');
INSERT INTO administrado (idAdministrador, username, pass) VALUES (4321, 'RaquelC', '0000');
