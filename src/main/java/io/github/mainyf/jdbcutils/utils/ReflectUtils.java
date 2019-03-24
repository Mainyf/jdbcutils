package io.github.mainyf.jdbcutils.utils;

import com.google.common.collect.Sets;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class ReflectUtils {

    public static <A extends Annotation> A getAnnotation(Class<?> clazz, Class<A> annotation) {
        return clazz.getAnnotation(annotation);
    }

    public static Set<Field> getAllField(Class<?> clazz) {
        Set<Field> result = new HashSet<>();
        for(
            Class superClass = clazz;
            superClass != null && superClass != Object.class;
            superClass = superClass.getSuperclass()
        ) {
            result.addAll(Sets.newHashSet(superClass.getDeclaredFields()));
        }
        return result;
    }

}
