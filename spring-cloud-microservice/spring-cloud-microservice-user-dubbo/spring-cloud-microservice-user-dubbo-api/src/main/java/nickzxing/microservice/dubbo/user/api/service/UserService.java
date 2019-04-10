package nickzxing.microservice.dubbo.user.api.service;

import nickzxing.microservice.user.api.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jerry
 * @version 2019-04-09
 */
@FeignClient("user-web-dubbo")
public interface UserService {
    @GetMapping("/get")
    UserDTO get(Long id);
}
