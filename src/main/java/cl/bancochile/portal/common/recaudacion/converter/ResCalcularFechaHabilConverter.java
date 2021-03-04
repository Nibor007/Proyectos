package cl.bancochile.portal.common.recaudacion.converter;

import cl.bancochile.osb.esb.calculofechahabil.opcalculofechahabilresponse.Cuerpo;
import cl.bancochile.portal.common.recaudacion.domain.FechaHabil;
import cl.bancochile.portal.common.recaudacion.utils.DateUtil;
import org.springframework.core.convert.converter.Converter;


public class ResCalcularFechaHabilConverter implements Converter<Cuerpo, FechaHabil> {

    private static final String FORMATO_FECHA_ORIGEN = "yyyyMMdd";
    private static final String FORMATO_FECHA_DESTINO = "dd-MM-yyyy";

    @Override
    public FechaHabil convert(Cuerpo source) {

        FechaHabil fechaHabil = new FechaHabil();
        fechaHabil.setFechaIngreso(convertirFechaString(source.getFechaIngreso(), FORMATO_FECHA_ORIGEN, FORMATO_FECHA_DESTINO));
        fechaHabil.setFechaSalida(convertirFechaString(source.getFechaSalida(), FORMATO_FECHA_ORIGEN, FORMATO_FECHA_DESTINO));
        return fechaHabil;
    }

    private String convertirFechaString(String fecha, String formatoFechaOrigen, String formatoFechaDestino) {
        return DateUtil.dateToString(DateUtil.stringToDate(fecha, formatoFechaOrigen), formatoFechaDestino);
    }


}
