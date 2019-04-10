package nickzxing.microservice.user.web.service.impl;

import nickzxing.dependency.common.util.CopyUtils;
import nickzxing.microservice.dubbo.user.api.service.UserService;
import nickzxing.microservice.user.api.dto.UserDTO;
import nickzxing.microservice.user.web.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jerry
 * @version 2019-04-09
 */
@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO get(Long id) {
        return CopyUtils.copyBean(userRepository.findById(id).get(), UserDTO.class);
    }
}
