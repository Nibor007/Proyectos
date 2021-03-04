package cl.bancochile.portal.common.recaudacion.domain;

import java.math.BigInteger;
import java.util.List;

public class DetalleContrato {
    private static final long serialVersionUID = 1L;

    private String recaudacionCaja;
    private String usoCodigoBarra;
    private String cuentaCorriente;
    private String fechaInicio;
    private String cobertura;
    private String tipoInteres;
    private String Moneda;
    private DataAdicional dataAdicional;
    private String nombreConvenio;
    private String canalRecaudacion;
    private List<BigInteger> listaCanales;

    public String getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(String tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String moneda) {
        Moneda = moneda;
    }

    public String getRecaudacionCaja() {
        return recaudacionCaja;
    }

    public void setRecaudacionCaja(String recaudacionCaja) {
        this.recaudacionCaja = recaudacionCaja;
    }

    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(String cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public String getUsoCodigoBarra() {
        return usoCodigoBarra;
    }

    public void setUsoCodigoBarra(String usoCodigoBarra) {
        this.usoCodigoBarra = usoCodigoBarra;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public DataAdicional getDataAdicional() {
        return dataAdicional;
    }

    public void setDataAdicional(DataAdicional dataAdicional) {
        this.dataAdicional = dataAdicional;
    }

    public String getCanalRecaudacion() {
        return canalRecaudacion;
    }

    public void setCanalRecaudacion(String canalRecaudacion) {
        this.canalRecaudacion = canalRecaudacion;
    }

    public String getNombreConvenio() {
        return nombreConvenio;
    }

    public void setNombreConvenio(String nombreConvenio) {
        this.nombreConvenio = nombreConvenio;
    }

    public List<BigInteger> getListaCanales() {
        return listaCanales;
    }

    public void setListaCanales(List<BigInteger> listaCanales) {
        this.listaCanales = listaCanales;
    }
}
