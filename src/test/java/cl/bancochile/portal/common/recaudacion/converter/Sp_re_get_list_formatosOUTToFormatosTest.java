package cl.bancochile.portal.common.recaudacion.converter;



import cl.bancochile.portal.common.recaudacion.domain.Formato;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_list_formatosOUT;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_list_formatosOut_cursorRS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class Sp_re_get_list_formatosOUTToFormatosTest {

    @InjectMocks
    private Sp_re_get_list_formatosOUTToFormatos convert;

    @Test
    public void convertTest() {
        Sp_re_get_list_formatosOUT source = Mockito.mock(Sp_re_get_list_formatosOUT.class);
        Sp_re_get_list_formatosOut_cursorRS cursor = Mockito.mock(Sp_re_get_list_formatosOut_cursorRS.class);
        Number number = Mockito.mock(Number.class);
        List<Sp_re_get_list_formatosOut_cursorRS> out_cursor = new ArrayList<>();
        out_cursor.add(cursor);

        Mockito.doReturn(out_cursor).when(source).getOut_cursor();
        Mockito.doReturn(2).when(number).intValue();
        Mockito.doReturn(number).when(cursor).getPk_formato();
        Mockito.doReturn("nombre").when(cursor).getNombre();

        List<Formato> rs = this.convert.convert(source);
        assertNotNull(rs);
        assertEquals("2", rs.get(0).getIdFormato());
        assertEquals("nombre", rs.get(0).getNombreFormato());

    }
}
