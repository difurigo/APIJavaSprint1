
INSERT INTO colaboradores (id, nome, email, senha) VALUES
(1, 'João Silva', 'joao@email.com', '123'),
(2, 'Maria Souza', 'maria@email.com', 'abc'),
(3, 'Pedro Lima', 'pedro@email.com', 'senha'),
(4, 'Ana Costa', 'ana@email.com', '12345'),
(5, 'Lucas Rocha', 'lucas@email.com', 'pass');

INSERT INTO log_movimentacao (id, colaborador_id, data, descricao) VALUES
(1, 1, CURRENT_DATE, 'Chegada'),
(2, 2, CURRENT_DATE, 'Saída'),
(3, 1, CURRENT_DATE, 'Pausa'),
(4, 3, CURRENT_DATE, 'Retorno'),
(5, 4, CURRENT_DATE, 'Almoço');
