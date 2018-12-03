package com.vtoroe.vtoroe.controller;
import com.vtoroe.vtoroe.domain.*;

import com.vtoroe.vtoroe.repos.*;
import com.vtoroe.vtoroe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.lang.Long;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SummRepo summRepo;
    @Autowired
    private TagsRepo tagsRepo;

    @Autowired
    private RatingRepo ratingRepo;
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String Neaut(Summ summ, Model model) {
        List<Summ> summs=summRepo.findAll();
        Summ[] summs1=summs.toArray(new Summ[summs.size()]);
        Arrays.sort(summs1);
        model.addAttribute("summs1",summs1);
        return "Neaut";
    }

    @GetMapping("/")
    public String Neat(Summ summ, Model model) {
        List<Summ> summs=summRepo.findAll();
        Summ[] summs1=summs.toArray(new Summ[summs.size()]);
        Arrays.sort(summs1);
        model.addAttribute("summs1",summs1);
        return "Neaut";
    }
    @GetMapping("/user/profile")
    public String getProfile(Model model,@AuthenticationPrincipal User user){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "profile";
    }
    @PostMapping("/user/profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email
    ){
        userService.updateProfile(user,password,email);
        return "redirect:/cabinet";
    }

    @PostMapping("/Summery")
    public String add(@RequestParam String title,
                      @RequestParam String descript,
                      @RequestParam String number,
                      @RequestParam String text,
                      @RequestParam String tags,
                      @AuthenticationPrincipal User user,
                      Map<String, Object> model) {
        Summ summ = new Summ(title, descript, number, text);
        summ.setUser(user);
        summ.setDateRegistr(new Date());
        String[] arrayTags = tags.toLowerCase().trim().split(" ");
        List<Tags> tags1 = new ArrayList<>();
        for (int i = 0; i< arrayTags.length;i++ ){
           Tags tagNew = tagsRepo.findByTags(arrayTags[i]);
             if (tagNew == null){
             tagNew = tagsRepo.save(new Tags(arrayTags[i]));
            }
          tags1.add(tagNew);
            }
        summ.setTags(tags1);
        summRepo.save(summ);
        return "Summery";}

    @GetMapping("/Summery")
    public String summery() {
        return "Summery";
    }

    @PostMapping("/home")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
         Iterable<Summ> summs1;
           if (filter != null && !filter.isEmpty()) {
            summs1 = summRepo.findByTitle(filter);
        } else{
             summs1=summRepo.findAll();
        }
            model.put("summs1", summs1);
            return "Neaut";
        }

    @PostMapping("/UserPage/Filt")
    public String filterr(@RequestParam String filterr, Map<String, Object> model) {
        Iterable<Summ> summs1;
        if (filterr != null && !filterr.isEmpty()) {
            summs1 = summRepo.findByTitle(filterr);
        } else{
            summs1=summRepo.findAll();
        }
        model.put("summs1", summs1);
        return "UserPage";
    }

    @PostMapping("/Filter")
    public String ffilterr(@RequestParam String ffilterr, Map<String, Object> model) {
        Iterable<Summ> summs;
        if (ffilterr != null && !ffilterr.isEmpty()) {
            summs = summRepo.findByTitle(ffilterr);
        } else{
            summs=summRepo.findAll();
        }
        model.put("summs", summs);
        return "cabinet";
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
                settings="1";
            }
            userRepo.delete(user);
        }
        return settings;
        }
    @PostMapping("/save")
    @ResponseBody
    public String saveRating( Double rating,
                               Long idSummaries,
                               @AuthenticationPrincipal User authoresingUser) {
        String settings = "1";
        Rating newRating = new Rating(rating, authoresingUser, summRepo.getOne(idSummaries));
        ratingRepo.save(newRating);
        return settings;
    }


    @PostMapping("/deletesummeries")
    @ResponseBody
    public String updateDeleteSummmeries(@RequestBody List<Long> id,
                                         @AuthenticationPrincipal User authoresingSummeries) {
        String settings = "1";
        for (int i = 0; i< id.size(); i++){
            Summ summ = summRepo.getOne(id.get(i));
            if (authoresingSummeries.getId() == summ.getId()) {
                SecurityContextHolder.clearContext();
                settings="2";
            }
            summRepo.delete(summ);
        }
        return settings;
    }
}

