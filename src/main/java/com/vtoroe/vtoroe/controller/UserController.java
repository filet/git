package com.vtoroe.vtoroe.controller;

import com.vtoroe.vtoroe.domain.Rol;
import com.vtoroe.vtoroe.domain.Summ;
import com.vtoroe.vtoroe.domain.User;
import com.vtoroe.vtoroe.repos.SummRepo;
import com.vtoroe.vtoroe.repos.UserRepo;
import com.vtoroe.vtoroe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SummRepo summRepo;

    @GetMapping
    public String userList(
            Model model) {

        model.addAttribute("users", userService.findAll());

        return "userList";
    }



    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, ModelMap model) {
         model.addAttribute("user", user);
        model.addAttribute("roles", Rol.values());
        return "userEdit";
    }
    @PostMapping
    public String userSave(
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        userService.saveUser(user,form);
        return "redirect:/user";
    }
    @GetMapping("/User/{user}")
    public String userForm(@PathVariable User user, Summ summ, Model model) {
        Iterable<Summ> summs=summRepo.findAll();
        model.addAttribute("summs", summs);
        model.addAttribute("user", user);
        return "User";
    }

    @GetMapping("profile")
    public String getProfile(Model model,@AuthenticationPrincipal User user){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "profile";
    }
    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email
    ){
        userService.updateProfile(user,password,email);
        return "redirect:/user/profile";
    }
}