package nickzxing.microservice.order.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/1/28 15:32
 * Data Transfer Object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = -4537162126504996545L;
    private Integer id;
    private Long userId;
    private String orderSn;
    private String username;
}
