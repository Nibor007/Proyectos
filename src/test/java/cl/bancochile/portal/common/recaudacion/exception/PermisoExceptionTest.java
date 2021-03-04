package cl.bancochile.portal.common.recaudacion.exception;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class PermisoExceptionTest {

    @Test
    public void permisoExceptionTest(){

        String message = "error";
        Throwable cause = new NullPointerException(message);
        PermisoException permisoException = new PermisoException(message, cause);
        assertThat(permisoException.getMessage(),is("error"));
        assertThat(cause,instanceOf(Exception.class));
    }

    @Test
    public void permisoExceptionSoloMensajeTest(){
        String message = "error";
        PermisoException permisoException = new PermisoException(message);
        assertThat(permisoException.getMessage(),is("error"));
    }

}
