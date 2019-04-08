package nickzxing.microservice.order.web.config;

import nickzxing.dependency.common.enums.APIType;
import nickzxing.microservice.order.web.interceptor.ApiInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * @author NickZxing
 * @date 2019/4/2 23:21
 * 配置Spring拦截器
 */
@Configuration
public class SpringWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 拦截地址
     */
    final static List<String> includePathPatternsList = Arrays.asList(
            "/" + APIType.FRONTAPI.name().toLowerCase() + "/**",
            "/" + APIType.OPENAPI.name().toLowerCase() + "/**",
            "/" + APIType.SERVICEAPI.name().toLowerCase() + "/**");

    /**
     * 不拦截地址
     */
    final static List<String> excludePathPatternsList = Arrays.asList();

    @Bean
    public ApiInterceptor apiInterceptor() {
        return new ApiInterceptor();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(apiInterceptor())
//                .addPathPatterns(includePathPatternsList)
//                .excludePathPatterns(excludePathPatternsList);
//    }
}
