package nickzxing.microservice.order.web.feign.fallback;

import nickzxing.microservice.order.web.feign.client.UserFeignClient;
import nickzxing.microservice.user.api.dto.UserDTO;
import org.springframework.stereotype.Component;

/**
 * @author NickZxing
 * @date 2019/2/13 14:10
 * UserFeignClient Fallback执行类
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public UserDTO get(Long id) {
        return null;
    }

    @Override
    public UserDTO getPath(Long id) {
        return null;
    }

    @Override
    public UserDTO postBody(UserDTO userDTO) {
        return null;
    }
}
