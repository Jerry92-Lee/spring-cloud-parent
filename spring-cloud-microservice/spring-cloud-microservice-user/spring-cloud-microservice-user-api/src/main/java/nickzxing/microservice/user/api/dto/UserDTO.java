package nickzxing.microservice.user.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 5843226531811925814L;
    private Long id;
    private String username;
}
