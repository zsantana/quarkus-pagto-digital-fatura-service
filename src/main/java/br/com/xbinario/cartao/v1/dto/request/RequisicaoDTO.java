package br.com.xbinario.cartao.v1.dto.request;


import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class RequisicaoDTO {
   
    private final String numeroCartao;
    private final String cpfCnpj;

    public RequisicaoDTO(String numeroCartao, 
                         String cpfCnpj) {

        this.numeroCartao = numeroCartao;
        this.cpfCnpj = cpfCnpj;

    }

}

