package cl.bancochile.portal.common.recaudacion.converter;


import cl.bancochile.portal.common.recaudacion.domain.Archivo;
import cl.bancochile.portal.common.recaudacion.domain.Campo;
import cl.bancochile.portal.common.recaudacion.domain.Formato;
import cl.bancochile.portal.common.recaudacion.domain.Registro;
import cl.bancochile.portal.common.recaudacion.filters.PredicateFactory;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idOUT;
import cl.bancochile.portal.empresa.recaudacion.persistence.bean.Sp_re_get_formato_by_idOut_cursorRS;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;


public class Sp_re_get_formato_by_idOUTToFormatoArchivo implements Converter<Sp_re_get_formato_by_idOUT, Archivo> {

    @Override
    public Archivo convert(Sp_re_get_formato_by_idOUT source) {
        Archivo salida= new Archivo();
        Formato formatoArch = null;

        List<Campo> campos= new ArrayList<>();
        List<Registro> registros= new ArrayList<>();
        Registro registro ;
        Campo campo =null;
        for (Sp_re_get_formato_by_idOut_cursorRS dato : source.getOut_cursor()) {

            if (formatoArch==null){
                formatoArch = new Formato();
                formatoArch.setNombreFormato(dato.getNombre_formato_archivo());
                formatoArch.setDescripcion(dato.getDescripcion_formato_archivo());
                formatoArch.setNotaAlPie(dato.getNota_formato_archivo());
            }

            campo = new Campo();

            campo.setLlave("1".equalsIgnoreCase(dato.getClave_campo().toString()));
            campo.setTipoRegistroPerteneciente(dato.getValor_tipo_registro_campo());
            campo.setPosision(dato.getClave_campo().intValue());
            campo.setLargo(dato.getLargo_campo().intValue());
            campo.setObligatorio("1".equalsIgnoreCase(dato.getObligatorio_campo().toString()));
            campo.setTotaliza("1".equalsIgnoreCase(dato.getTotaliza_campo().toString()));
            campo.setPatronValidacion(dato.getRegex_campo());
            campo.setMensajeError(dato.getMensaje_error_campo());

            Formato formatoCampo = new Formato();
            formatoCampo.setNotaAlPie("");
            formatoCampo.setDescripcion(dato.getDescripcion_campo());
            formatoCampo.setNombreFormato(dato.getNombre_campo());
            formatoCampo.setIdFormato("");
            campo.setFormato(formatoCampo);
            campos.add(campo);



        }
        Iterable<Campo> registrosLlave = Iterables.filter(campos, PredicateFactory.campoLlave);
        Iterable<Campo> camposDeRegistro = null;

        salida.setFormato(formatoArch);
        if("5".equalsIgnoreCase(source.getOut_cursor().get(0).getValor_tipo_registro_campo())){
            for (Campo c : campos) {
                registro = new Registro();
                camposDeRegistro = Iterables.filter(campos, PredicateFactory.correspondeLinea(c.getTipoRegistroPerteneciente()));
                registro.setCampos(Lists.newArrayList(camposDeRegistro));
                registro.setFormato(getFormatoRegistro(source, c.getTipoRegistroPerteneciente()));
                registros.add(registro);
            }
            salida.setRegistros(Lists.newArrayList(registros));
        }
        else {
            for (Campo c : registrosLlave) {
                registro = new Registro();
                camposDeRegistro = Iterables.filter(campos, PredicateFactory.correspondeLinea(c.getTipoRegistroPerteneciente()));
                registro.setCampos(Lists.newArrayList(camposDeRegistro));
                registro.setFormato(getFormatoRegistro(source, c.getTipoRegistroPerteneciente()));
                registros.add(registro);
            }
            salida.setRegistros(Lists.newArrayList(registros));
        }
        return salida;

    }

    private Formato getFormatoRegistro(Sp_re_get_formato_by_idOUT campos, String llave){
        Formato formato= new Formato() ;
        for (Sp_re_get_formato_by_idOut_cursorRS c: campos.getOut_cursor()) {

           if (c.getValor_tipo_registro_campo().equalsIgnoreCase(llave)) {
               formato.setNombreFormato(c.getNombre_tipo_registro());
               formato.setNotaAlPie(c.getNota_tipo_registro());
               formato.setDescripcion(c.getDescripcion_tipo_registro());
               formato.setIdFormato("");
               break;
           }
        }
        return formato;

    }
}
