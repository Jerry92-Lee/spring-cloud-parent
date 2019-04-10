package nickzxing.microservice.user.web.service.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Jerry
 * @version 2019-04-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserBO implements Serializable {

    private static final long serialVersionUID = 3951834812428096329L;
    private Long id;

    private String username;

    private String password;
}
