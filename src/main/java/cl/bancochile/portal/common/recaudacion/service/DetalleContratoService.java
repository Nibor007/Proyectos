package cl.bancochile.portal.common.recaudacion.service;


import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrs.mpi.ConsultarCobranzasExternasRs;
import cl.bancochile.portal.common.recaudacion.domain.DataAdicional;
import cl.bancochile.portal.common.recaudacion.domain.DetalleContrato;

public interface DetalleContratoService {

    DetalleContrato obtenerDetalleContrato(String codigoConvenio, String rut);
    ConsultarCobranzasExternasRs clienteObtenerDetalleContratoResponse(String codigoConvenio, String rut);
    String obtenerOficinaDetalleContrato(String codigoConvenio, String rut);
    DataAdicional obtenerDataAdicional(String codigoConvenio, String rut);

}
