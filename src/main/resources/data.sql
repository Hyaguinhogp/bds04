INSERT INTO tb_user(name, password) VALUES ('Hyago Matos', '$2a$10$nvfsbayBzDuOiUvz2ntB6uy1gY8iHrYivDaPc2oD22vp6g0DFwZoC');
INSERT INTO tb_user(name, password) VALUES ('Hyane Matos', '$2a$10$4uZFMoNdOnB.zAgbup4ZbO4irT..rPUiNKWV/UlEhsjzPGiPEjeYu');
INSERT INTO tb_user(name, password) VALUES ('ana@gmail.com', '$2y$12$cNRo58aDhAfSFjRsNL9Mpu6djXToF5a8MmupssFM4/szAHkte1KgC');
INSERT INTO tb_user(name, password) VALUES ('bob@gmail.com', '$2y$12$cNRo58aDhAfSFjRsNL9Mpu6djXToF5a8MmupssFM4/szAHkte1KgC');

INSERT INTO tb_role(authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role(authority) VALUES ('ROLE_CLIENT');

INSERT INTO tb_user_role(user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role(user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role(user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role(user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role(user_id, role_id) VALUES (4, 1);
INSERT INTO tb_user_role(user_id, role_id) VALUES (4, 2);

INSERT INTO tb_city(name) VALUES ('São Paulo');
INSERT INTO tb_city(name) VALUES ('Brasília');
INSERT INTO tb_city(name) VALUES ('Fortaleza');
INSERT INTO tb_city(name) VALUES ('Salvador');
INSERT INTO tb_city(name) VALUES ('Manaus');
INSERT INTO tb_city(name) VALUES ('Curitiba');
INSERT INTO tb_city(name) VALUES ('Goiânia');
INSERT INTO tb_city(name) VALUES ('Belém');
INSERT INTO tb_city(name) VALUES ('Porto Alegre');
INSERT INTO tb_city(name) VALUES ('Rio de Janeiro');
INSERT INTO tb_city(name) VALUES ('Belo Horizonte');

INSERT INTO tb_event(name, date, url, city_id) VALUES ('Feira do Software', '2021-05-16', 'https://feiradosoftware.com', 1);
INSERT INTO tb_event(name, date, url, city_id) VALUES ('CCXP', '2021-04-13', 'https://ccxp.com.br', 1);
INSERT INTO tb_event(name, date, url, city_id) VALUES ('Congresso Linux', '2021-05-23', 'https://congressolinux.com.br', 2);
INSERT INTO tb_event(name, date, url, city_id) VALUES ('Semana Spring React', '2021-05-03', 'https://devsuperior.com.br', 3);
