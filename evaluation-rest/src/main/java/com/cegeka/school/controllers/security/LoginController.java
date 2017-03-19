package com.cegeka.school.controllers.security;

import com.cegeka.school.controllers.security.model.security.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collections;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Inject
    private AuthenticationManager authenticationManager;

    @Inject
    private UserService userService;

    @Inject
    private TokenHandler tokenHandler;

    @RequestMapping(method = RequestMethod.POST, path = "/login", produces = "application/json; charset=UTF-8")
    public Map<String, String> createAuthenticationToken(@RequestBody LoginDTO loginProperties) {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginProperties.getUsername(),
                        loginProperties.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authenticate);
        User user = userService.loadUserByUsername(loginProperties.getUsername());
        String token = tokenHandler.createTokenForUser(user);

        return Collections.singletonMap("response", token);
    }

}
