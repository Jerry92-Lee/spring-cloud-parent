package nickzxing.microservice.user.web.service;

import nickzxing.microservice.user.web.service.bo.UserBO;

/**
 * @author NickZxing
 * @date 2019/3/7 18:16
 */
public interface UserService {

    UserBO get(Long id);
}
