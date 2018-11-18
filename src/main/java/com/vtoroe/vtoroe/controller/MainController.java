package com.vtoroe.vtoroe.controller;
import com.vtoroe.vtoroe.domain.Message;

import com.vtoroe.vtoroe.domain.Summ;
import com.vtoroe.vtoroe.domain.User;
import com.vtoroe.vtoroe.repos.MessageRepo;
import com.vtoroe.vtoroe.repos.SummRepo;
import com.vtoroe.vtoroe.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.Long;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SummRepo summRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @PostMapping("/Summery")
    public String add(@RequestParam String title,
                      @RequestParam String descript,
                      @RequestParam String number,
                      @RequestParam String tags,
                      @RequestParam String text,
                      Map<String,Object> model){
        Summ summ=new Summ(title,descript,number,tags,text);
        summRepo.save(summ);
        Iterable<Summ> summs = summRepo.findAll();
        model.put("summeries",summs);
        return "Summery";
    }

    @GetMapping ("/Summery")
    public String summery(){
        return "Summery";
    }
    @GetMapping ("/User")
    public String user(){
        return "User";
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
                //SecurityContextHolder.clearContext();
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
               // SecurityContextHolder.clearContext();
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
                //SecurityContextHolder.clearContext();
                settings="1";
            }
            userRepo.delete(user);
        }
        return settings;
        }
//    @PostMapping("/deletesummeries")
//    @ResponseBody
//    public String updateDeleteSummmeries(@RequestBody List<Long> id,
//                                         @AuthenticationPrincipal User authoresingSummeries) {
//        String settings = "1";
//        for (int i = 0; i< id.size(); i++){
//            Summ summ = summRepo.findAll(id(i));
//            if (authoresingSummeries.getId() == summ.getIdSumm()) {
//                //SecurityContextHolder.clearContext();
//                settings="2";
//            }
//            summRepo.delete(summ);
//        }
//        return settings;
//    }
}

