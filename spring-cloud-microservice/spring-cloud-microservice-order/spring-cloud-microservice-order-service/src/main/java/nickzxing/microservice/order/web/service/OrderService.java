package nickzxing.microservice.order.web.service;

import nickzxing.microservice.order.web.service.bo.OrderBO;

import java.util.List;

/**
 * @author NickZxing
 * @date 2019/3/7 18:16
 */
public interface OrderService {

    List<OrderBO> getByUserId(Long userId);
}
