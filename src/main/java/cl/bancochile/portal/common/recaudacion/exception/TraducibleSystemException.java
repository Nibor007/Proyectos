package cl.bancochile.portal.common.recaudacion.exception;

import cl.bancochile.traductor.dto.MessageResponse;

public class TraducibleSystemException extends RuntimeException implements TraducibleException {

    private static final long serialVersionUID = 9208332074225368951L;
    private final MessageResponse messageResponse;
    private final String servicio ;
    private final String glosa ;
    private final String codigoError;

    public TraducibleSystemException(MessageResponse messageResponse, Throwable throwable, String servicio, String glosa) {
        super(throwable);
        this.servicio = servicio;
        this.messageResponse = messageResponse;
        this.glosa = glosa;
        codigoError = null;
    }

    public TraducibleSystemException(MessageResponse mensaje, Throwable throwable) {
        super(throwable);
        this.messageResponse = mensaje;
        this.servicio = "";
        this.glosa = "";
        codigoError = null;
    }

    public TraducibleSystemException(MessageResponse messageResponse, String servicio, String glosa) {
        this.servicio = servicio;
        this.messageResponse = messageResponse;
        this.glosa = glosa;
        codigoError = null;
    }

    public TraducibleSystemException(String message,String codigoError,Throwable throwable){
        super(message,throwable);
        this.codigoError=codigoError;
        messageResponse = null;
        servicio = null;
        glosa = null;
    }

    public TraducibleSystemException(String glosa){
        codigoError=null;
        messageResponse = null;
        servicio = null;
        this.glosa = glosa;
    }

    @Override
    public MessageResponse getMessageResponse() {
        return messageResponse;
    }

    @Override
    public String getServicio() {
        return servicio;
    }

    @Override
    public String getGlosa() {
        return glosa;
    }

    public String getCodigoError() {
        return codigoError;
    }
}