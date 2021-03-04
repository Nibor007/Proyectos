package cl.bancochile.portal.common.recaudacion.domain;

import java.util.List;

public class Archivo {
    private Formato formato;
    private List<Registro> registros;

    public Archivo() {
        //Constructor vacio.
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
}
