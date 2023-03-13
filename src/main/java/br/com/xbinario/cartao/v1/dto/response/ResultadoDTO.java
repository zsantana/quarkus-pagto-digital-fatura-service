package br.com.xbinario.cartao.v1.dto.response;


import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class ResultadoDTO {
   
	private Integer sequenciaLancamento;
	private String numeroContaCartao;
	private String numeroCartao;
	private String cpfCnpj;
	private String codigoMoeda;
	private String dataLancamento;
	private String descricaoLancamento;
	private String numeroParcela;
	private String totalParcelas;
	private String valorDolar;
	private String valorReal;
	private String cotacaoDolar; 
	private String valorOrigem;
	private String codigoMoedaAlf; 
	private String tipoLancamento;
	private String ramoAtividade;
	private String codigoAutorizacao;
	private String chaveTransacao;
	private String codigoAgrupado;
    
}

