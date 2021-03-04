package cl.bancochile.portal.common.recaudacion.sal;

import cl.bancochile.common.helper.CleanUtils;
import cl.bancochile.osb.calculofechahabil.CalculoFechaHabil;
import cl.bancochile.osb.esb.calculofechahabil.opcalculofechahabilvariablerequest.Cuerpo;
import cl.bancochile.portal.common.recaudacion.domain.FechaHabil;
import cl.bancochile.portal.common.recaudacion.domain.FechaHabilReq;
import cl.bancochile.portal.common.recaudacion.utils.DateUtil;
import cl.bancochile.ws.spring.handler.AbstractWebServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class ClienteWSCalculoFechaHabilImpl extends AbstractWebServiceClient implements ClienteWSCalculoFechaHabil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteWSCalculoFechaHabilImpl.class);

    @Autowired
    private CalculoFechaHabil fechaHabilProxy;

    @Autowired
    private ConversionService commonRecaConversionService;

    @Override
    public FechaHabil calcularFechaContable(String rutCliente, Date fecha, String numDiasCaulcular, String formatoFechaSalida) {

        try {
            addHeader(rutCliente, fechaHabilProxy);
            Cuerpo cuerpoInput = commonRecaConversionService.convert(new FechaHabilReq.Builder().dias(numDiasCaulcular).fecha(fecha).build(), Cuerpo.class);
            cl.bancochile.osb.esb.calculofechahabil.opcalculofechahabilresponse.Cuerpo cuerpoResponse = fechaHabilProxy.calculoFechaHabilVariable(cuerpoInput);
            return convertCuerpoToFechaHabil(cuerpoResponse, formatoFechaSalida);
        } catch (Exception e) {
            LOGGER.error("Excepcion durante consulta de dia habil para rut " + CleanUtils.clean(rutCliente) + " " +
                    CleanUtils.clean(fecha), e);
            FechaHabil defaulFechaHabil = new FechaHabil();
            defaulFechaHabil.setFechaIngreso(DateUtil.dateToString(fecha,formatoFechaSalida));
            defaulFechaHabil.setFechaSalida(DateUtil.dateToString(new Date(),formatoFechaSalida));
            return defaulFechaHabil;
        }
    }


    private FechaHabil convertCuerpoToFechaHabil(cl.bancochile.osb.esb.calculofechahabil.opcalculofechahabilresponse.Cuerpo cuerpo, String formatoFechaSalida) {

        FechaHabil fechaHabil = new FechaHabil();
        fechaHabil.setFechaIngreso(convertirFechaString(cuerpo.getFechaIngreso(), DateUtil.FMT_FECHA_YYYYMMDD, formatoFechaSalida));
        fechaHabil.setFechaSalida(convertirFechaString(cuerpo.getFechaSalida(), DateUtil.FMT_FECHA_YYYYMMDD, formatoFechaSalida));
        return fechaHabil;
    }

    private String convertirFechaString(String fecha, String formatoFechaOrigen, String formatoFechaDestino) {
        return DateUtil.dateToString(DateUtil.stringToDate(fecha, formatoFechaOrigen), formatoFechaDestino);
    }
}
