package cl.bancochile.portal.common.recaudacion.dao;

import cl.bancochile.portal.empresa.recaudacion.persistence.Sp_re_get_formato_by_idService;
import cl.bancochile.portal.empresa.recaudacion.persistence.Sp_re_get_list_formatosService;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idIN;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idOUT;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_list_formatosIN;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_list_formatosOUT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FormatoDAOImpl implements FormatoDAO {

    @Autowired
    private Sp_re_get_formato_by_idService spReGetFormatoByIdService;

    @Autowired
    private Sp_re_get_list_formatosService sp_re_get_list_formatosService;

    @Override
    public Sp_re_get_formato_by_idOUT getFormatoPorId(String idFormato) {
        Sp_re_get_formato_by_idIN spReGetFormatoByIdIN = new Sp_re_get_formato_by_idIN();
        spReGetFormatoByIdIN.setIn_id_formato(Integer.valueOf(idFormato));
        return spReGetFormatoByIdService.execute(spReGetFormatoByIdIN);
    }

    @Override
    public Sp_re_get_list_formatosOUT getListFormatosPorConvenio(String tipoFormato, String idConvenio) {
        Sp_re_get_list_formatosIN in = new Sp_re_get_list_formatosIN();
        in.setIn_id_convenio(Integer.valueOf(idConvenio));
        in.setIn_id_tipo_formato(Integer.valueOf(tipoFormato));
        return sp_re_get_list_formatosService.execute(in);
    }
}
