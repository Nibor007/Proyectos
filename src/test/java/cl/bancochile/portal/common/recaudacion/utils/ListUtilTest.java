package cl.bancochile.portal.common.recaudacion.utils;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ListUtilTest {

    @InjectMocks
    private ListUtil listUtil;


    @Test
    public void getFirst() throws Exception {
        List<Integer> listadoMock = Arrays.asList(new Integer[] { 1, 2, 3 });
        Integer valorInicial = listUtil.getFirst(listadoMock);
        Assert.assertNotNull(valorInicial);
        Assert.assertEquals(1,valorInicial.intValue());
    }

    @Test
    public void getFirstListEmpty() throws Exception {
        List<Integer> listadoMock = new ArrayList<>();
        Integer valorInicial = listUtil.getFirst(listadoMock);
        Assert.assertNull(valorInicial);
    }

    @Test
    public void getFirstNull() throws Exception {
        List<Integer> listadoMock = null;
        Integer valorInicial = listUtil.getFirst(listadoMock);
        Assert.assertNull(valorInicial);
    }


    @Test
    public void getLast() throws Exception {
        List<Integer> listadoMock = Arrays.asList(new Integer[] { 1, 2, 3 });
        Integer valorFinal = listUtil.getLast(listadoMock);
        Assert.assertNotNull(valorFinal);
        Assert.assertEquals(3,valorFinal.intValue());
    }

    @Test
    public void getLastEmpty() throws Exception {
        List<Integer> listadoMock = new ArrayList<>();
        Integer valorFinal = listUtil.getLast(listadoMock);
        Assert.assertNull(valorFinal);
    }

    @Test
    public void getLastNull() throws Exception {
        List<Integer> listadoMock = null;
        Integer valorFinal = listUtil.getLast(listadoMock);
        Assert.assertNull(valorFinal);
    }
}