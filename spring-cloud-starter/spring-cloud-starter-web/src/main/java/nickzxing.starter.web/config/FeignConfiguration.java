package nickzxing.starter.web.config;

import nickzxing.starter.web.interceptor.FeignInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * @author NickZxing
 * @date 2019/1/15 15:28
 * Feign配置类
 */
public class FeignConfiguration {

    @Bean
    public FeignInterceptor feignInterceptor() {
        return new FeignInterceptor();
    }
}
