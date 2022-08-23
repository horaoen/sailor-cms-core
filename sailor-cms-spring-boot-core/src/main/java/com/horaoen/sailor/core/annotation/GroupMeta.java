package com.horaoen.sailor.core.annotation;


import com.horaoen.sailor.core.enumeration.UserLevel;

import java.lang.annotation.*;

/**
 * GroupRequired 和 PermissionMeta 融合注解
 *
 * @author pedro@TaleLin
 * @author colorful@TaleLin
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Required(level = UserLevel.GROUP)
@Deprecated
public @interface GroupMeta {

    String value() default "";

    String permission() default "";

    String module() default "";

    boolean mount() default true;

}