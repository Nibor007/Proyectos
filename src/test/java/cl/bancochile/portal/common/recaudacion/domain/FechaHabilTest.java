package cl.bancochile.portal.common.recaudacion.domain;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FechaHabilTest {

    @Test
    public void creacionObjetoTest(){
        FechaHabil fechaHabil = new FechaHabil();
        fechaHabil.setFechaIngreso("01-01-2016");
        fechaHabil.setFechaSalida("01-03-2016");

        String fechaIngresoTest = fechaHabil.getFechaIngreso();
        String fechaSalidaTest = fechaHabil.getFechaSalida();

        assertEquals("01-01-2016",fechaIngresoTest);
        assertEquals("01-03-2016",fechaSalidaTest);

    }
}
