package cl.bancochile.portal.common.recaudacion.dao;


import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idOUT;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_list_formatosOUT;

public interface FormatoDAO {

    Sp_re_get_formato_by_idOUT getFormatoPorId(String idFormato);

    Sp_re_get_list_formatosOUT getListFormatosPorConvenio(String tipoFormato, String idConvenio);
}
