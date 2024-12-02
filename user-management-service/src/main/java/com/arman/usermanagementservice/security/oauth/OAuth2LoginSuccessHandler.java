package com.arman.usermanagementservice.security.oauth;

import com.arman.usermanagementservice.entity.Role;
import com.arman.usermanagementservice.entity.User;
import com.arman.usermanagementservice.repository.RoleRepository;
import com.arman.usermanagementservice.repository.UserRepository;
import com.arman.usermanagementservice.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtUtils jwtUtils;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        User user = userRepository.findByEmail(email).orElse(null);
        //Если пользователь аутентифицируется впервые
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setEnable(true);
            user.setRoles(Set.of(roleRepository.findByName("ROLE_USER").get()));
            userRepository.save(user);
        }
        //Генерация JWT токена
        String jwt = jwtUtils.generateToken(authentication);
        //Добавление токена в ответ
        response.addHeader("Authorization", "Bearer " + jwt);
        //Редирект или вывод ответа
        response.sendRedirect("/home");
    }
}