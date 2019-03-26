package nickzxing.microservice.user.web.controller;

import nickzxing.dependency.common.util.CopyUtils;
import nickzxing.microservice.user.api.dto.UserDTO;
import nickzxing.microservice.user.api.open.UserOpenAPI;
import nickzxing.microservice.user.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NickZxing
 * @date 2019/1/28 16:09
 * Controller
 */
@RestController
public class UserController implements UserOpenAPI {

    @Autowired
    UserService userService;

    @Override
    public UserDTO get(@RequestParam(name = "id") Long id) {
        return CopyUtils.copyBean(userService.get(id), UserDTO.class);
    }

    @Override
    public UserDTO getPath(@PathVariable(name = "id") Long id) {
        return CopyUtils.copyBean(userService.get(id), UserDTO.class);
    }

    @Override
    public UserDTO postBody(@RequestBody UserDTO userDTO) {
        return CopyUtils.copyBean(userService.get(userDTO.getId()), UserDTO.class);
    }
}
