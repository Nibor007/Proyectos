package cl.bancochile.portal.common.recaudacion.service;


import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrq.mpi.ConsultarCobranzasExternasRq;
import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrs.mpi.ConsultarCobranzasExternasRs;
import cl.bancochile.osb.bch.neg.recaudaciones.consultasucursalrecaudacion.consultarsucursalrq.mpi.ConsultarSucursalRq;
import cl.bancochile.osb.bch.neg.recaudaciones.consultasucursalrecaudacion.consultarsucursalrs.mpi.ConsultarSucursalRs;
import cl.bancochile.osb.bch.neg.recaudaciones.consultasucursalrecaudacion.v._1.ConsultaSucursalRecaudacionPort;
import cl.bancochile.osb.ent.bch.infra.mci.errordetails.v._6.Details;
import cl.bancochile.osb.neg.pagos.cobranzaexterna.v._1.CobranzaExternaPort;
import cl.bancochile.osb.neg.pagos.cobranzaexterna.v._1.FaultMsg;
import cl.bancochile.portal.common.recaudacion.JaxbMappingUtil;
import cl.bancochile.portal.common.recaudacion.domain.DataAdicional;
import cl.bancochile.portal.common.recaudacion.domain.DetalleContrato;
import cl.bancochile.portal.common.recaudacion.exception.TraducibleSystemException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context-test.xml"})
public class DetalleContratoServiceImplTest {


    @Autowired
    private DetalleContratoServiceImpl  detalleContratoService;

    @Autowired
    private CobranzaExternaPort proxy;

    @Autowired
    private ConsultaSucursalRecaudacionPort proxySucursal;

    private static final String CODIGO_CONVENIO_MOCK = "000404";
    private static final String RUT_MOCK = "1-9";


    @Test
    public void obtenerDetalleContratoTest() throws Exception {
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContrato.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        DetalleContrato detalleContrato = detalleContratoService.obtenerDetalleContrato(CODIGO_CONVENIO_MOCK,RUT_MOCK);
        Assert.assertNotNull(detalleContrato);
        Assert.assertEquals(detalleContrato.getCobertura(), "Metropolitana");
        Assert.assertEquals(detalleContrato.getUsoCodigoBarra(), "No");
        Assert.assertEquals(detalleContrato.getCuentaCorriente(), "1701019901");
        Assert.assertEquals(detalleContrato.getFechaInicio(), "01/01/1992");
        Assert.assertEquals(detalleContrato.getMoneda(), "PESOS");
        /* En el caso que no tenga datos como lo es en este mock*/
        Assert.assertEquals(detalleContrato.getRecaudacionCaja(),"Bco. Chile - Servipag");
        Assert.assertNull(detalleContrato.getTipoInteres());
    }

    @Test (expected = TraducibleSystemException.class)
    public void obtenerDetalleContratoFaultExceptionTest() throws Exception {
        FaultMsg exception = Mockito.mock(FaultMsg.class);
        Mockito.doThrow(exception).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        detalleContratoService.obtenerDetalleContrato(CODIGO_CONVENIO_MOCK,RUT_MOCK);
    }

    @Test (expected = TraducibleSystemException.class)
    public void obtenerDetalleContratoGeneralExceptionTest() throws Exception {
        Mockito.doThrow(Exception.class).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        detalleContratoService.obtenerDetalleContrato(CODIGO_CONVENIO_MOCK,RUT_MOCK);
    }

    @Test
    public void clienteObtenerDetalleContratoResponse() throws Exception {
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContrato.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        ConsultarCobranzasExternasRs detalleContrato = detalleContratoService.clienteObtenerDetalleContratoResponse(CODIGO_CONVENIO_MOCK,RUT_MOCK);
        Assert.assertNotNull(detalleContrato);
    }

    @Test (expected = TraducibleSystemException.class)
    public void clienteObtenerDetalleContratoResponseFaultExceptionTest() throws Exception {
        FaultMsg exception = Mockito.mock(FaultMsg.class);
        Mockito.doThrow(exception).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        detalleContratoService.clienteObtenerDetalleContratoResponse(CODIGO_CONVENIO_MOCK,RUT_MOCK);
    }

    @Test (expected = TraducibleSystemException.class)
    public void clienteObtenerDetalleContratoResponseGeneralExceptionTest() throws Exception {
        Mockito.doThrow(Exception.class).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        detalleContratoService.clienteObtenerDetalleContratoResponse(CODIGO_CONVENIO_MOCK,RUT_MOCK);
    }


    @Test
    public void obtenerOficinaDetalleContratoTest() throws Exception{
        String codConvenio = "123456";
        String rut = "1-9";
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContrato.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        ConsultarSucursalRs consultarSucursalRs = JaxbMappingUtil.getObjectByXml(ConsultarSucursalRs.class, "xmlResponse/consultaSucursal.xml");
        Mockito.doReturn(consultarSucursalRs).when(proxySucursal).consultarSucursal(Mockito.any(ConsultarSucursalRq.class));

        String codOficina = detalleContratoService.obtenerOficinaDetalleContrato(codConvenio, rut);
        Assert.assertNotNull(codOficina);
        Assert.assertEquals(codOficina, "Casa matriz");
    }

