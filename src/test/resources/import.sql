CREATE TABLE dbo.T_LANCAMENTO_FATURA(
	id int  NOT NULL,
	numeroContaCartao varchar(16) NULL,
	numeroCartao varchar(16) NULL,
	cpfCnpj varchar(15) NULL,
	codigoMoeda varchar(50) NULL,
	dataLancamento varchar(50) NULL,
	descricaoLancamento varchar(50) NULL,
	numeroParcela varchar(50) NULL,
	totalParcelas varchar(50) NULL,
	valorDolar varchar(50) NULL,
	valorReal varchar(50) NULL,
	cotacaoDolar varchar(50) NULL,
	valorOrigem varchar(50) NULL,
	codigoMoedaAlf varchar(50) NULL,
	tipoLancamento varchar(50) NULL,
	ramoAtividade varchar(50) NULL,
	codigoAutorizacao varchar(50) NULL,
	chaveTransacao varchar(50) NULL,
	codigoAgrupado varchar(50) NULL,
	dataVencimento date NULL
);


INSERT INTO dbo.T_LANCAMENTO_FATURAX
	(numeroContaCartao,numeroCartao,cpfCnpj,codigoMoeda,dataLancamento,descricaoLancamento,numeroParcela,totalParcelas,valorDolar,valorReal,cotacaoDolar,valorOrigem,codigoMoedaAlf,tipoLancamento,ramoAtividade,codigoAutorizacao,chaveTransacao,codigoAgrupado,dataVencimento)
VALUES
    ( "374758999991392",	"374758003377919",	"42782078089",	"986",	"Dez  7 2022 12:00AM", 	"SEGURO SUPERPROTEGIDO",	0,	0,	0,	9.99,	0,	0,	"BRL",	0,	"0999", "F2022120805374758999991392 00000006OFFE25001",	"0000",	"2022-12-20");


CREATE OR ALTER VIEW V_LANCAMENTO_FATURA_OFFLOAD AS
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