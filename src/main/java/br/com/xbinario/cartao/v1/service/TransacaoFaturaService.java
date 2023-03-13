package br.com.xbinario.cartao.v1.service;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.xbinario.cartao.v1.dto.request.RequisicaoDTO;
import br.com.xbinario.cartao.v1.dto.response.ResultadoDTO;
import br.com.xbinario.cartao.v1.mapper.TransacaoFaturaMapper;
import br.com.xbinario.cartao.v1.repository.TransacaoFaturaRepository;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class TransacaoFaturaService {

    @Inject
    TransacaoFaturaRepository repo;

    @Inject
    TransacaoFaturaMapper mapper;

    //@CacheResult(cacheName = "transacao-offload-v1") 
    public Uni<ResultadoDTO> obterFatura(RequisicaoDTO requisicaoDTO) {
        return repo.obterFatura(requisicaoDTO.getNumeroCartao()).map(m -> mapper.toDTO(m));
    }
    
}
