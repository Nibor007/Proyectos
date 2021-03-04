package cl.bancochile.portal.common.recaudacion.converter;

import cl.bancochile.portal.common.recaudacion.domain.Campo;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idOUT;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idOut_cursorRS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class Sp_re_get_formato_by_idOUTToValidadorFormatoLineasTest {

    @InjectMocks
    private Sp_re_get_formato_by_idOUTToValidadorFormatoLineas convert;



    @Test
    public void convertTest() {
        Sp_re_get_formato_by_idOUT source = Mockito.mock(Sp_re_get_formato_by_idOUT.class);
        Sp_re_get_formato_by_idOut_cursorRS cursor = Mockito.mock(Sp_re_get_formato_by_idOut_cursorRS.class);
        Number number = Mockito.mock(Number.class);
        List<Sp_re_get_formato_by_idOut_cursorRS> out_cursor = new ArrayList<>();
        out_cursor.add(cursor);

        Mockito.doReturn(out_cursor).when(source).getOut_cursor();
        Mockito.doReturn(1).when(number).intValue();

        Mockito.doReturn(number).when(cursor).getTotaliza_campo();
        Mockito.doReturn(number).when(cursor).getTipo_registro_campo();
        Mockito.doReturn("ex").when(cursor).getRegex_campo();
        Mockito.doReturn(number).when(cursor).getClave_campo();
        Mockito.doReturn(number).when(cursor).getLargo_campo();
        Mockito.doReturn(number).when(cursor).getObligatorio_campo();
        Mockito.doReturn("mensaje").when(cursor).getMensaje_error_campo();

        Mockito.doReturn(number).when(cursor).getOrden_campo();
        Mockito.doReturn("nombre").when(cursor).getNombre_campo();

        Mockito.doReturn(number).when(cursor).getEditable_campo();

        List<Campo> rs = this.convert.convert(source);
        assertNotNull(rs);

    }
}