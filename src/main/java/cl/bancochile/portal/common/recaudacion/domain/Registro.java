package cl.bancochile.portal.common.recaudacion.domain;

import java.util.List;


public class Registro {

    private Formato formato;
    private List<Campo> campos;

    public Registro() {
        //Constructor vacio.
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    public Registro(List<Campo> campos) {
        this.campos = campos;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
}
