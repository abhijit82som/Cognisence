/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkSupport;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 *
 * @author samarjit.chakraborty
 */

public class AnnotationMutator {

    public static Object changeAnnotationElementValue(Annotation annotation, String key, Object newValue) {

        Object handler = Proxy.getInvocationHandler(annotation);

        Field f = null;
        Map<String, Object> memberValues = null;
        Object oldValue = null;

        try {
            f = handler.getClass().getDeclaredField("memberValues");
        } catch (NoSuchFieldException | SecurityException e) {
            throw new IllegalStateException(e);
        }

        f.setAccessible(true);

        try {
            memberValues = (Map<String, Object>) f.get(handler);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }

        oldValue = memberValues.get(key);

        if (oldValue == null || oldValue.getClass() != newValue.getClass()) {
            throw new IllegalArgumentException();
        }

        memberValues.put(key, newValue);
        return oldValue;
    }
}
