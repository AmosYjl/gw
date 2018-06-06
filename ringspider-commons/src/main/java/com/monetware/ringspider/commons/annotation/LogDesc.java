package com.monetware.ringspider.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangjl
 * @version 3.0
 * 方法注解，日志用
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogDesc {
    public String commonDesc() default "常用描述";
    public String SpecialDesc() default "特别注意";
    public String remark() default "备注";

}
