package nickzxing.microservice.user.web.service.impl;

import nickzxing.dependency.common.util.CopyUtils;
import nickzxing.microservice.user.web.repo.UserRepository;
import nickzxing.microservice.user.web.service.UserService;
import nickzxing.microservice.user.web.service.bo.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author NickZxing
 * @date 2019/3/7 18:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserBO get(Long id) {
        return CopyUtils.copyBean(userRepository.findById(id).get(), UserBO.class);
    }
}
