create schema dbo;



CREATE TABLE dbo.T_LANCAMENTO_FATURA(
	id integer NOT NULL,
    numerocontacartao character varying(255) COLLATE pg_catalog."default",
    numerocartao character varying(255) COLLATE pg_catalog."default",
    cpfcnpj character varying(255) COLLATE pg_catalog."default",
    codigomoeda character varying(255) COLLATE pg_catalog."default",
    datalancamento character varying(255) COLLATE pg_catalog."default",
    descricaolancamento character varying(255) COLLATE pg_catalog."default",
    numeroparcela character varying(255) COLLATE pg_catalog."default",
    totalparcelas character varying(255) COLLATE pg_catalog."default",
    valordolar character varying(255) COLLATE pg_catalog."default",
    valorreal character varying(255) COLLATE pg_catalog."default",
    cotacaodolar character varying(255) COLLATE pg_catalog."default",
    valororigem character varying(255) COLLATE pg_catalog."default",
    codigomoedaalf character varying(255) COLLATE pg_catalog."default",
    tipolancamento character varying(255) COLLATE pg_catalog."default",
    ramoatividade character varying(255) COLLATE pg_catalog."default",
    codigoautorizacao character varying(255) COLLATE pg_catalog."default",
    chavetransacao character varying(255) COLLATE pg_catalog."default",
    codigoagrupado character varying(255) COLLATE pg_catalog."default",
    datavencimento date,
    CONSTRAINT t_lancamento_fatura_pkey PRIMARY KEY (id)
);


CREATE SEQUENCE IF NOT EXISTS dbo.t_lancamento_fatura_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY dbo.t_lancamento_fatura.id;


INSERT INTO dbo.T_LANCAMENTO_FATURA(id, numeroContaCartao, numeroCartao, cpfCnpj)
VALUES( 1, '123', '123', '123');


CREATE OR REPLACE VIEW dbo.V_LANCAMENTO_FATURA_OFFLOAD AS
SELECT  1 as id,
		1 as  sequenciaLancamento,
		t1.numeroContaCartao as numeroContaCartao,
		t1.numeroCartao as numeroCartao,
		t1.cpfCnpj as cpfCnpj,
		t1.codigoMoeda,
		t1.dataLancamento as dataLancamento,
		t1.descricaoLancamento,
		t1.numeroParcela,
		t1.totalParcelas,
		t1.valorDolar as  valorDolar, 
		t1.valorReal,
		t1.cotacaoDolar, 
		t1.valorOrigem as valorOrigem,
		t1.codigoMoedaAlf, 
		t1.tipoLancamento,
		t1.ramoAtividade,
		t1.codigoAutorizacao,
		t1.chaveTransacao,
		t1.codigoAgrupado,
		t1.dataVencimento

FROM dbo.T_LANCAMENTO_FATURA t1;