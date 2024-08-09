package fa.training.assignment03cms.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PostLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object member = request.getSession().getAttribute("member");

        if (member == null) {
            return true;
        }

        response.sendRedirect("/view-content");
        return false;
    }
}
