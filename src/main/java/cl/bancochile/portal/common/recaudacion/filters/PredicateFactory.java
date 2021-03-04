package cl.bancochile.portal.common.recaudacion.filters;


import cl.bancochile.portal.common.recaudacion.domain.Campo;
import com.google.common.base.Predicate;

/**
 * Created by amendez on 18-08-16.
 */
public final class PredicateFactory {

    private PredicateFactory() {
        //constructor vacio
    }

    public static final Predicate<Campo> campoLlave = new Predicate<Campo>() {
        @Override
        public boolean apply(Campo campo) {
            return campo != null && campo.isLlave();
        }
    };

    public static Predicate<Campo> correspondeLinea(final String tipoRegistro) {
        Predicate<Campo> predicate = new Predicate<Campo>() {
            @Override
            public boolean apply(Campo input) {
                return (input != null) && (input.getTipoRegistroPerteneciente() != null) &&
                        input.getTipoRegistroPerteneciente().equals(tipoRegistro);
            }
        };
        return predicate;
    }
}

