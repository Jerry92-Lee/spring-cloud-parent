package nickzxing.microservice.order.web.service.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/1/28 15:32
 * Business Object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderBO implements Serializable {

    private static final long serialVersionUID = -4085098386027305818L;
    private Long id;

    private String orderSn;

    private Long userId;
}
