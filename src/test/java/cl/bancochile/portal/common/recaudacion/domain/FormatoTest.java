package cl.bancochile.portal.common.recaudacion.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** pojoTest autogenerado para Formato */
public class FormatoTest {

    @Test
    public void pojoTest(){
        Formato formato = new Formato();
        formato.setIdFormato("dummyString");
        String v0_idFormato = formato.getIdFormato();
        assertEquals("dummyString",v0_idFormato);

        formato.setNombreFormato("dummyString");
        String v1_nombreFormato = formato.getNombreFormato();
        assertEquals("dummyString",v1_nombreFormato);

        formato.setDescripcion("dummyString");
        String v2_descripcion = formato.getDescripcion();
        assertEquals("dummyString",v2_descripcion);

        formato.setNotaAlPie("dummyString");
        String v3_notaAlPie = formato.getNotaAlPie();
        assertEquals("dummyString",v3_notaAlPie);


    }
}