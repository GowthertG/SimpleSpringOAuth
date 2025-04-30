package com._7.SimpleOuth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(@AuthenticationPrincipal OAuth2User principal) {
        if (principal != null) {
            String userName = principal.getAttribute("login");  // GitHub username
            String fullName = principal.getAttribute("name");  // Full name
            String avatarUrl = principal.getAttribute("avatar_url");  // Avatar image URL
            String bio = principal.getAttribute("bio");  //
            String school = principal.getAttribute("company");

            return "Hello <br>" + "Name = " + fullName + "<br> username =  " + userName + "<br>" +
                    "Bio: " + bio + "<br>" +
                    "School: " + school +
                    "<Br>Avatar: " + avatarUrl;
        }
        return "Hello World";
    }
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
