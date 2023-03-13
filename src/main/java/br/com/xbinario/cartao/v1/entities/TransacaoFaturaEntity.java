package br.com.xbinario.cartao.v1.entities;


import javax.persistence.*;
import org.hibernate.annotations.Immutable;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;



@Entity
@Table(name = "V_LANCAMENTO_FATURA_OFFLOAD", schema = "dbo")
@Immutable
@Cacheable
public class TransacaoFaturaEntity extends PanacheEntity{

	@Column(name = "sequenciaLancamento", updatable = false, insertable = false)
	public Integer sequenciaLancamento;

	@Column(name = "numeroContaCartao", updatable = false, insertable = false)
	public String numeroContaCartao;
	
	@Column(name = "numeroCartao", updatable = false, insertable = false)
	public String numeroCartao;

	@Column(name = "cpfCnpj", updatable = false, insertable = false)
	public String cpfCnpj;

	@Column(name = "codigoMoeda", updatable = false, insertable = false)
	public String codigoMoeda;

	@Column(name = "dataLancamento", updatable = false, insertable = false)
	public String dataLancamento;

	@Column(name = "descricaoLancamento", updatable = false, insertable = false)
	public String descricaoLancamento;

	@Column(name = "numeroParcela", updatable = false, insertable = false)
	public String numeroParcela;

	@Column(name = "totalParcelas", updatable = false, insertable = false)
	public String totalParcelas;

	@Column(name = "valorDolar", updatable = false, insertable = false)
	public String valorDolar;

	@Column(name = "valorReal", updatable = false, insertable = false)
	public String valorReal;

	@Column(name = "cotacaoDolar", updatable = false, insertable = false)
	public String cotacaoDolar; 

	@Column(name = "valorOrigem", updatable = false, insertable = false)
	public String valorOrigem;

	@Column(name = "codigoMoedaAlf", updatable = false, insertable = false)
	public String codigoMoedaAlf; 

	@Column(name = "tipoLancamento", updatable = false, insertable = false)
	public String tipoLancamento;

	@Column(name = "ramoAtividade", updatable = false, insertable = false)
	public String ramoAtividade;

	@Column(name = "codigoAutorizacao", updatable = false, insertable = false)
	public String codigoAutorizacao;

	@Column(name = "chaveTransacao", updatable = false, insertable = false)
	public String chaveTransacao;

	@Column(name = "codigoAgrupado", updatable = false, insertable = false)
	public String codigoAgrupado;
    
}