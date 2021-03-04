package cl.bancochile.portal.common.recaudacion.sal;

import cl.bancochile.common.helper.CleanUtils;
import cl.bancochile.osb.bch.neg.recaudaciones.consultasucursalrecaudacion.consultarsucursalrq.mpi.ConsultarSucursalRq;
import cl.bancochile.osb.bch.neg.recaudaciones.consultasucursalrecaudacion.consultarsucursalrs.mpi.ConsultarSucursalRs;
import cl.bancochile.osb.bch.neg.recaudaciones.consultasucursalrecaudacion.v._1.ConsultaSucursalRecaudacionPort;

import cl.bancochile.osb.bch.neg.recaudaciones.consultasucursalrecaudacion.v._1.FaultMsg;
import cl.bancochile.ws12.handler4.AbstractWebServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ClienteWSConsultaSucursalImpl extends AbstractWebServiceClient implements ClienteWsConsultaSucursal {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteWSConsultaSucursalImpl.class);
    private static final String ID_CONSULTA_SUCURSAL = "consultaSucursal";
    private static final String CODIGO_EXITOSO = "00";
    private static final String VACIO = "";

    @Resource(name = "consultaSucursalRecaudacion")
    private ConsultaSucursalRecaudacionPort consultaSucursalRecaudacionProxy;

    private void agregarCabecerasWs(String rut) {
        addHeader("usuario", rut, consultaSucursalRecaudacionProxy);
        addHeader("pathServices", ID_CONSULTA_SUCURSAL, consultaSucursalRecaudacionProxy);
    }


    @Override
    public String getSucursal(String codOficina, String rut) {
        agregarCabecerasWs(rut);
        ConsultarSucursalRq request = new ConsultarSucursalRq();
        request.setCodigoOficina(codOficina);
        try {
            ConsultarSucursalRs response = consultaSucursalRecaudacionProxy.consultarSucursal(request);

            if (response.getCodigoRetorno().equals(CODIGO_EXITOSO)) {
                return response.getDescripcionOficina();
            } else {
                return VACIO;
            }
        } catch (FaultMsg faultMsg) {
            LOGGER.error("Error servicio bus al obtener codigo de sucursal con codigo :" + CleanUtils.clean(codOficina), faultMsg);
            return VACIO;
        } catch (Exception e) {
            String msnError = "error servicio bus al obtener conexion";
            LOGGER.error(msnError, e);
            return VACIO;
        }
    }

}
