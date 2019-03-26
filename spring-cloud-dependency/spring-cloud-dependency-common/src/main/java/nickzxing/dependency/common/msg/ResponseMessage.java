package nickzxing.dependency.common.msg;

import lombok.Data;
import nickzxing.dependency.common.constant.StringConstant;

import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/2/28 15:13
 * 返回信息
 */
@Data
public class ResponseMessage implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 返回码
     */
    private String code;

    /**
     * 外部信息
     */
    private String outMsg;

    /**
     * 内部信息
     */
    private String inMsg;

    /**
     * 返回体
     */
    private Object data;

    /**
     * 成功返回体
     *
     * @param data
     */
    public ResponseMessage(Object data) {
        this.code = StringConstant.NUM_0;
        this.outMsg = StringConstant.ZH_SUCCESS;
        this.inMsg = StringConstant.EN_SUCCESS;
        this.data = data;
    }
}
