package br.com.xbinario.cartao.v1.mapper;

import org.mapstruct.*;

import br.com.xbinario.cartao.v1.dto.response.ResultadoDTO;
import br.com.xbinario.cartao.v1.entities.TransacaoFaturaEntity;


@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransacaoFaturaMapper {

    ResultadoDTO toDTO( TransacaoFaturaEntity dao);
    
}
