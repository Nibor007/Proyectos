package cl.bancochile.portal.common.recaudacion.sal;

import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrs.mpi.ConsultarCobranzasExternasRs;
import cl.bancochile.portal.common.recaudacion.domain.DetalleContrato;


public interface ClienteWSDetalleContrato {

    DetalleContrato clienteObtenerDetalleContrato(String codigoConvenio, String rut);
    ConsultarCobranzasExternasRs clienteObtenerDetalleContratoResponse(String codigoConvenio, String rut);
    String obtenerOficinaDetalleContrato(String codigoConvenio, String rut);

}
