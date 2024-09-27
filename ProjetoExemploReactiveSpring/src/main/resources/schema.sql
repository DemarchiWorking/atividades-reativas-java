CREATE TABLE IF NOT EXISTS produtos (
                                        id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                        nome VARCHAR(90) NOT NULL,
                                        preco DECIMAL(10, 2) NOT NULL,
                                        descricao VARCHAR(190),
                                        foto VARCHAR(90)
                                    );