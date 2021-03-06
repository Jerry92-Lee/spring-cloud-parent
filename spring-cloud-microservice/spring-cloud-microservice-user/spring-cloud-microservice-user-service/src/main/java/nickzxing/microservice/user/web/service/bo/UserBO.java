package nickzxing.microservice.user.web.service.bo;

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
public class UserBO implements Serializable {

    private static final long serialVersionUID = 4999831428613499689L;
    private Long id;

    private String username;

    private String password;
}
