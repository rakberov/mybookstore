package mybookstore.mybookstore.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybookstore.mybookstore.model.Session;
import mybookstore.mybookstore.model.User;
import mybookstore.mybookstore.model.enums.Role;
import mybookstore.mybookstore.service.SessionService;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class RequestFilter implements Filter {

    private final SessionService sessionService;

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Session session = sessionService.findActiveSession();

        if (session == null)
            response.addHeader("Role", Role.User.name());
        else {
            User user = session.getUser();
            response.addHeader("Role", user.getRole().name());
        }
        filterChain.doFilter(request, response);
    }
}
