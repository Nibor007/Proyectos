package cl.bancochile.portal.common.recaudacion.converter;


import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idOUT;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idOut_cursorRS;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class Sp_re_get_formato_by_idOUTToFormatoArchivoTest {

    @Test
    public void testConvert() throws Exception {
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
        Sp_re_get_formato_by_idOUTToFormatoArchivo converter = new Sp_re_get_formato_by_idOUTToFormatoArchivo();
        assertNotNull(converter.convert(source));

    }

    @Test
    public void testConvertFormato5() throws Exception {
        Sp_re_get_formato_by_idOUT source = Mockito.mock(Sp_re_get_formato_by_idOUT.class);
        Sp_re_get_formato_by_idOut_cursorRS dato = Mockito.mock(Sp_re_get_formato_by_idOut_cursorRS.class);
        List<Sp_re_get_formato_by_idOut_cursorRS> out_cursor = new ArrayList<>();
        out_cursor.add(dato);
        Mockito.doReturn(out_cursor).when(source).getOut_cursor();
        Mockito.doReturn(BigInteger.ONE).when(dato).getClave_campo();
        Mockito.doReturn(BigInteger.TEN).when(dato).getLargo_campo();
        Mockito.doReturn(BigInteger.ONE).when(dato).getObligatorio_campo();
        Mockito.doReturn(BigInteger.ONE).when(dato).getTotaliza_campo();
        Mockito.doReturn("5").when(dato).getValor_tipo_registro_campo();
        Sp_re_get_formato_by_idOUTToFormatoArchivo converter = new Sp_re_get_formato_by_idOUTToFormatoArchivo();
        assertNotNull(converter.convert(source));

    }
}