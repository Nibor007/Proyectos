
package cl.bancochile.portal.common.recaudacion.converter;


import cl.bancochile.portal.common.recaudacion.domain.Campo;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idOUT;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idOut_cursorRS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Sp_re_get_formato_by_idOUTToValidadorFormatoLineas implements Converter<Sp_re_get_formato_by_idOUT, List<Campo>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sp_re_get_formato_by_idOUTToValidadorFormatoLineas.class);

    @Override
    public List<Campo> convert(Sp_re_get_formato_by_idOUT source) {
        List<Campo> campoList = new ArrayList<>();
        Campo campo;
        LOGGER.info("Revisando lo que convertiremos...");
        for (Sp_re_get_formato_by_idOut_cursorRS dato : source.getOut_cursor()) {
            campo = new Campo();

            LOGGER.info("Agregando validacion de campo=>" + dato.getNombre_campo() +
                    " es llave=>" + dato.getClave_campo() + ("1".equalsIgnoreCase(dato.getClave_campo().toString())) +
                    " Con expresion :[" + dato.getRegex_campo() + "]");
            campo.setLlave("1".equalsIgnoreCase(dato.getClave_campo().toString()));
            campo.setTipoRegistroPerteneciente(dato.getValor_tipo_registro_campo());
            campo.setPosision(dato.getOrden_campo().intValue());
            campo.setLargo(dato.getLargo_campo().intValue());
            campo.setObligatorio("1".equalsIgnoreCase(dato.getObligatorio_campo().toString()));
            campo.setTotaliza("1".equalsIgnoreCase(dato.getTotaliza_campo().toString()));
            campo.setPatronValidacion(dato.getRegex_campo());
            campo.setMensajeError(dato.getMensaje_error_campo());
            campo.setCaracterDelimitador(dato.getCaracter_delimitador());
            campo.setNombreCampo(dato.getNombre_campo());
            campoList.add(campo);
        }

        Collections.sort(campoList);
        return campoList;
    }
}
