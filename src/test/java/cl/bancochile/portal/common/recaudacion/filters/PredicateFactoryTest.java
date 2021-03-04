package cl.bancochile.portal.common.recaudacion.filters;

import cl.bancochile.portal.common.recaudacion.domain.Campo;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PredicateFactoryTest {

    @Test
    public void testCorrespondeLinea() throws Exception {
        assertFalse(PredicateFactory.campoLlave.apply(null));

        Campo campo = new Campo();
        campo.setLlave(true);
        assertTrue(PredicateFactory.campoLlave.apply(campo));

        assertFalse(PredicateFactory.correspondeLinea("prueba").apply(null));

        Campo input = Mockito.mock(Campo.class);
        Mockito.doReturn(null).when(input).getTipoRegistroPerteneciente();
        assertFalse(PredicateFactory.correspondeLinea("prueba").apply(input));

        Mockito.doReturn("prueba").when(input).getTipoRegistroPerteneciente();
        assertTrue(PredicateFactory.correspondeLinea("prueba").apply(input));

    }
}