package cl.bancochile.portal.common.recaudacion.service;

import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrs.mpi.ConsultarCobranzasExternasRs;
import cl.bancochile.portal.common.recaudacion.exception.TraducibleSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacionesCuotaServiceImpl implements OperacionesCuotaService{

    @Autowired
    private DetalleContratoService detalleContratoService;

    private static final String FUN_DEFINIDO_PROPIO = "1";
    private static final String FUN_DEFINIDO_BANCO= "0";
    private static final String VACIO = "";

    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionesCuotaServiceImpl.class);


    @Override
    public Boolean tieneFun(String codigoConvenio, String rut) {
        ConsultarCobranzasExternasRs rs = detalleContratoService.clienteObtenerDetalleContratoResponse(codigoConvenio, rut);
        if (rs.getRendicion() != null &&
                rs.getRendicion().getEspecial7() != null &&
                !(VACIO).equals(rs.getRendicion().getEspecial7()) &&
                tienePatronFun(rs.getRendicion().getEspecial7())) {

            String tieneFun = getFunDetalle(rs.getRendicion().getEspecial7());
            return tieneFun.equals(FUN_DEFINIDO_PROPIO);
        } else {
            String msnError = "error al FUN no definido en el contrato";
            LOGGER.error(msnError);
            throw new TraducibleSystemException(msnError);
        }
    }


    private boolean tienePatronFun(String filler){
        return getFunDetalle(filler).equals(FUN_DEFINIDO_PROPIO) || getFunDetalle(filler).equals(FUN_DEFINIDO_BANCO);
    }

    private String getFunDetalle(String filler){
        return filler.substring(3,4);
    }
}
