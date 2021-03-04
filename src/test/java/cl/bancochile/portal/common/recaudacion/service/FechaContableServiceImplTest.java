package cl.bancochile.portal.common.recaudacion.service;

import cl.bancochile.osb.calculofechahabil.CalculoFechaHabil;
import cl.bancochile.osb.esb.calculofechahabil.opcalculofechahabilresponse.Cuerpo;
import cl.bancochile.portal.common.recaudacion.JaxbMappingUtil;
import cl.bancochile.portal.common.recaudacion.domain.FechaHabil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context-test.xml"})
public class FechaContableServiceImplTest {


    @Autowired
    private CalculoFechaHabil fechaHabilProxy;

    @Autowired
    private FechaContableServiceImpl fechaContableService;


    @Test
    public void calcularFechaContableTest(){
        Cuerpo cuerpo = JaxbMappingUtil.getObjectByXml(Cuerpo.class, "xmlResponse/calculoFechaHabilResponseOk.xml");
        Mockito.doReturn(cuerpo).when(fechaHabilProxy).calculoFechaHabilVariable(Mockito.isA(cl.bancochile.osb.esb.calculofechahabil.opcalculofechahabilvariablerequest.Cuerpo.class));
        FechaHabil fechaHabil = fechaContableService.obtenerFechaContableAnterior("1-9", new Date(), "1", "dd-MM-yyyy");
        assertEquals(fechaHabil.getFechaSalida(), "21-12-2016");
    }

    @Test
    public void calcularFechaContableDistintFormatoFechaTest(){
        Cuerpo cuerpo = JaxbMappingUtil.getObjectByXml(Cuerpo.class, "xmlResponse/calculoFechaHabilResponseOk.xml");
        Mockito.doReturn(cuerpo).when(fechaHabilProxy).calculoFechaHabilVariable(Mockito.isA(cl.bancochile.osb.esb.calculofechahabil.opcalculofechahabilvariablerequest.Cuerpo.class));
        FechaHabil fechaHabil = fechaContableService.obtenerFechaContableAnterior("1-9", new Date(), "1", "dd/MM/yyyy");
        assertEquals(fechaHabil.getFechaSalida(), "21/12/2016");
    }

    @Test
    public void calcularFechaContableExceptionTest(){
        Mockito.doThrow(Exception.class).when(fechaHabilProxy).calculoFechaHabilVariable(Mockito.isA(cl.bancochile.osb.esb.calculofechahabil.opcalculofechahabilvariablerequest.Cuerpo.class));
        FechaHabil fechaHabil = fechaContableService.obtenerFechaContableAnterior("1-9", new Date(), "1", "dd-MM-yyyy");
        assertNotNull(fechaHabil);
    }
}
