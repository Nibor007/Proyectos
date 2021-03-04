package cl.bancochile.portal.common.recaudacion.service;


import cl.bancochile.portal.common.recaudacion.domain.Archivo;
import cl.bancochile.portal.common.recaudacion.domain.Campo;
import cl.bancochile.portal.common.recaudacion.domain.Formato;

import java.util.List;

public interface FormatoArchivoService {


    List<Campo> getFormatoArchivoByIdFormato(String idFormatoArchivo);

    List<Formato> getTiposFormatoByConvenioAndTipo(String tipoFormato, String idConvenio);

    Archivo getFormatoArchivoPorId(String IdFormato);


}
