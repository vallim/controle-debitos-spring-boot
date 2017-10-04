CREATE TABLE debito (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    descricao VARCHAR(255),
    valor NUMERIC(10,2) NOT NULL,
    vencimento DATE NOT NULL,
    pago BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE INDEX debito_vencimento_idx on debito(vencimento);