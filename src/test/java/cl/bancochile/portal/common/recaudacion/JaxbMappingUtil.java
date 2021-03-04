package cl.bancochile.portal.common.recaudacion;

import javax.xml.bind.JAXB;
import java.io.InputStream;


public class JaxbMappingUtil {

    public static <T> T getObjectByXml(Class<T> classTo, String xmlPath){
        InputStream in = JaxbMappingUtil.class.getClassLoader().getResourceAsStream(xmlPath);
        return classTo.cast(JAXB.unmarshal(in, classTo));
    }
}
