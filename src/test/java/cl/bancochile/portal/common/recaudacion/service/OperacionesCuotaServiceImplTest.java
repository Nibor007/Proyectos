package cl.bancochile.portal.common.recaudacion.service;


import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrq.mpi.ConsultarCobranzasExternasRq;
import cl.bancochile.osb.bch.neg.pagos.cobranzaexterna.consultarcobranzasexternasrs.mpi.ConsultarCobranzasExternasRs;
import cl.bancochile.osb.neg.pagos.cobranzaexterna.v._1.CobranzaExternaPort;
import cl.bancochile.portal.common.recaudacion.JaxbMappingUtil;
import cl.bancochile.portal.common.recaudacion.exception.TraducibleSystemException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context-test.xml"})
public class OperacionesCuotaServiceImplTest {

    @Autowired
    private OperacionesCuotaServiceImpl operacionesCuotaService;

    @Autowired
    private CobranzaExternaPort proxy;

    @Test
    public void tieneFunTest() throws Exception {
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContrato.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        Boolean tieneFun = operacionesCuotaService.tieneFun("000123","19");
        Assert.assertTrue(tieneFun);
    }

    @Test (expected = TraducibleSystemException.class)
    public void tieneFunSinFunConfiguradoTest() throws Exception {
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContratoSinFun.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        operacionesCuotaService.tieneFun("000123","19");
    }

    @Test (expected = TraducibleSystemException.class)
    public void tieneFunMalConfiguradoTest() throws Exception {
        ConsultarCobranzasExternasRs rs = JaxbMappingUtil.getObjectByXml(ConsultarCobranzasExternasRs.class, "xmlResponse/detalleContratoFunMalConfigurado.xml");
        Mockito.doReturn(rs).when(proxy).consultarCobranzasExternas(Mockito.any(ConsultarCobranzasExternasRq.class));
        operacionesCuotaService.tieneFun("000123","19");
    }
}
