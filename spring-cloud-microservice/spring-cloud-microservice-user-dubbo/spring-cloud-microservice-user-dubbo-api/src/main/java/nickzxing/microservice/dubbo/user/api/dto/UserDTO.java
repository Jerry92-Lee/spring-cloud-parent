package nickzxing.microservice.dubbo.user.api.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/3/13 17:17
 * Data Transfer Object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 5843226531811925814L;

    private Long id;

    @NotBlank(message = "{user.username.notBlank}")
    private String username;
}
