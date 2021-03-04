package cl.bancochile.portal.common.recaudacion.service;


import cl.bancochile.portal.common.recaudacion.domain.FechaHabil;
import cl.bancochile.portal.common.recaudacion.sal.ClienteWSCalculoFechaHabil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class FechaContableServiceImpl implements FechaContableService {

    @Autowired
    private ClienteWSCalculoFechaHabil clienteWSCalculoFechaHabil;

    @Override
    public FechaHabil obtenerFechaContableAnterior(String rutCliente, Date fecha, String numDiasCaulcular, String formatoFechaSalida) {

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(fecha);
        return clienteWSCalculoFechaHabil.calcularFechaContable(rutCliente, fecha, numDiasCaulcular, formatoFechaSalida);

    }
}
