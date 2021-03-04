package cl.bancochile.portal.common.recaudacion.domain;

import java.util.Date;

/**
 * Created by Ismael on 02-09-16.
 */
public class FechaHabilReq {

    private Date fecha;
    private String dias;

    public FechaHabilReq() {
        //necesario para el builder
    }

    private FechaHabilReq(Builder builder) {
        setFecha(builder.fecha);
        setDias(builder.dias);
    }

    public Date getFecha() {
        return fecha; //NOSONAR
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;//NOSONAR
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }


    public static final class Builder {
        private Date fecha;
        private String dias;

        public Builder() {
            //constructor vacio.
        }

        public Builder fecha(Date val) {
            fecha = val;//NOSONAR
            return this;
        }

        public Builder dias(String val) {
            dias = val;
            return this;
        }

        public FechaHabilReq build() {
            return new FechaHabilReq(this);
        }
    }
}
