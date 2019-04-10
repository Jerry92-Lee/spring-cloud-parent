package nickzxing.microservice.order.web.controller;

import nickzxing.dependency.common.util.CopyUtils;
import nickzxing.microservice.dubbo.user.api.service.UserService;
import nickzxing.microservice.order.api.dto.OrderDTO;
import nickzxing.microservice.order.api.open.OrderOpenAPI;
import nickzxing.microservice.order.web.service.OrderService;
import nickzxing.microservice.user.api.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author NickZxing
 * @date 2019/1/28 16:09
 * Controller
 */
@RestController
public class OrderController implements OrderOpenAPI {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;
//    UserFeignClient userFeignClient;

    @Override
    public List<OrderDTO> getByUserId(Long userId) {
        UserDTO userDTO = userService.get(userId);
//        UserDTO userDTO2 = userFeignClient.getPath(userId);
//        UserDTO userDTO3 = userFeignClient.postBody(UserDTO.builder().id(userId).build());

        System.out.println("@RequestParam:" + userDTO);
//        System.out.println("@PathVariable:" + userDTO2);
//        System.out.println("@RequestBody:" + userDTO3);

        return CopyUtils.copyList(orderService.getByUserId(userId), OrderDTO.class);
    }
}
