package cl.bancochile.portal.common.recaudacion.exception;

import cl.bancochile.traductor.dto.MessageResponse;

public class TraducibleNegocioException extends RuntimeException implements TraducibleException {
    
    private static final long serialVersionUID = 2488303586908849670L;
    private final String servicio;
    private final String glosa;
    private final MessageResponse messageResponse;

    public TraducibleNegocioException(MessageResponse messageResponse) {
        this(messageResponse , "","");
    }

    public TraducibleNegocioException(MessageResponse messageResponse, Throwable throwable) {
        this(messageResponse , throwable, "","");
    }

    public TraducibleNegocioException(MessageResponse messageResponse, String servicio, String glosa) {
        this(messageResponse , null, servicio,glosa);
    }

    public TraducibleNegocioException(MessageResponse messageResponse, Throwable throwable, String servicio, String glosa) {
        super(throwable);
        this.messageResponse = messageResponse;
        this.servicio = servicio;
        this.glosa = glosa;
    }

    @Override
    public String getServicio() {
        return servicio;
    }

    @Override
    public String getGlosa() {
        return glosa;
    }

    @Override
    public MessageResponse getMessageResponse() {
        return messageResponse;
    }

}
