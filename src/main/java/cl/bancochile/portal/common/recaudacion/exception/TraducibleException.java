package cl.bancochile.portal.common.recaudacion.exception;

import cl.bancochile.traductor.dto.MessageResponse;

public interface TraducibleException {

    String S_CODE_EXCEPCION_GENERICA = "512804";

    String MENSAJE_EXCEPCION_GENERICA = "Estimado Cliente, este servicio está temporalmente no disponible, por favor intente más tarde.";
    String SEVERIDAD_DEFAULT = "error";


    MessageResponse getMessageResponse();
    String getServicio();
    String getGlosa();
}
