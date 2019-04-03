package nickzxing.microservice.order.web.feign.client;

import nickzxing.microservice.order.web.constant.ApplicationConstant;
import nickzxing.microservice.order.web.feign.fallback.UserFeignClientFallback;
import nickzxing.microservice.user.api.service.UserServiceAPI;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author NickZxing
 * @date 2019/1/7 17:54
 * UserFeignClient
 */
//FeignClient的value值表示要调用的另一个微服务的实例名，对应其spring.application.name的值
@FeignClient(value = ApplicationConstant.FEIGN_CLIENT_USER, fallback = UserFeignClientFallback.class, path = "serviceapi")
public interface UserFeignClient extends UserServiceAPI {

}
