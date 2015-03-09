package com.geencloud.website.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>仅作为标识使用
 * <p>场景：pms接口需要参数传递(@RequestParam(reqired=true))
 * <p>默认值为"",非null
 * @author leejianhao
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface RequestParamRequired {
}
