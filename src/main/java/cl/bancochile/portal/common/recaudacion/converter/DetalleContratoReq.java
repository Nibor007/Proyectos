package cl.bancochile.portal.common.recaudacion.converter;

import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrq.mpi.ConsultarCobranzasExternasRq;
import org.springframework.core.convert.converter.Converter;

public class DetalleContratoReq implements Converter<String, ConsultarCobranzasExternasRq> {

    @Override
    public ConsultarCobranzasExternasRq convert(String s) {
        ConsultarCobranzasExternasRq consultarCobranzasExternasRq  = new ConsultarCobranzasExternasRq();
        consultarCobranzasExternasRq.setCodigoEmpresa(s);
        return consultarCobranzasExternasRq;
    }
}
