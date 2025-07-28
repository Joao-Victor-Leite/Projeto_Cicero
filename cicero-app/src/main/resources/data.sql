INSERT INTO tb_user (name, email, password, created_data, updated_data) VALUES
('João Victor', 'joao@example.com', 'senha123', now(), now()),
('Maria Silva', 'maria@example.com', 'senha456', now(), now()),
('Carlos Souza', 'carlos@example.com', 'senha789', now(), now());

INSERT INTO tb_instinct(name) VALUES
('Reação'),
('Percepção'),
('Sagacidade'),
('Potência'),
('Influência'),
('Resolução');

INSERT INTO tb_knowledge(name) VALUES
('Agrário'),
('Biológico'),
('Exato'),
('Medicina'),
('Social'),
('Artístico');

INSERT INTO tb_practice(name) VALUES
('Esportivas'),
('Ferramentas'),
('Ofícios'),
('Armas'),
('Veículos'),
('Infiltração');


INSERT INTO tb_health (box, description) VALUES
(6, 'Infectado Saudável'),
(5, 'Infectado Ferido'),
(4, 'Infectado -1 Sucesso ou Adaptaçãp'),
(3, 'Infectado -1 Sucesso'),
(2, 'Infectado -2 Sucessos'),
(1, 'Infectado Morto');