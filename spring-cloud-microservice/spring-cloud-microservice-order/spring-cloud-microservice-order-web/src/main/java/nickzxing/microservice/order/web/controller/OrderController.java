package nickzxing.microservice.order.web.controller;

import nickzxing.dependency.common.util.CopyUtils;
import nickzxing.microservice.order.api.dto.OrderDTO;
import nickzxing.microservice.order.api.open.OrderOpenAPI;
import nickzxing.microservice.order.web.feign.client.UserFeignClient;
import nickzxing.microservice.order.web.service.OrderService;
import nickzxing.microservice.user.api.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
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
    UserFeignClient userFeignClient;

    @Override
    public List<OrderDTO> getByUserId(@RequestParam(name = "userId") Long userId) {

        UserDTO userDTO1 = userFeignClient.get(userId);
        UserDTO userDTO2 = userFeignClient.getPath(userId);

        UserDTO requestBody = new UserDTO();
        requestBody.setId(userId);
        UserDTO userDTO3 = userFeignClient.postBody(requestBody);


        System.out.println("@RequestParam:" + userDTO1);
        System.out.println("@PathVariable:" + userDTO2);
        System.out.println("@RequestBody:" + userDTO3);

        return CopyUtils.copyList(orderService.getByUserId(userId), OrderDTO.class);
    }
}
