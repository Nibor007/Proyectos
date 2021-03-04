package cl.bancochile.portal.common.recaudacion.service;


import cl.bancochile.portal.common.recaudacion.domain.FechaHabil;

import java.util.Date;

public interface FechaContableService {
    FechaHabil obtenerFechaContableAnterior(String rutCliente, Date fechaEntrada, String numDiasCaulcular, String formatoFechaSalida);
}
