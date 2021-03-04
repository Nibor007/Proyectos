package cl.bancochile.portal.common.recaudacion.domain;


import cl.bancochile.portal.common.recaudacion.domain.enums.TipoDatoEnum;

public class CampoAdicional {

    private String largo;
    private TipoDatoEnum tipoDato;
    private String glosa;
    private String rutinaValidacion;
    private String rutinaServidor;


    public String getLargo() {
        return largo;
    }

    public void setLargo(String largo) {
        this.largo = largo;
    }

    public TipoDatoEnum getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(TipoDatoEnum tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getRutinaValidacion() {
        return rutinaValidacion;
    }

    public void setRutinaValidacion(String rutinaValidacion) {
        this.rutinaValidacion = rutinaValidacion;
    }

    public String getRutinaServidor() {
        return rutinaServidor;
    }

    public void setRutinaServidor(String rutinaServidor) {
        this.rutinaServidor = rutinaServidor;
    }
}
