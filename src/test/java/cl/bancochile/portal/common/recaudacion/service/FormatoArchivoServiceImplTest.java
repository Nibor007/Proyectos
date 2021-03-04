package cl.bancochile.portal.common.recaudacion.service;


import cl.bancochile.portal.common.recaudacion.domain.Archivo;
import cl.bancochile.portal.common.recaudacion.domain.Campo;
import cl.bancochile.portal.common.recaudacion.domain.Formato;
import cl.bancochile.portal.common.recaudacion.exception.TraducibleSystemException;
import cl.bancochile.portal.empresa.recaudacion.persistence.Sp_re_get_formato_by_idService;
import cl.bancochile.portal.empresa.recaudacion.persistence.Sp_re_get_list_formatosService;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.*;
import cl.bancochile.portal.empresa.recaudacion.persistence.exception.ServiceException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context-test.xml"})
public class FormatoArchivoServiceImplTest {

    @Autowired
    private FormatoArchivoServiceImpl formatoArchivoService;

    @Autowired
    private Sp_re_get_formato_by_idService sp_re_get_formato_by_idService;

    @Autowired
    private Sp_re_get_list_formatosService sp_re_get_list_formatosService;


    @Test
    public void getFormatoArchivoByIdFormatoTest() throws Exception {
        Sp_re_get_formato_by_idOUT rs = Mockito.mock(Sp_re_get_formato_by_idOUT.class);
        Mockito.doReturn(rs).when(sp_re_get_formato_by_idService).execute(Mockito.any(Sp_re_get_formato_by_idIN.class));
        List<Campo> campos = formatoArchivoService.getFormatoArchivoByIdFormato("1");
        assertNotNull(campos);
        Mockito.verify(sp_re_get_formato_by_idService, Mockito.atLeast(1)).execute(Mockito.any(Sp_re_get_formato_by_idIN.class));
    }

    @Test (expected = TraducibleSystemException.class)
    public void getFormatoArchivoByIdFormatoExceptionSpTest() throws Exception {
        ServiceException exception = Mockito.mock(ServiceException.class);
        Mockito.doThrow(exception).when(sp_re_get_formato_by_idService).execute(Mockito.any(Sp_re_get_formato_by_idIN.class));
        formatoArchivoService.getFormatoArchivoByIdFormato("1");
    }

    @Test
    public void getTiposFormatoByConvenioAndTipoTest(){
        Sp_re_get_list_formatosOUT rs = Mockito.mock(Sp_re_get_list_formatosOUT.class);
        Mockito.doReturn(rs).when(sp_re_get_list_formatosService).execute(Mockito.any(Sp_re_get_list_formatosIN.class));
        List<Formato> formatos = formatoArchivoService.getTiposFormatoByConvenioAndTipo("cuponera","000500");
        assertNotNull(formatos);
        Mockito.verify(sp_re_get_list_formatosService).execute(Mockito.any(Sp_re_get_list_formatosIN.class));
    }

    @Test (expected = TraducibleSystemException.class)
    public void getTiposFormatoByConvenioAndTipoIncompatibleTipoTest(){
        Sp_re_get_list_formatosOUT rs = Mockito.mock(Sp_re_get_list_formatosOUT.class);
        Mockito.doReturn(rs).when(sp_re_get_list_formatosService).execute(Mockito.any(Sp_re_get_list_formatosIN.class));
        formatoArchivoService.getTiposFormatoByConvenioAndTipo("nombre_no_valido","000500");
    }

    @Test (expected = TraducibleSystemException.class)
    public void getTiposFormatoByConvenioAndTipoExceptionSpTest(){
        ServiceException exception = Mockito.mock(ServiceException.class);
        Mockito.doThrow(exception).when(sp_re_get_list_formatosService).execute(Mockito.any(Sp_re_get_list_formatosIN.class));
        formatoArchivoService.getTiposFormatoByConvenioAndTipo("nombre_no_valido","000500");
    }

    @Test
    public void getFormatoArchivoPorIdTest() throws Exception {
        Sp_re_get_formato_by_idOUT source = Mockito.mock(Sp_re_get_formato_by_idOUT.class);
        Sp_re_get_formato_by_idOut_cursorRS dato = Mockito.mock(Sp_re_get_formato_by_idOut_cursorRS.class);
        List<Sp_re_get_formato_by_idOut_cursorRS> out_cursor = new ArrayList<>();
        out_cursor.add(dato);
        Mockito.doReturn(out_cursor).when(source).getOut_cursor();
        Mockito.doReturn(BigInteger.ONE).when(dato).getClave_campo();
        Mockito.doReturn(BigInteger.TEN).when(dato).getLargo_campo();
        Mockito.doReturn(BigInteger.ONE).when(dato).getObligatorio_campo();
        Mockito.doReturn(BigInteger.ONE).when(dato).getTotaliza_campo();
        Mockito.doReturn("valor").when(dato).getValor_tipo_registro_campo();
        Mockito.doReturn(source).when(sp_re_get_formato_by_idService).execute(Mockito.any(Sp_re_get_formato_by_idIN.class));
        Archivo archivo = formatoArchivoService.getFormatoArchivoPorId("1");
        assertNotNull(archivo);
    }

    @Test (expected = TraducibleSystemException.class)
    public void getFormatoArchivoPorIdExceptionTest() throws Exception {
        ServiceException exception = Mockito.mock(ServiceException.class);
        Mockito.doThrow(exception).when(sp_re_get_formato_by_idService).execute(Mockito.any(Sp_re_get_formato_by_idIN.class));
        formatoArchivoService.getFormatoArchivoPorId("1");
    }
}
