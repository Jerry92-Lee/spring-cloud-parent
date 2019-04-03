package nickzxing.dependency.common.annotation;

import nickzxing.dependency.common.enums.APIType;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.*;


/**
 * @author NickZxing
 * @date 2019/3/28 14:23
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping
public @interface RestAPI {

    @AliasFor(annotation = RequestMapping.class,
            attribute = "path")
    String[] value() default {};

    @AliasFor(annotation = RequestMapping.class,
            attribute = "value")
    String[] path() default {};

    APIType type();

    int version() default 0;
}
