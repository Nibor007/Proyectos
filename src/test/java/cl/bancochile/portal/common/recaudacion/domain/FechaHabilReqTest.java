package cl.bancochile.portal.common.recaudacion.domain;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/** pojoTest autogenerado para FechaHabilReq */
public class FechaHabilReqTest {

    @Test
    public void pojoTest(){
        FechaHabilReq fechahabilreq = new FechaHabilReq();
        fechahabilreq.setFecha(new Date());
        Date v0_fecha = fechahabilreq.getFecha();
        assertNotNull(v0_fecha);

        fechahabilreq.setDias("dummyString");
        String v1_dias = fechahabilreq.getDias();
        assertEquals("dummyString",v1_dias);


    }
}