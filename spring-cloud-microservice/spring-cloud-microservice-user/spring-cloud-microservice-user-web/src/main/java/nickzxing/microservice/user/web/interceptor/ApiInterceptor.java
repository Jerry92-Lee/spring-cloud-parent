package nickzxing.microservice.user.web.interceptor;

import nickzxing.dependency.common.util.ApiUtils;
import org.springframework.beans.factory.annotation.Value;
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
        return ApiUtils.ApiValidation(request, response, hostList);
    }
}
