package cl.bancochile.portal.common.recaudacion.exception;


public class PermisoException extends RuntimeException {

    private static final long serialVersionUID = 2185599327631542531L;

    public PermisoException(String message) {
        super(message);
    }

    public PermisoException(String message, Throwable cause) {
        super(message, cause);
    }
}
