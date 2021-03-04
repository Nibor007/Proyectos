package cl.bancochile.portal.common.recaudacion.exception;

import cl.bancochile.traductor.dto.MessageResponse;

public class TraduciblePermisoException extends RuntimeException implements TraducibleException {

    private static final long serialVersionUID = 1991636883616299590L;

    private final MessageResponse messageResponse;
    private final String glosa;
    private final String servicio;


    public TraduciblePermisoException(MessageResponse messageResponse) {
        this(messageResponse,"","");
    }

    public TraduciblePermisoException(MessageResponse messageResponse, String servicio, String glosa) {
        this.messageResponse = messageResponse;
        this.servicio = servicio;
        this.glosa = glosa;
    }

    @Override
    public MessageResponse getMessageResponse() {
        return messageResponse;
    }

    @Override
    public String getGlosa() {
        return glosa;
    }

    @Override
    public String getServicio() {
        return servicio;
    }

}
