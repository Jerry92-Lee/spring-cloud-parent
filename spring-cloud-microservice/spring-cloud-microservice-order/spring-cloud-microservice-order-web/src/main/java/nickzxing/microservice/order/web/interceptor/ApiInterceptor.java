package nickzxing.microservice.order.web.interceptor;

import nickzxing.dependency.common.enums.APIType;
import nickzxing.dependency.common.error.ResponseError;
import nickzxing.dependency.common.util.CookieUtils;
import nickzxing.dependency.common.util.IpUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NickZxing
 * @date 2019/4/2 15:52
 * Api拦截器
 */
public class ApiInterceptor implements HandlerInterceptor {

    @Value("${host.list}")
    String[] hostList;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        final String requestURI = request.getRequestURI();

        //如果请求地址包含frontapi
        if (requestURI.contains(APIType.FRONTAPI.name().toLowerCase())) {
            if (!isComeFormGateway(request)) {
                //根据实际情况封装错误信息，此处仅作为示例
                ResponseError.send(response, HttpStatus.BAD_REQUEST);
                return false;
            }
            if (!isValidToken(request)) {
                //根据实际情况封装错误信息，此处仅作为示例
                ResponseError.send(response, HttpStatus.UNAUTHORIZED);
                return false;
            }
        }
        //如果请求地址包含openapi
        else if (requestURI.contains(APIType.OPENAPI.name().toLowerCase())) {
            if (!isValidApikey(request)) {
                //根据实际情况封装错误信息，此处仅作为示例
                ResponseError.send(response, HttpStatus.UNAUTHORIZED);
                return false;
            }
        }
        //如果请求地址包含serviceapi
        else if (requestURI.contains(APIType.SERVICEAPI.name().toLowerCase())) {

        }
        //如果都不包含则不允许通过
        else {
            //根据实际情况封装错误信息，此处仅作为示例
            ResponseError.send(response, HttpStatus.BAD_REQUEST);
            return false;
        }

        //判断请求接口的远程IP合法性
        if (!isValidAddr(request)) {
            ResponseError.send(response, HttpStatus.FORBIDDEN);
            return false;
        }

        return true;
    }

    //判断请求是否来自gateway
    public boolean isComeFormGateway(HttpServletRequest request) {
        final String header = request.getHeader("X-From-Gateway");
        if (null == header || !"1".equals(header)) {
            return false;
        }
        return true;
    }

    //判断token是否合法
    public boolean isValidToken(HttpServletRequest request) {
        final String token = CookieUtils.getCookie(request, "token");
        if (StringUtils.isBlank(token)) {
            return false;
        }
        //合法性判断规则 to do...

        return true;
    }

    //判断apikey是否合法
    public boolean isValidApikey(HttpServletRequest request) {
        final String apikeyInHeader = request.getHeader("apikey");
        final String apikeyInParameter = request.getParameter("apikey");
        if (StringUtils.isBlank(apikeyInHeader) && StringUtils.isBlank(apikeyInParameter)) {
            return false;
        }
        //合法性判断规则 to do...

        return true;
    }

    //判断RemoteAddr是否存在于Apollo的common配置文件的host.list属性之中
    public boolean isValidAddr(HttpServletRequest request) {
        final String ipAddress = IpUtils.getIpAddress(request);
        if (null == hostList || hostList.length == 0 || !ArrayUtils.contains(hostList, ipAddress)) {
            return false;
        }
        return true;
    }
}
