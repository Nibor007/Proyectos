package cl.bancochile.portal.common.recaudacion.utils;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class DateUtilTest {

    @InjectMocks
    private DateUtil dateUtil;

    @Test
    public void dateToStringTest() {
        String retorno = dateUtil.dateToString(new Date(), "dd/MM/yyyy");
        Assert.assertNotNull(retorno);
    }

    @Test
    public void stringToDateTest() {
        Date date = dateUtil.stringToDate("25/09/1988", "dd/MM/yyyy");
        Assert.assertNotNull(date);
    }

    @Test
    public void stringToDateTestException() {
        Date date = dateUtil.stringToDate("25/09", "dd/MM/yyyy");
        if (date == null) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void xmlGregorianCalendartoDateTest() throws Exception {
        Date date = dateUtil.xmlGregorianCalendartoDate(DateUtil.stringToXMLGregorianCalendarExpecific("01/01/2016", DateUtil.FMT_FECHA_DD_MM_YYYY));
        Assert.assertNotNull(date);
    }

    @Test
    public void xmlGregorianCalendartoDateExceptionTest() throws Exception {
        Date date = dateUtil.xmlGregorianCalendartoDate(null);
        Assert.assertNull(date);
    }



}