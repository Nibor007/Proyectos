package cl.bancochile.portal.common.recaudacion.exception;

import cl.bancochile.traductor.dto.MessageResponse;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class TraducibleSystemExceptionTest {

    @Test
    public void traducibleSystemExceptionTest(){

        Throwable throwable = new NullPointerException("cause");
        TraducibleSystemException traducibleSystemException = new TraducibleSystemException(MENSAJE_RESPONSE(),throwable,"servicio","glosa");
        assertThat(traducibleSystemException.getGlosa(),is("glosa"));
        assertThat(traducibleSystemException.getServicio(),is("servicio"));
        assertThat(traducibleSystemException.getMessageResponse(),instanceOf(MessageResponse.class));
    }

    @Test
    public void traducibleSystemExceptionTest2(){
        TraducibleSystemException traducibleSystemException = new TraducibleSystemException(MENSAJE_RESPONSE(),"servicio","glosa");
        assertThat(traducibleSystemException.getGlosa(),is("glosa"));
        assertThat(traducibleSystemException.getServicio(),is("servicio"));
        assertThat(traducibleSystemException.getMessageResponse(),instanceOf(MessageResponse.class));
        assertThat(traducibleSystemException.getCodigoError(),is(nullValue()));
    }

    @Test
    public void traducibleSystemExceptionTest3(){
        Throwable throwable = new NullPointerException("cause");
        TraducibleSystemException traducibleSystemException = new TraducibleSystemException(MENSAJE_RESPONSE(),throwable);
        assertThat(traducibleSystemException.getMessageResponse(),instanceOf(MessageResponse.class));
        assertThat(traducibleSystemException.getCodigoError(),is(nullValue()));
        assertThat(traducibleSystemException.getServicio(),is(""));
        assertThat(traducibleSystemException.getCause(),instanceOf(NullPointerException.class));
    }

    @Test
    public void traducibleSystemExceptionTest4(){
        String glosa = "glosa";
        TraducibleSystemException traducibleSystemException = new TraducibleSystemException(glosa);
        assertThat(traducibleSystemException.getGlosa(),is("glosa"));
        assertThat(traducibleSystemException.getCodigoError(),is(nullValue()));
        assertThat(traducibleSystemException.getMessageResponse(),is(nullValue()));
        assertThat(traducibleSystemException.getServicio(),is(nullValue()));
    }

    private static MessageResponse MENSAJE_RESPONSE() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setErrorCode("001");
        messageResponse.setSeverity("error");
        messageResponse.setErrorMessage("mensaje de error");
        return messageResponse;
    }
}
