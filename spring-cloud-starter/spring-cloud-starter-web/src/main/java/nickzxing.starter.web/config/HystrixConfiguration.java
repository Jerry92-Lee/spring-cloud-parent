package nickzxing.starter.web.config;

import nickzxing.starter.web.strategy.FeignHystrixConcurrencyStrategy;
import org.springframework.context.annotation.Bean;

/**
 * @author NickZxing
 * @date 2019/3/8 15:04
 * Hystrix配置类
 */
public class HystrixConfiguration {

    @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
        return new FeignHystrixConcurrencyStrategy();
    }
}
