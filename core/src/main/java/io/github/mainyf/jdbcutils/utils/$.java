package io.github.mainyf.jdbcutils.utils;

import java.util.Collection;
import java.util.function.Predicate;

public class $ {

    public static <T> T find(Collection<T> collection, Predicate<T> predicate) {
        for(T t : collection) {
            if(predicate.test(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T find(T[] collection, Predicate<T> predicate) {
        for(T t : collection) {
            if(predicate.test(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> boolean some(Collection<T> collection, Predicate<T> predicate) {
        return find(collection, predicate) != null;
    }
    public static <T> boolean some(T[] collection, Predicate<T> predicate) {
        return find(collection, predicate) != null;
    }

}
