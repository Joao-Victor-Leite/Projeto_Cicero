package com.duende.cicero_app.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public final class Utils {

    public static void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    private static String[] getNullPropertyNames(Object source) {

        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyFields = new HashSet<>();

        for(PropertyDescriptor pd : pds){
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null){
                emptyFields.add(pd.getName());
            }
        }
        return emptyFields.toArray(new String[0]);
    }

}
