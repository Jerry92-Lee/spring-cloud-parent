package nickzxing.microservice.user.api.service;

import nickzxing.dependency.common.annotation.RestAPI;
import nickzxing.dependency.common.enums.APIType;
import nickzxing.microservice.user.api.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @author NickZxing
 * @date 2019/3/13 17:17
 */
@RestAPI(value = "/user", type = APIType.SERVICEAPI)
public interface UserServiceAPI {

    String GET = "/get";
    String GET_PATH = "/get_path/{id}";
    String POST_BODY = "/get_body";

    @RequestMapping(value = GET, method = RequestMethod.GET)
    UserDTO get(@RequestParam(name = "id") Long id);

    @RequestMapping(value = GET_PATH, method = RequestMethod.GET)
    UserDTO getPath(@PathVariable(name = "id") Long id);

    @RequestMapping(value = POST_BODY, method = RequestMethod.POST)
    UserDTO postBody(@RequestBody UserDTO userDTO);
}
