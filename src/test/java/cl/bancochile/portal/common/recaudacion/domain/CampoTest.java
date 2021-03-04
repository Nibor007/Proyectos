package cl.bancochile.portal.common.recaudacion.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/** pojoTest autogenerado para Campo */
public class CampoTest {

    @Test
    public void pojoTest(){
        Campo campo = new Campo();
        campo.setTipoRegistroPerteneciente("dummyString");
        String v0_tipoRegistroPerteneciente = campo.getTipoRegistroPerteneciente();
        assertEquals("dummyString",v0_tipoRegistroPerteneciente);

        campo.setFormato(new Formato());
        Formato v1_formato = campo.getFormato();
        assertNotNull(v1_formato);

        campo.setLlave(true);
        boolean v2_llave = campo.isLlave();
        assertTrue(v2_llave);

        campo.setPosision(new Integer(1));
        Integer v3_posision = campo.getPosision();
        assertEquals(new Integer(1),v3_posision);

        campo.setLargo(new Integer(1));
        Integer v4_largo = campo.getLargo();
        assertEquals(new Integer(1),v4_largo);

        campo.setObligatorio(true);
        boolean v5_obligatorio = campo.isObligatorio();
        assertTrue(v5_obligatorio);

        campo.setContabiliza(true);
        boolean v6_contabiliza = campo.isContabiliza();
        assertTrue(v6_contabiliza);

        campo.setTotaliza(true);
        boolean v7_totaliza = campo.isTotaliza();
        assertTrue(v7_totaliza);

        campo.setPatronValidacion("dummyString");
        String v8_patronValidacion = campo.getPatronValidacion();
        assertEquals("dummyString",v8_patronValidacion);

        campo.setMensajeError("dummyString");
        String v9_mensajeError = campo.getMensajeError();
        assertEquals("dummyString",v9_mensajeError);

    }
}