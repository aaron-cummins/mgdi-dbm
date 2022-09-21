INSERT INTO public.cargo (id, activo, nombre) VALUES(1, true, 'Administrador');
INSERT INTO public.region (id, activo, nombre, numero) VALUES(1, true, 'Region Metropolitana', 'XIII');
INSERT INTO public.comunas (activo, nombre, region_id, id) VALUES(true, 'Quilicura', 1, 1);
INSERT INTO public.roles (nombre, id) VALUES('Administrador', 1);
INSERT INTO public.modulos (id, controller, icono, nombre) VALUES(1, '', '1', 'Administracion');
INSERT INTO public.modulos (id, controller, icono, nombre) VALUES(2, '', '2', 'Planificacion');
INSERT INTO public.permisos_globales (id_rol, id_modulo, modulo_id, rol_id) VALUES(1, 1, 1, 1);
INSERT INTO public.permisos_globales (id_rol, id_modulo, modulo_id, rol_id) VALUES(2, 2, 2, 2);
INSERT INTO public.usuario (activo, apellidos, correo, nombres, password, rut, uid,  id_cargo) VALUES (true, 'Reyes', 'cristian.reyesf@cummins.cl', 'Cristian', '$2a$10$8UqdTKQF6gocj8dXHG3MueY8zdLYfww0E2/1VagS0yCplH/SlrKVG', '2222222-2',  'U1402612',  1);
INSERT INTO public.usuario (activo, apellidos, correo,  nombres, password, rut, uid,  id_cargo) VALUES(true, 'Zuñiga', 'aaron.zuniga@cummins.cl', 'Aaron', '$2a$10$FATtI1Nr/p2O8gYim3.wLupkuMJ85vpWTvL5RQUhKu7CA4qw4IkFK', '3333333-3', 'U1402618',  2);



