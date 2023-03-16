package br.com.xbinario.cartao.service;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;

import org.junit.jupiter.api.Test;

import br.com.xbinario.cartao.container.PostgresResource;
import br.com.xbinario.cartao.v1.dto.request.RequisicaoDTO;
import br.com.xbinario.cartao.v1.dto.response.ResultadoDTO;
import br.com.xbinario.cartao.v1.service.TransacaoFaturaService;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
@QuarkusTestResource(PostgresResource.class)
public class TransacaoFaturaServiceTest {

    @Inject
    TransacaoFaturaService service;

    @Test
    public void testObterFatura() {
        RequisicaoDTO requisicaoDTO = new RequisicaoDTO("123", "123");

        Uni<ResultadoDTO> resultadoDTOUni = service.obterFatura(requisicaoDTO);
        assertNotNull(resultadoDTOUni);
        
        ResultadoDTO resultadoDTO = resultadoDTOUni.await().indefinitely();
        
        assertNotNull(resultadoDTO);
        assertEquals("123", resultadoDTO.getNumeroCartao());
        assertEquals("123", resultadoDTO.getCpfCnpj());
    }

}


    
