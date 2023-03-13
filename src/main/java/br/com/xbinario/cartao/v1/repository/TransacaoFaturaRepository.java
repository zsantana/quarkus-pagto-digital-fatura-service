package br.com.xbinario.cartao.v1.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.xbinario.cartao.v1.entities.TransacaoFaturaEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class TransacaoFaturaRepository implements PanacheRepository<TransacaoFaturaEntity> {
    
    public Uni<TransacaoFaturaEntity> obterFatura(String numeroCartao){
        return find("numeroCartao", numeroCartao).firstResult();
    }
 

}
