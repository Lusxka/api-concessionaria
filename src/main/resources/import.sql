-- Clientes
INSERT INTO cliente (id, nome, cpf, endereco, telefone) VALUES (1, 'João Silva', '123.456.789-00', 'Rua A, 123', '(11) 99999-0001');
INSERT INTO cliente (id, nome, cpf, endereco, telefone) VALUES (2, 'Maria Souza', '987.654.321-00', 'Rua B, 456', '(11) 99999-0002');

-- Carros (com 'preco')
INSERT INTO carro (id, marca, modelo, ano, preco) VALUES (1, 'Fiat', 'Uno', 2010, 25000.00);
INSERT INTO carro (id, marca, modelo, ano, preco) VALUES (2, 'Volkswagen', 'Gol', 2015, 32000.00);

-- Vendas (com 'valor' obrigatoriamente incluído)
INSERT INTO venda (id, data, cliente_id, carro_id, valor) VALUES (1, '2024-01-10', 1, 2, 32000.00);
INSERT INTO venda (id, data, cliente_id, carro_id, valor) VALUES (2, '2024-02-15', 2, 1, 25000.00);
