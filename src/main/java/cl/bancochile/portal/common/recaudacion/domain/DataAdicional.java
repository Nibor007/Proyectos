package cl.bancochile.portal.common.recaudacion.domain;


import java.util.List;

public class DataAdicional {

    private List<CampoAdicional> datosAdicionales;
    private String largoDataAdicional = "0";


    public List<CampoAdicional> getDatosAdicionales() {
        return datosAdicionales;
    }

    public void setDatosAdicionales(List<CampoAdicional> datosAdicionales) {
        this.datosAdicionales = datosAdicionales;
    }

    public String getLargoDataAdicional() {
        return largoDataAdicional;
    }

    public void setLargoDataAdicional(String largoDataAdicional) {
        this.largoDataAdicional = largoDataAdicional;
    }
}
