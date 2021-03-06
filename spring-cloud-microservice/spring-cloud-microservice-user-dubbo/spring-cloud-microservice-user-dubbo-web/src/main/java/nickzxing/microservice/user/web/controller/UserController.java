package nickzxing.microservice.user.web.controller;

import nickzxing.dependency.common.util.CopyUtils;
import nickzxing.microservice.dubbo.user.api.service.UserService;
import nickzxing.microservice.user.api.dto.UserDTO;
import nickzxing.microservice.user.api.service.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author NickZxing
 * @date 2019/1/28 16:09
 * Controller
 */
@RestController
public class UserController implements UserServiceAPI {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public UserDTO get(@RequestParam(name = "id") Long id) {
        return CopyUtils.copyBean(userService.get(id), UserDTO.class);
    }

    @RequestMapping(value = "/get_path/{id}", method = RequestMethod.GET)
    public UserDTO getPath(@PathVariable(name = "id") Long id) {
        return CopyUtils.copyBean(userService.get(id), UserDTO.class);
    }

    @RequestMapping(value = "/get_body", method = RequestMethod.POST)
    public UserDTO postBody(@RequestBody UserDTO userDTO) {
        return CopyUtils.copyBean(userService.get(userDTO.getId()), UserDTO.class);
    }
}
