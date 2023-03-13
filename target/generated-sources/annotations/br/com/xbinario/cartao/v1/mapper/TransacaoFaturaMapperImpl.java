package br.com.xbinario.cartao.v1.mapper;

import br.com.xbinario.cartao.v1.dto.response.ResultadoDTO;
import br.com.xbinario.cartao.v1.entities.TransacaoFaturaEntity;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-13T19:52:32-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Private Build)"
)
@ApplicationScoped
public class TransacaoFaturaMapperImpl implements TransacaoFaturaMapper {

    @Override
    public ResultadoDTO toDTO(TransacaoFaturaEntity dao) {
        if ( dao == null ) {
            return null;
        }

        ResultadoDTO resultadoDTO = new ResultadoDTO();

        resultadoDTO.setSequenciaLancamento( dao.sequenciaLancamento );
        resultadoDTO.setNumeroContaCartao( dao.numeroContaCartao );
        resultadoDTO.setNumeroCartao( dao.numeroCartao );
        resultadoDTO.setCpfCnpj( dao.cpfCnpj );
        resultadoDTO.setCodigoMoeda( dao.codigoMoeda );
        resultadoDTO.setDataLancamento( dao.dataLancamento );
        resultadoDTO.setDescricaoLancamento( dao.descricaoLancamento );
        resultadoDTO.setNumeroParcela( dao.numeroParcela );
        resultadoDTO.setTotalParcelas( dao.totalParcelas );
        resultadoDTO.setValorDolar( dao.valorDolar );
        resultadoDTO.setValorReal( dao.valorReal );
        resultadoDTO.setCotacaoDolar( dao.cotacaoDolar );
        resultadoDTO.setValorOrigem( dao.valorOrigem );
        resultadoDTO.setCodigoMoedaAlf( dao.codigoMoedaAlf );
        resultadoDTO.setTipoLancamento( dao.tipoLancamento );
        resultadoDTO.setRamoAtividade( dao.ramoAtividade );
        resultadoDTO.setCodigoAutorizacao( dao.codigoAutorizacao );
        resultadoDTO.setChaveTransacao( dao.chaveTransacao );
        resultadoDTO.setCodigoAgrupado( dao.codigoAgrupado );

        return resultadoDTO;
    }
}
