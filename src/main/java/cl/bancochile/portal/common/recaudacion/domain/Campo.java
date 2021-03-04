package cl.bancochile.portal.common.recaudacion.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Campo implements Comparable<Campo>{
    private String tipoRegistroPerteneciente;
    private Formato formato;
    private boolean llave;
    private int posision;
    private int largo;
    private boolean obligatorio;
    private boolean contabiliza;
    private boolean totaliza;
    private String patronValidacion;
    private String caracterDelimitador;
    private String mensajeError;
    private String nombreCampo;


    @Override //NOSONAR
    public int compareTo(Campo d){//NOSONAR
        return this.posision - d.posision;
    }


    public int getPosision() {
        return posision;
    }

    public void setPosision(int posision) {
        this.posision = posision;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public boolean isObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public boolean isContabiliza() {
        return contabiliza;
    }

    public void setContabiliza(boolean contabiliza) {
        this.contabiliza = contabiliza;
    }

    public boolean isTotaliza() {
        return totaliza;
    }

    public void setTotaliza(boolean totaliza) {
        this.totaliza = totaliza;
    }

    public String getPatronValidacion() {
        return patronValidacion;
    }

    public void setPatronValidacion(String patronValidacion) {
        this.patronValidacion = patronValidacion;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getTipoRegistroPerteneciente() {
        return tipoRegistroPerteneciente;
    }

    public void setTipoRegistroPerteneciente(String tipoRegistroPerteneciente) {
        this.tipoRegistroPerteneciente = tipoRegistroPerteneciente;
    }

    public boolean isLlave() {
        return llave;
    }

    public void setLlave(boolean llave) {
        this.llave = llave;
    }

    public boolean validar(String campoAValidar){
        Pattern p = Pattern.compile(this.getPatronValidacion());
        Matcher m = p.matcher(campoAValidar);
        return m.find();

    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public String getCaracterDelimitador() {
        return caracterDelimitador;
    }

    public void setCaracterDelimitador(String caracterDelimitador) {
        this.caracterDelimitador = caracterDelimitador;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }
}
