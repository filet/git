package com.vtoroe.vtoroe.controller;
import com.vtoroe.vtoroe.domain.Message;

import com.vtoroe.vtoroe.domain.User;
import com.vtoroe.vtoroe.repos.MessageRepo;
import com.vtoroe.vtoroe.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.chrono.IsoChronology;
import java.util.List;
import java.util.Map;


@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model
    ) {
        Message message = new Message(text, tag, user);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateActive(@RequestBody List<Long> idUsers,
                               @AuthenticationPrincipal User authoresingUser) {
        String settings ="1";
        for (int i = 0; i< idUsers.size(); i++){
            User user = userRepo.getOne(idUsers.get(i));
            if (authoresingUser.getId() == user.getId()) {
                SecurityContextHolder.clearContext();
                settings="1";
            }
            if(user.isActive()==true){
                user.setActive(false);
            }
            userRepo.save(user);
        }
        return settings;
    }
    @PostMapping("/updatee")
    @ResponseBody
    public String updatePassive(@RequestBody List<Long> idUsers,
                               @AuthenticationPrincipal User authoresingUser) {
        String settings = "1";
        for (int i = 0; i< idUsers.size(); i++){
            User user = userRepo.getOne(idUsers.get(i));
            if (authoresingUser.getId() == user.getId()) {
                SecurityContextHolder.clearContext();
                settings="1";
            }
            if(user.isActive()==false){
                user.setActive(true);
            }
            userRepo.save(user);
        }
        return settings;
    }
    @PostMapping("/delete")
    @ResponseBody
    public String updateDelete(@RequestBody List<Long> idUsers,
                               @AuthenticationPrincipal User authoresingUser) {
        String settings = "1";
        for (int i = 0; i< idUsers.size(); i++){
            User user = userRepo.getOne(idUsers.get(i));
            if (authoresingUser.getId() == user.getId()) {
                SecurityContextHolder.clearContext();
                settings="2";
            }
            userRepo.delete(user);
        }
        return settings;
        }

}

