package cl.bancochile.portal.common.recaudacion.converter;

import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrs.mpi.Canal;
import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrs.mpi.ConsultarCobranzasExternasRs;
import cl.bancochile.portal.common.recaudacion.domain.DetalleContrato;
import cl.bancochile.portal.common.recaudacion.utils.DateUtil;
import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class DetalleContratoRes implements Converter<ConsultarCobranzasExternasRs, DetalleContrato> {

    @Autowired
    @Qualifier(value = "detalleContrato")
    private Properties properties;

    private static final Joiner JOINER = Joiner.on(" - ").skipNulls();


    @Override
    public DetalleContrato convert(ConsultarCobranzasExternasRs res) {
        DetalleContrato detalleContrato = new DetalleContrato();

        StringBuilder sbCanal = new StringBuilder();

        List<String> listadoCanales = new ArrayList<>();
        List<BigInteger> listadoCodigoCanales = new ArrayList<>();
        for(Canal canal: res.getServicio().getCanales().getCanal()){
            listadoCanales.add(properties.getProperty("CANORI."+ canal.getCodigo().intValue()));
            listadoCodigoCanales.add(canal.getCodigo());
        }

        detalleContrato.setRecaudacionCaja(JOINER.appendTo(sbCanal,listadoCanales).toString());
        detalleContrato.setUsoCodigoBarra(properties.getProperty("INCOBA."+ res.getServicio().getIndicadorCodigoBarra().toString()));
        detalleContrato.setCuentaCorriente(res.getPagoEmpresa().getCuentaCorriente());
        detalleContrato.setFechaInicio(DateUtil.dateToString(DateUtil.xmlGregorianCalendartoDate(res.getServicio().getFechaInicio()), DateUtil.FMT_FECHA_DD_MM_YYYY));
        detalleContrato.setCobertura(properties.getProperty("CODCOB."+ res.getServicio().getCodigoCobertura().toString()));
        detalleContrato.setMoneda(properties.getProperty("MOANVT." + res.getIntereses().getMonedaAntesVencimiento()));
        detalleContrato.setTipoInteres(properties.getProperty("TIPTAS." + res.getIntereses().getTipoTasa()));
        detalleContrato.setCanalRecaudacion(res.getServicio().getCanales().getCanal().get(0).getCodigo().toString());
        detalleContrato.setNombreConvenio(res.getServicio().getNombre());
        detalleContrato.setListaCanales(listadoCodigoCanales);
        return detalleContrato;
    }
}
