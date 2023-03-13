package br.com.xbinario.cartao.v1.controller;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.xbinario.cartao.v1.dto.request.RequisicaoDTO;
import br.com.xbinario.cartao.v1.dto.response.ResultadoDTO;
import br.com.xbinario.cartao.v1.service.TransacaoFaturaService;
import io.smallrye.mutiny.Uni;



@Path("/credit-cards-accounts/api/v1")
public class TransacaoFaturaController {

    //private static final Logger logger = LoggerFactory.getLogger(TransacaoFaturaOffLoadController.class);
    //private static final String msg_erro = "Transação não encontrada";

    @Inject
    TransacaoFaturaService service;


    @GET
    //@RolesAllowed("FaturaTransacao")
    @Path("/accounts/{creditCardNumber}/{cpfNumber}/transactions")
    @Produces(MediaType.APPLICATION_JSON)
    @Tag(name = "Transações da Fatura (MIS021)",  
         description = "Obtém os dados das transações de uma fatura identificada por creditCardAccountNumber (Número Conta Cartão) , creditCardNumber (Conta cartão), cpfNumber (cpfCnpj) e billingDate (Data de Faturamento)")
    @APIResponses({
        @APIResponse(responseCode = "200", description = "Transações de uma Fatura localizado com sucesso."),
        @APIResponse(responseCode = "422", description = "Erro na conversão do JSON"),
    })

    @Counted(name = "Counted.obterTransacao", 
            tags = {"servico=obterTransacao"},
            description = "Total de Chamadas do enpoint"
            )

    @Timed(name = "Timed.obterTransacao", 
            tags = {"servico=obterTransacao"},
            description = "Tempo medio das requisicoes.", 
            unit = MetricUnits.MILLISECONDS)

    @Retry(maxRetries = 3, delay = 2000)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 5000, successThreshold = 2)
    
    public Uni<ResultadoDTO> obterTransacao(@Parameter(description="Número do cartão", required = true)
                                                     @PathParam("creditCardNumber") String contaCartao,
                                                            
                                                     @Parameter(description="Número do CPF", required = true)
                                                     @PathParam("cpfNumber") String cpfCnpj
                                                     ) {

        var requestDTO = new RequisicaoDTO(contaCartao, cpfCnpj);
        var responseDTO = service.obterFatura(requestDTO);

        return responseDTO;
        
    }


    
    @DELETE
    @RolesAllowed("FaturaTransacao")
    @Path("/accounts/{creditCardAccountId}/{creditCardAccountNumber}/{billingDate}/transactions")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Tag(name = "Transações de fatura (MIS021)", 
        description = "Exclui uma transação de uma fatura identificada por creditCardAccountNumber (Número Conta Cartão) , creditCardAccountId (Conta cartão) e billingDate (Data de Faturamento)")
    @Retry(maxRetries = 3, delay = 2000)
    public Response excluir(@PathParam("numeroContaCartao") String numeroContaCartao){
        return Response.ok().build();
    }    
    
}
