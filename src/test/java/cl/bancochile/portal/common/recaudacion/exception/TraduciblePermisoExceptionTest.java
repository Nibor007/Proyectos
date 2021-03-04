package cl.bancochile.portal.common.recaudacion.exception;

import cl.bancochile.traductor.dto.MessageResponse;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class TraduciblePermisoExceptionTest {

    @Test
    public void traduciblePermisoException1Test(){
        TraduciblePermisoException traduciblePermisoException1 = new TraduciblePermisoException(MENSAJE_RESPONSE());
        assertThat(traduciblePermisoException1.getGlosa(),is(""));
        assertThat(traduciblePermisoException1.getServicio(),is(""));
        assertThat(traduciblePermisoException1.getMessageResponse(),is(MessageResponse.class));
    }

    @Test
    public void traduciblePermisoException2Test(){
        TraduciblePermisoException traduciblePermisoException2 = new TraduciblePermisoException(MENSAJE_RESPONSE(),"val1","val2");
        assertThat(traduciblePermisoException2.getGlosa(),is("val2"));
        assertThat(traduciblePermisoException2.getServicio(),is("val1"));
        assertThat(traduciblePermisoException2.getMessageResponse(),is(MessageResponse.class));
    }

    public static MessageResponse MENSAJE_RESPONSE() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setErrorCode("001");
        messageResponse.setErrorMessage("mensaje de error");
        messageResponse.setSeverity("error");
        return messageResponse;
    }
}
