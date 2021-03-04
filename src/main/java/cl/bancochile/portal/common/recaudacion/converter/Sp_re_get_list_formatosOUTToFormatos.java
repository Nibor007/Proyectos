package cl.bancochile.portal.common.recaudacion.converter;


import cl.bancochile.portal.common.recaudacion.domain.Formato;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_list_formatosOUT;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_list_formatosOut_cursorRS;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class Sp_re_get_list_formatosOUTToFormatos implements Converter<Sp_re_get_list_formatosOUT, List<Formato>> {

    @Override
    public List<Formato> convert(Sp_re_get_list_formatosOUT source) {
        List<Formato> formatoList = new ArrayList<>();
        for (Sp_re_get_list_formatosOut_cursorRS rs: source.getOut_cursor()){
            Formato formato = new Formato();
            formato.setIdFormato(String.valueOf(rs.getPk_formato().intValue()));
            formato.setNombreFormato(rs.getNombre());
            formatoList.add(formato);
        }
        return formatoList;
    }
}
