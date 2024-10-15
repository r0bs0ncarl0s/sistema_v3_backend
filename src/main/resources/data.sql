INSERT INTO RCF_USUARIO (ID, NOME, LOGIN, SENHA, EMAIL, SITUACAO) VALUES (1, 'Administrador', 'admin', '$2a$10$O2Icqgiowk.WRdug4/Aj0efI5ZUEaQB3j4wPYYU9f9yuPQNsXX4oy','administrador@gmail.com', 'ATIVO');
INSERT INTO RCF_COMUNICA (ID, TITULO, DESCRICAO, DT_CADASTRO) VALUES (1, 'Primeiro Comunicado', 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC', CURRENT_TIMESTAMP);

INSERT INTO RCF_PERFIL (ID, DESCRICAO) VALUES (1, 'Administrador');
INSERT INTO RCF_PERFIL (ID, DESCRICAO) VALUES (2, 'Gerente');
INSERT INTO RCF_PERFIL (ID, DESCRICAO) VALUES (3, 'Cliente');

INSERT INTO RCF_RECURSO (ID, NOME, CHAVE) VALUES (1, 'Tela Usuário', 'usuario');
INSERT INTO RCF_RECURSO (ID, NOME, CHAVE) VALUES (2, 'Tela Perfil', 'perfil');
INSERT INTO RCF_RECURSO (ID, NOME, CHAVE) VALUES (3, 'Tela Recurso', 'recurso');

ALTER SEQUENCE rcf_usuario_id_seq RESTART WITH 2;
ALTER SEQUENCE rcf_comunica_id_seq RESTART WITH 2;
ALTER SEQUENCE rcf_perfil_seq RESTART WITH 4;
ALTER SEQUENCE rcf_recurso_seq RESTART WITH 4;

ALTER SEQUENCE IF EXISTS rcf_usuario_id_seq INCREMENT 1;
ALTER SEQUENCE IF EXISTS rcf_comunica_id_seq INCREMENT 1;
ALTER SEQUENCE IF EXISTS rcf_perfil_seq INCREMENT 1;
ALTER SEQUENCE IF EXISTS rcf_recurso_seq INCREMENT 1;
