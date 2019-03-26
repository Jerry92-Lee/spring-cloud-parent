package nickzxing.dependency.common.msg;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/2/28 15:13
 * 验证信息
 */
@Data
public class ValidationMessage implements Serializable {

    private static final long serialVersionUID = 1;

    // 参数名
    private String arg;

    // 参数索引
    private Integer index;

    // 验证信息
    private String message;

}
