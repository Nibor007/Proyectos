package cl.bancochile.portal.common.recaudacion.domain.enums;

/**
 * Created by Administrador on 12-08-2016.
 */
public enum ArchivosEnum {
    CUPONERA("cuponera", "2"),
    VALIDACION("validacion","1"),
    INGRESO_RECAUDACION_CUOTAS("ingreso_recau_cuotas","5");

    private String archivo;
    private String id;

    ArchivosEnum(String archivo, String id) {
        this.archivo = archivo;
        this.id= id;
    }

    public String getId() {
        return id;
    }

    public String getArchivo() {
        return archivo;
    }

}
