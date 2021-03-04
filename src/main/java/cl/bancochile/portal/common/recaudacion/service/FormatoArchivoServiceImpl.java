package cl.bancochile.portal.common.recaudacion.service;


import cl.bancochile.portal.common.recaudacion.dao.FormatoDAO;
import cl.bancochile.portal.common.recaudacion.domain.Archivo;
import cl.bancochile.portal.common.recaudacion.domain.Campo;
import cl.bancochile.portal.common.recaudacion.domain.Formato;
import cl.bancochile.portal.common.recaudacion.domain.enums.ArchivosEnum;
import cl.bancochile.portal.common.recaudacion.exception.TraducibleSystemException;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idOUT;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_list_formatosOUT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatoArchivoServiceImpl implements FormatoArchivoService {

    @Autowired
    private ConversionService commonRecaConversionService;

    @Autowired
    private FormatoDAO formatoDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(FormatoArchivoServiceImpl.class);

    private static final String ERROR_BASE_MESSAGE = "Error en: %s";


    @Override
    public List<Campo> getFormatoArchivoByIdFormato(String idFormatoArchivo) {
        try {
            Sp_re_get_formato_by_idOUT spReGetFormatoByIdOUT = formatoDAO.getFormatoPorId(idFormatoArchivo);
            return commonRecaConversionService.convert(spReGetFormatoByIdOUT, List.class);
        } catch (Exception e) {
            String msgError = String.format(ERROR_BASE_MESSAGE, "Obtencion de Formato por id formato");
            LOGGER.error(msgError, e);
            throw new TraducibleSystemException(msgError, TraducibleSystemException.S_CODE_EXCEPCION_GENERICA, e);
        }
    }

    @Override
    public List<Formato> getTiposFormatoByConvenioAndTipo(String tipoFormato, String idConvenio) {
        try {
            Sp_re_get_list_formatosOUT formatosOut = formatoDAO.getListFormatosPorConvenio(getArchivoPorNombre(tipoFormato).getId(), idConvenio);
            return commonRecaConversionService.convert(formatosOut, List.class);
        } catch (Exception e) {
            String msgError = String.format(ERROR_BASE_MESSAGE, "Obtencion de Tipos de Formato por Convenio y tipo");
            LOGGER.error(msgError, e);
            throw new TraducibleSystemException(msgError, TraducibleSystemException.S_CODE_EXCEPCION_GENERICA, e);
        }
    }

    @Override
    public Archivo getFormatoArchivoPorId(String IdFormato) {
        try {
            Sp_re_get_formato_by_idOUT formatosOut = formatoDAO.getFormatoPorId(IdFormato);
            return commonRecaConversionService.convert(formatosOut,Archivo.class);
        }catch (Exception e){
            String msgError = String.format(ERROR_BASE_MESSAGE,"");
            LOGGER.error(msgError, e);
            throw new TraducibleSystemException(msgError,TraducibleSystemException.S_CODE_EXCEPCION_GENERICA, e);
        }
    }

    private ArchivosEnum getArchivoPorNombre(String nombre) {
        for (ArchivosEnum arch : ArchivosEnum.values()) {
            if (arch.getArchivo().equalsIgnoreCase(nombre)) return arch;
        }
        return null;
    }
}
