package nickzxing.microservice.order.api.open;

import nickzxing.dependency.common.annotation.RestAPI;
import nickzxing.dependency.common.enums.APIType;
import nickzxing.microservice.order.api.dto.OrderDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author NickZxing
 * @date 2019/3/13 17:17
 */
@RestAPI(value = "/order", type = APIType.OPENAPI)
public interface OrderOpenAPI {

    String GET_BY_USER_ID = "/get_by_user_id";

    @RequestMapping(value = GET_BY_USER_ID, method = RequestMethod.GET)
    List<OrderDTO> getByUserId(@RequestParam(name = "userId") Long userId);
}
