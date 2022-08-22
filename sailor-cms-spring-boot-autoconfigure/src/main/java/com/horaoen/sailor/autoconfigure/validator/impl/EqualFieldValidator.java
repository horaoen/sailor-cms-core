package com.horaoen.sailor.autoconfigure.validator.impl;

import com.horaoen.sailor.autoconfigure.validator.EqualField;
import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * @author horaoen
 */
public class EqualFieldValidator implements ConstraintValidator<EqualField, Object> {
    private String srcField;
    private String dstField;

    public EqualFieldValidator() {
    }

    public void initialize(EqualField constraintAnnotation) {
        this.srcField = constraintAnnotation.srcField();
        this.dstField = constraintAnnotation.dstField();
    }

    public boolean isValid(Object object, ConstraintValidatorContext context) {
        Class<?> clazz = object.getClass();
        Field srcField = ReflectionUtils.findField(clazz, this.srcField);
        Field dstField = ReflectionUtils.findField(clazz, this.dstField);

        try {
            srcField.setAccessible(true);
            dstField.setAccessible(true);
            String src = (String)srcField.get(object);
            String dst = (String)dstField.get(object);
            return src.equals(dst);
        } catch (Exception var8) {
            return false;
        }
    }
}
