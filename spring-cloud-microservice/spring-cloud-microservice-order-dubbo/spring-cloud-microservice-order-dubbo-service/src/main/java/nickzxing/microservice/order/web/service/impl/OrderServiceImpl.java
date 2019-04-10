package nickzxing.microservice.order.web.service.impl;

import nickzxing.dependency.common.util.CopyUtils;
import nickzxing.microservice.order.web.repo.OrderRepository;
import nickzxing.microservice.order.web.service.OrderService;
import nickzxing.microservice.order.web.service.bo.OrderBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NickZxing
 * @date 2019/3/7 18:17
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderBO> getByUserId(Long id) {
        return CopyUtils.copyList(orderRepository.findByUserId(id), OrderBO.class);
    }
}
