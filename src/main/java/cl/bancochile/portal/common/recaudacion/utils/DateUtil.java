package cl.bancochile.portal.common.recaudacion.utils;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {

    public static final String FMT_FECHA_DD_MM_YYYY = "dd/MM/yyyy";
    public static final String FMT_FECHA_DD_MM_YYYY_GUION = "dd-MM-yyyy";
    public static final String FMT_FECHA_YYYYMMDD = "yyyyMMdd";
    private static final String LOCALE_LANGUAGE = "es";
    private static final String LOCALE_COUNTRY = "ES";


    private DateUtil() {
        //not used
    }

    public static String dateToString(Date fecha, String formato) {
        SimpleDateFormat formatter = new SimpleDateFormat(formato, new Locale(LOCALE_LANGUAGE,LOCALE_COUNTRY));
        return formatter.format(fecha);
    }

    public static Date stringToDate(String sdate, String formato) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(formato, new Locale(LOCALE_LANGUAGE,LOCALE_COUNTRY));
            Date date = formatter.parse(sdate);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date xmlGregorianCalendartoDate(XMLGregorianCalendar fecha) {
        if (fecha == null) {
            return null;
        }
        return fecha.toGregorianCalendar().getTime();
    }

    /* Genera XMLGregorianCalendar con formato yyyy MM dd ira con guines o / dependiendo del formato entregado */
    public static XMLGregorianCalendar stringToXMLGregorianCalendarExpecific(String fecha, String formatoFecha) throws Exception {
        DateFormat format = new SimpleDateFormat(formatoFecha, new Locale(LOCALE_LANGUAGE,LOCALE_COUNTRY));
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(format.parse(fecha));
        return DatatypeFactory.newInstance().newXMLGregorianCalendarDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
    }
}
