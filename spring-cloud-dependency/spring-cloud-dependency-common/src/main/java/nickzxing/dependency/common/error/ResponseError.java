package nickzxing.dependency.common.error;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author NickZxing
 * @date 2019/4/2 17:12
 * 错误信息
 */
public class ResponseError {

    /**
     * 发送错误信息
     * @param response
     * @param httpStatus
     */
    public static void send(HttpServletResponse response, HttpStatus httpStatus) {
        response.setCharacterEncoding("UTF-8");
        response.setStatus(httpStatus.value());
        try {
            response.getWriter().write(httpStatus.getReasonPhrase());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
