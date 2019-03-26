package nickzxing.microservice.order.web;

import nickzxing.microservice.order.web.constant.ApplicationConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author NickZxing
 * @date 2019/2/28 15:50
 * 订单微服务SC启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(ApplicationConstant.FEIGN_CLIENT_BASE_PACKAGES)
public class OrderWebApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderWebApplication.class, args);
    }
}