    @Test
    public void obtenerOficinaDetalleContratoSinSucursalTest() throws Exception{
        String codConvenio = "123456";
        String rut = "1-9";
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContrato.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        ConsultarSucursalRs consultarSucursalRs = JaxbMappingUtil.getObjectByXml(ConsultarSucursalRs.class, "xmlResponse/consultaSucursalNok.xml");
        Mockito.doReturn(consultarSucursalRs).when(proxySucursal).consultarSucursal(Mockito.any(ConsultarSucursalRq.class));

        String codOficina = detalleContratoService.obtenerOficinaDetalleContrato(codConvenio, rut);
        Assert.assertNotNull(codOficina);
        Assert.assertEquals(codOficina, "");
    }

    @Test
    public void obtenerOficinaDetalleContratoOfiInvalidTest() throws Exception{
        String codConvenio = "123456";
        String rut = "1-9";
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContratoOfiInvalid.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        ConsultarSucursalRs consultarSucursalRs = JaxbMappingUtil.getObjectByXml(ConsultarSucursalRs.class, "xmlResponse/consultaSucursal.xml");
        Mockito.doReturn(consultarSucursalRs).when(proxySucursal).consultarSucursal(Mockito.any(ConsultarSucursalRq.class));
        String codOficina = detalleContratoService.obtenerOficinaDetalleContrato(codConvenio, rut);
        Assert.assertNotNull(codOficina);
        Assert.assertEquals(codOficina, "");
    }

    @Test
    public void obtenerOficinaDetalleContratoOfiNullTest() throws Exception{
        String codConvenio = "123456";
        String rut = "1-9";
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContratoOfiNull.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        ConsultarSucursalRs consultarSucursalRs = JaxbMappingUtil.getObjectByXml(ConsultarSucursalRs.class, "xmlResponse/consultaSucursal.xml");
        Mockito.doReturn(consultarSucursalRs).when(proxySucursal).consultarSucursal(Mockito.any(ConsultarSucursalRq.class));
        String codOficina = detalleContratoService.obtenerOficinaDetalleContrato(codConvenio, rut);
        Assert.assertNotNull(codOficina);
        Assert.assertEquals(codOficina, "");
    }


    @Test
    public void obtenerOficinaDetalleContratoExceptionObtenerDetalleTest() throws Exception{
        String codConvenio = "123456";
        String rut = "1-9";
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContrato.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        Mockito.doReturn(null).when(proxySucursal).consultarSucursal(Mockito.any(ConsultarSucursalRq.class));

        String codOficina = detalleContratoService.obtenerOficinaDetalleContrato(codConvenio, rut);
        Assert.assertNotNull(codOficina);
        Assert.assertEquals(codOficina, "");
    }

    @Test
    public void obtenerOficinaDetalleContratoExceptionTest2() throws Exception{
        String codConvenio = "123456";
        String rut = "1-9";
        Mockito.doReturn(null).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        String codOficina = detalleContratoService.obtenerOficinaDetalleContrato(codConvenio, rut);
        Assert.assertNotNull(codOficina);
        Assert.assertEquals(codOficina, "");
    }

    @Test
    public void obtenerOficinaDetalleContratoSinDetalleSucursalFaultTest() throws Exception{
        String codConvenio = "123456";
        String rut = "1-9";
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContrato.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        cl.bancochile.osb.bch.neg.recaudaciones.consultasucursalrecaudacion.v._1.FaultMsg faultMsg = new cl.bancochile.osb.bch.neg.recaudaciones.consultasucursalrecaudacion.v._1.FaultMsg("",new Details());
        Mockito.doThrow(faultMsg).when(proxySucursal).consultarSucursal(Mockito.any(ConsultarSucursalRq.class));

        String codOficina = detalleContratoService.obtenerOficinaDetalleContrato(codConvenio, rut);
        Assert.assertNotNull(codOficina);
        Assert.assertEquals(codOficina, "");
    }


    @Test
    public void obtenerDataAdicionalTest() throws Exception {
        String codConvenio = "123456";
        String rut = "1-9";
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContrato.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        DataAdicional dataAdicional = detalleContratoService.obtenerDataAdicional(codConvenio,rut);
        Assert.assertNotNull(dataAdicional);
        Assert.assertEquals(dataAdicional.getLargoDataAdicional(), "17");
        Assert.assertEquals(dataAdicional.getDatosAdicionales().size(), 2);
    }

    @Test
    public void obtenerDataAdicionalSinAdicionalTest() throws Exception {
        String codConvenio = "123456";
        String rut = "1-9";
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContratoSinDataAdicional.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        DataAdicional dataAdicional = detalleContratoService.obtenerDataAdicional(codConvenio,rut);
        Assert.assertNotNull(dataAdicional);
        Assert.assertEquals(dataAdicional.getLargoDataAdicional(), "0");
        Assert.assertEquals(dataAdicional.getDatosAdicionales().size(), 0);
    }


    @Test
    public void obtenerDataAdicionalAdicionalNullTest() throws Exception {
        String codConvenio = "123456";
        String rut = "1-9";
        Mockito.doReturn(null).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        DataAdicional dataAdicional = detalleContratoService.obtenerDataAdicional(codConvenio,rut);
        Assert.assertNotNull(dataAdicional);
        Assert.assertEquals(dataAdicional.getLargoDataAdicional(), "0");
    }
}
