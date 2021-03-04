package cl.bancochile.portal.common.recaudacion.service;


import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrs.mpi.ConsultarCobranzasExternasRs;
import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrs.mpi.DatoAdicional;
import cl.bancochile.portal.common.recaudacion.domain.CampoAdicional;
import cl.bancochile.portal.common.recaudacion.domain.DataAdicional;
import cl.bancochile.portal.common.recaudacion.domain.DetalleContrato;
import cl.bancochile.portal.common.recaudacion.domain.enums.TipoDatoEnum;
import cl.bancochile.portal.common.recaudacion.sal.ClienteWSDetalleContrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetalleContratoServiceImpl implements DetalleContratoService {

    private static final String CAMPO_NUMERICO = "9";

    @Autowired
    private ClienteWSDetalleContrato clienteWSDetalleContrato;

    @Override
    public DetalleContrato obtenerDetalleContrato(String codigoConvenio, String rut){
        DetalleContrato detalleContrato = clienteWSDetalleContrato.clienteObtenerDetalleContrato(codigoConvenio,rut);
        detalleContrato.setDataAdicional(obtenerDataAdicional(codigoConvenio, rut));
        return detalleContrato;
    }

    @Override
    public ConsultarCobranzasExternasRs clienteObtenerDetalleContratoResponse(String codigoConvenio, String rut) {
        return clienteWSDetalleContrato.clienteObtenerDetalleContratoResponse(codigoConvenio, rut);
    }

    @Override
    public String obtenerOficinaDetalleContrato(String codigoConvenio, String rut) {
        return clienteWSDetalleContrato.obtenerOficinaDetalleContrato(codigoConvenio,rut);
    }

    @Override
    public DataAdicional obtenerDataAdicional(String codigoConvenio, String rut) {
        DataAdicional dataAdicional = new DataAdicional();
        ConsultarCobranzasExternasRs contratoResponseRs = clienteWSDetalleContrato.clienteObtenerDetalleContratoResponse(codigoConvenio, rut);

        if(contratoResponseRs != null &&
                contratoResponseRs.getServicio() != null &&
                contratoResponseRs.getServicio().getDatosAdicionales() != null){

            List<CampoAdicional> datosAdicionales = new ArrayList<>();
            Integer countDatosAdiconales = 0;
            for (DatoAdicional itDaAdicioal: contratoResponseRs.getServicio().getDatosAdicionales().getDatoAdicional()){
                CampoAdicional campoAdicional = new CampoAdicional();
                campoAdicional.setGlosa(itDaAdicioal.getGlosa());
                campoAdicional.setLargo(String.valueOf(itDaAdicioal.getLargo().intValue()));
                campoAdicional.setRutinaValidacion(itDaAdicioal.getRutinaValidacion());
                campoAdicional.setRutinaServidor(itDaAdicioal.getRutinaServidor());
                campoAdicional.setTipoDato(itDaAdicioal.getTipo().equals(CAMPO_NUMERICO) ? TipoDatoEnum.NUMERICO : TipoDatoEnum.ALFANUMERICO);
                countDatosAdiconales += itDaAdicioal.getLargo().intValue();
                datosAdicionales.add(campoAdicional);
            }
            dataAdicional.setLargoDataAdicional(countDatosAdiconales.toString());
            dataAdicional.setDatosAdicionales(datosAdicionales);
            return dataAdicional;
        }else {
            return dataAdicional;
        }
    }
}
