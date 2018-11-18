package com.vtoroe.vtoroe.controller;

import com.vtoroe.vtoroe.domain.Rol;
import com.vtoroe.vtoroe.domain.Summ;
import com.vtoroe.vtoroe.domain.User;
import com.vtoroe.vtoroe.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String userList(
            @AuthenticationPrincipal User user,
            Model model) {
        user.setDateLastSeen(new Date());
        userRepo.save(user);
        model.addAttribute("users", userRepo.findAll());

        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {

        model.addAttribute("user", user);
        model.addAttribute("roles", Rol.values());

        return "userEdit";
    }
    @GetMapping("/User/{user}")
    public String userForm(@PathVariable User user, Model model) {

        model.addAttribute("user", user);
        return "User";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Rol.values())
                .map(Rol::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Rol.valueOf(key));
            }
        }
        userRepo.save(user);
        return "redirect:/user";
    }
}

