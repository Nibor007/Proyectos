package cl.bancochile.portal.common.recaudacion.sal;



import cl.bancochile.portal.common.recaudacion.domain.FechaHabil;

import java.util.Date;

public interface ClienteWSCalculoFechaHabil {
    FechaHabil calcularFechaContable(String rutCliente, Date fecha, String numDiasCaulcular, String formatoFechaSalida);
}
