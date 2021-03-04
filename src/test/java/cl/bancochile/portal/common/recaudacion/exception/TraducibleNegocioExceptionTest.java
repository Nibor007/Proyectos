package cl.bancochile.portal.common.recaudacion.exception;


import cl.bancochile.traductor.dto.MessageResponse;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class TraducibleNegocioExceptionTest {

    @Test
    public void TraducibleNegocioException1Test(){
        TraducibleNegocioException TraducibleNegocioException1 = new TraducibleNegocioException(MENSAJE_RESPONSE());
        assertThat(TraducibleNegocioException1.getGlosa(),is(""));
        assertThat(TraducibleNegocioException1.getServicio(),is(""));
        assertThat(TraducibleNegocioException1.getMessageResponse(),is(MessageResponse.class));
    }

    @Test
    public void TraducibleNegocioException2Test(){
        TraducibleNegocioException TraducibleNegocioException2 = new TraducibleNegocioException(MENSAJE_RESPONSE(),"val1","val2");
        assertThat(TraducibleNegocioException2.getGlosa(),is("val2"));
        assertThat(TraducibleNegocioException2.getServicio(),is("val1"));
        assertThat(TraducibleNegocioException2.getMessageResponse(),is(MessageResponse.class));
    }

    @Test
    public void TraducibleNegocioException3Test(){
        TraducibleNegocioException TraducibleNegocioException3 = new TraducibleNegocioException(MENSAJE_RESPONSE(),new Throwable());
        assertThat(TraducibleNegocioException3.getGlosa(),is(""));
        assertThat(TraducibleNegocioException3.getServicio(),is(""));
        assertThat(TraducibleNegocioException3.getMessageResponse(),is(MessageResponse.class));
    }

    @Test
    public void TraducibleNegocioException4Test(){
        TraducibleNegocioException TraducibleNegocioException4 = new TraducibleNegocioException(MENSAJE_RESPONSE(),new Throwable(),"val1","val2");
        assertThat(TraducibleNegocioException4.getGlosa(),is("val2"));
        assertThat(TraducibleNegocioException4.getServicio(),is("val1"));
        assertThat(TraducibleNegocioException4.getMessageResponse(),is(MessageResponse.class));
    }

    public static MessageResponse MENSAJE_RESPONSE() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setErrorCode("001");
        messageResponse.setErrorMessage("mensaje de error");
        messageResponse.setSeverity("error");
        return messageResponse;
    }
}
