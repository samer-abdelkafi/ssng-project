package com.mycompany.myproject.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.persist.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Spring Security success handler, specialized for Ajax requests.
 */
@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private UserRepo userService;

    private static final ObjectMapper mapping = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        User user = userService.findByLogin(authentication.getName());
        PrintWriter writer = response.getWriter();
        writer.write(mapping.writeValueAsString(user));
        response.setStatus(HttpServletResponse.SC_OK);
        writer.flush();
        writer.close();
    }
}
