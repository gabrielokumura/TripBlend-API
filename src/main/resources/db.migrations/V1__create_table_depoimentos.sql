CREATE TABLE depoimentos (
    id SERIAL PRIMARY KEY,       -- ID único para cada depoimento
    foto TEXT NOT NULL,          -- URL ou caminho para a foto
    depoimento TEXT NOT NULL,    -- Texto do depoimento
    nome VARCHAR(255) NOT NULL,  -- Nome da pessoa que fez o depoimento
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data de criação
    atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- Data de atualização
);
