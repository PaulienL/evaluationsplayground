package com.cegeka.school.controllers.security;

import com.cegeka.school.controllers.security.model.security.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockUsers {

    public static List<User> getMockUsers(){
        List<User> users = new ArrayList<>();
        users.add(getSeppe());
        users.add(getJohan());
        return users;
    }

    private static User getSeppe() {
        User seppe = new User();
        seppe.setUsername("seppe");
        seppe.setPassword("password");
        seppe.setEnabled(true);
        seppe.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
        return seppe;
    }

    private static User getJohan() {
        User johan = new User();
        johan.setUsername("johan");
        johan.setPassword("password");
        johan.setEnabled(true);
        johan.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
        return johan;
    }
}
