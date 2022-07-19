/*package pl.fis.lbd.restapi.RestApi.filter;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Order(3)
@WebFilter(urlPatterns = "/teacher")
public class AuthorizationTeacherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String role = servletRequest.getParameter("role");
        if (role.equals("TEACHER_ROLE")){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            PrintWriter out = servletResponse.getWriter();
            servletResponse.setContentType("application/json");
            servletResponse.setCharacterEncoding("UTF-8");
            out.print(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .header("errorMessage", "User unauthorized")
                    .build());
            out.flush();
        }
    }
}
*/