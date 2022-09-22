INSERT INTO public.cargo (id, activo, nombre) VALUES(1, true, 'Administrador');
INSERT INTO public.region (id, activo, nombre, numero) VALUES(1, true, 'Region Metropolitana', 'XIII');
INSERT INTO public.comunas (activo, nombre, region_id, id) VALUES(true, 'Quilicura', 1, 1);
INSERT INTO public.roles (nombre, id) VALUES('Administrador', 1);
INSERT INTO public.modulos (id, controller, icono, nombre) VALUES(1, '', '1', 'Administracion');
INSERT INTO public.modulos (id, controller, icono, nombre) VALUES(2, '', '2', 'Planificacion');
INSERT INTO public.permisos_globales (modulo_id, rol_id) VALUES(1, 1);
INSERT INTO public.permisos_globales (modulo_id, rol_id) VALUES(1, 2);
INSERT INTO public.permisos_globales (modulo_id, rol_id) VALUES(2, 2);
INSERT INTO public.usuario (activo, apellidos, correo, nombres, password, rut, uid,  id_cargo) VALUES (true, 'Reyes', 'cristian.reyesf@cummins.cl', 'Cristian', '$2a$10$8UqdTKQF6gocj8dXHG3MueY8zdLYfww0E2/1VagS0yCplH/SlrKVG', '2222222-2',  'U1402612',  1);
INSERT INTO public.usuario (activo, apellidos, correo,  nombres, password, rut, uid,  id_cargo) VALUES(true, 'Zuñiga', 'aaron.zuniga@cummins.cl', 'Aaron', '$2a$10$FATtI1Nr/p2O8gYim3.wLupkuMJ85vpWTvL5RQUhKu7CA4qw4IkFK', '3333333-3', 'U1402618',  2);
INSERT INTO public.vistas_group (id, modulo_id, nombre) VALUES (2,'1','Oems');
INSERT INTO public.vistas_group (id, modulo_id, nombre) VALUES (3,'1','Motor');
INSERT INTO public.vistas_group (id, modulo_id, nombre) VALUES (4,'1','Dotación');
INSERT INTO public.vistas_group (id, modulo_id, nombre) VALUES (1,'1','General');


INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (2,'modulos','administracion','Modulos',1);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (3,'vistasgroup','administracion','Grupo de vistas',1);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (4,'region','administracion','Region',1);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (5,'comuna','administracion','comuna',1);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (6,'tipolugartrabajo','administracion','Tipo lugar de trabajo',1);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (7,'pais','administracion','Pais',1);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (1,'vistas','administracón','Vistas',1);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (8,'aplicacion','administracion','Aplicación',3);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (9,'aplicacionoem','administracion','Aplicaciónc oem',2);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (11,'lugardetrabajo','administracion','Lugar de trabajo',1);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (12,'oem','administracion','Oem',2);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (10,'usuarios','administración','usuarios',4);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (13,'cargo','administracion','Cargo',4);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (14,'roles','administracion','Roles',4);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (15,'modulocontrol','administracion','Módulo Control',3);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (16,'tipoadmision','administracion','Tipo Admisión',3);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (17,'tipocombustible','administracion','Tipo Combustible',3);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (18,'tipoemision','administracion','Tipo Emisión',3);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (19,'tipofiltrado','administracion','Tipo Filtrado',3);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (20,'tipoinyeccion','administración','Tipo Inyección',3);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (21,'zona','administración','Zona',1);
INSERT INTO public.vistas (id, accion, controller, nombre, grupo_vistas_id) VALUES (22,'permisosglobales','administracion','Permisos Globales',4);


