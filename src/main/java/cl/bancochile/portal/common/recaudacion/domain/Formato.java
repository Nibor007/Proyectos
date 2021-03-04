package cl.bancochile.portal.common.recaudacion.domain;


public class Formato {


    private String idFormato;
    private String nombreFormato;
    private String descripcion;
    private String notaAlPie;

    public String getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(String idFormato) {
        this.idFormato = idFormato;
    }

    public String getNombreFormato() {
        return nombreFormato;
    }

    public void setNombreFormato(String nombreFormato) {
        this.nombreFormato = nombreFormato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNotaAlPie() {
        return notaAlPie;
    }

    public void setNotaAlPie(String notaAlPie) {
        this.notaAlPie = notaAlPie;
    }
}
