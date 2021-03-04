package cl.bancochile.portal.common.recaudacion.converter;

import cl.bancochile.osb.esb.calculofechahabil.opcalculofechahabilvariablerequest.Cuerpo;
import cl.bancochile.portal.common.recaudacion.domain.FechaHabilReq;
import cl.bancochile.portal.common.recaudacion.utils.DateUtil;
import org.springframework.core.convert.converter.Converter;


public class ReqCalcularFechaHabilConverter implements Converter<FechaHabilReq, Cuerpo> {

    @Override
    public Cuerpo convert(FechaHabilReq source) {

        Cuerpo cuerpo = new Cuerpo();
        cuerpo.setFechaIngreso(DateUtil.dateToString(source.getFecha(), "yyyyMMdd"));
        cuerpo.setCantidadDias(source.getDias());
        return cuerpo;

    }


}
