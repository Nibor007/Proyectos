package cl.bancochile.portal.common.recaudacion.sal;

import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrq.mpi.ConsultarCobranzasExternasRq;
import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrs.mpi.ConsultarCobranzasExternasRs;
import cl.bancochile.osb.neg.pagos.cobranzaexterna.v._1.CobranzaExternaPort;
import cl.bancochile.osb.neg.pagos.cobranzaexterna.v._1.FaultMsg;
import cl.bancochile.portal.common.recaudacion.domain.DetalleContrato;
import cl.bancochile.portal.common.recaudacion.exception.TraducibleSystemException;
import cl.bancochile.ws12.handler4.AbstractWebServiceClient;
import freemarker.template.utility.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClienteWSDetalleContratoImpl extends AbstractWebServiceClient implements ClienteWSDetalleContrato {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteWSDetalleContratoImpl.class);
    private static final String ID_DETALLE_CONTRATO = "detalleContrato";
    private static final String VACIO = "";
    private static final String SIN_OFICINA = "999";

    @Resource(name = "detalleContratoProxy")
    private CobranzaExternaPort proxy;

    @Autowired
    private ConversionService commonRecaConversionService;

    @Autowired
    private ClienteWsConsultaSucursal clienteWsConsultaSucursal;

    @Override
    public DetalleContrato clienteObtenerDetalleContrato(String codigoConvenio, String rut){
        agregarCabecerasWs(rut);
        try {
           ConsultarCobranzasExternasRs consultarCobranzasExternasRs = proxy.consultarCobranzasExternas(commonRecaConversionService.convert(codigoConvenio, ConsultarCobranzasExternasRq.class));
            return commonRecaConversionService.convert(consultarCobranzasExternasRs, DetalleContrato.class);
        }catch (FaultMsg faultMsg){
            String msnError = "error al interpretar response servicio detalleContrato";
            LOGGER.error(msnError,faultMsg);
            throw new TraducibleSystemException(msnError,TraducibleSystemException.S_CODE_EXCEPCION_GENERICA,faultMsg);
        }catch (Exception e) {
            String msnError = "error al parsear response servicio detalleContrato";
            LOGGER.error(msnError,e);
            throw new TraducibleSystemException(msnError,TraducibleSystemException.S_CODE_EXCEPCION_GENERICA,e);
        }
    }

    @Override
    public ConsultarCobranzasExternasRs clienteObtenerDetalleContratoResponse(String codigoConvenio, String rut){
        agregarCabecerasWs(rut);
        try {
            return proxy.consultarCobranzasExternas(commonRecaConversionService.convert(codigoConvenio, ConsultarCobranzasExternasRq.class));
        }catch (FaultMsg faultMsg){
            String msnError = "error al interpretar response servicio detalleContrato";
            LOGGER.error(msnError,faultMsg);
            throw new TraducibleSystemException(msnError,TraducibleSystemException.S_CODE_EXCEPCION_GENERICA,faultMsg);
        }catch (Exception e) {
            String msnError = "error al parsear response servicio detalleContrato";
            LOGGER.error(msnError,e);
            throw new TraducibleSystemException(msnError,TraducibleSystemException.S_CODE_EXCEPCION_GENERICA,e);
        }
    }

    @Override
    public String obtenerOficinaDetalleContrato(String codigoConvenio, String rut){
        LOGGER.info("Llamando a servicio detalle contrato " + codigoConvenio +  "rut " + rut);
        agregarCabecerasWs(rut);
        try {
            ConsultarCobranzasExternasRq cobranzasExternasRq = new ConsultarCobranzasExternasRq();
            cobranzasExternasRq.setCodigoEmpresa(codigoConvenio);
            ConsultarCobranzasExternasRs rs = proxy.consultarCobranzasExternas(cobranzasExternasRq);
            if(rs.getRendicion().getOficina() != null && !rs.getRendicion().getOficina().toString().equals(VACIO)
                    && !rs.getRendicion().getOficina().toString().equals(SIN_OFICINA)){
                String oficina = clienteWsConsultaSucursal.getSucursal(leftPadZeros(rs.getRendicion().getOficina().toString(),3),rut);
                LOGGER.debug("Oficina desde el servicio bus es {}", oficina);
                return !oficina.equals(VACIO) ? oficina.substring(0, 1).toUpperCase() + oficina.substring(1).toLowerCase() :oficina;
            }else {
                return VACIO;
            }
        }catch (Exception e) {
            String msnError = "error al obtener codigo oficina servicio detalleContrato";
            LOGGER.error(msnError,e);
            return VACIO;
        }
    }

    private void agregarCabecerasWs(String rut) {
        addHeader("usuario", rut, proxy);
        addHeader("pathServices", ID_DETALLE_CONTRATO, proxy);
    }

    private String leftPadZeros(String campo, int tamanio) {
        return StringUtil.leftPad(campo, tamanio, "0");
    }

}
