package nickzxing.starter.web.config;

import nickzxing.dependency.common.annotation.RestAPI;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author NickZxing
 * @date 2019/1/30 10:59
 * Spring配置类
 */
public class SpringConfiguration {

    /**
     * 添加自定义ReuqestMapping解析逻辑
     *
     * @return
     */
    @Bean
    public WebMvcRegistrations webRegistrations() {
        return new WebMvcRegistrations() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new RequestMappingHandlerMapping() {

                    // API类增加了RequestMapping时，FeignClient实现该接口则会导致RequestMapping重复加载，所以此时应该将含有FeignClient注解的类忽略RequestMapping
                    @Override
                    protected boolean isHandler(Class<?> beanType) {
                        return super.isHandler(beanType) &&
                                !AnnotatedElementUtils.hasAnnotation(beanType, FeignClient.class);
                    }

                    // 增加API类型
                    @Override
                    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
                        Class<?> beanType = method.getDeclaringClass();
                        RestAPI restAPI = AnnotationUtils.findAnnotation(beanType, RestAPI.class);

                        if (restAPI != null) {
                            if (restAPI.type() != null) {
                                PatternsRequestCondition apiPattern = new PatternsRequestCondition(restAPI.type().name().toLowerCase())
                                        .combine(mapping.getPatternsCondition());

                                mapping = new RequestMappingInfo(mapping.getName(), apiPattern,
                                        mapping.getMethodsCondition(), mapping.getParamsCondition(),
                                        mapping.getHeadersCondition(), mapping.getConsumesCondition(),
                                        mapping.getProducesCondition(), mapping.getCustomCondition());
                            }
                        }

                        super.registerHandlerMethod(handler, method, mapping);
                    }
                };
            }
        };
    }

    /**
     * Spring Validation 开启方法级别验证
     *
     * @return
     */
//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor() {
//        return new MethodValidationPostProcessor();
//    }
}
