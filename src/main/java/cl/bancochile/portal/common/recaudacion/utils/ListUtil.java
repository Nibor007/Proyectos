package cl.bancochile.portal.common.recaudacion.utils;


import java.util.List;

public class ListUtil {

    private ListUtil() {
        //not used
    }

    public static <T> T getFirst(List<T> list) {
        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

    public static <T> T getLast(List<T> list) {
        return list != null && !list.isEmpty() ? list.get(list.size() - 1) : null;
    }

}
