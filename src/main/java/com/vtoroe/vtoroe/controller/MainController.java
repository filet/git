package com.vtoroe.vtoroe.controller;
import com.vtoroe.vtoroe.domain.*;

import com.vtoroe.vtoroe.repos.*;
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
    private CommentRepo commentRepo;

    @GetMapping("/home")
    public String Neaut(Summ summ, Model model) {
        List<Summ> summs=summRepo.findAll();
        Summ[] summs1=summs.toArray(new Summ[summs.size()]);
        Arrays.sort(summs1);
        model.addAttribute("summs1",summs1);
        return "Neaut";
    }

    @PostMapping("/Summery")
    public String add(@RequestParam String title,
                      @RequestParam String descript,
                      @RequestParam String number,
                      @RequestParam String text,
                      @RequestParam String tags,
                      @AuthenticationPrincipal User user,
                      Map<String, Object> model) {
        List<Tags> tagsList = new ArrayList<>();
        String[] arrayTags = tags.toLowerCase().trim().split(",");
        for (int i = 0; i< arrayTags.length; i++){
            tagsList.add(new Tags(arrayTags[i]));
            Tags tags1 = tagsRepo.findByTags(tagsList.get(i).getTags());
            if (tags1 == null) {
                tagsRepo.save(tagsList.get(i));
            }
        }

        Summ summ = new Summ(title, descript, number, text, tagsList);
        summ.setDateRegistr(new Date());

        summ.setUser(user);
        summRepo.save(summ);

        Iterable<Summ> summs = summRepo.findAll();
        model.put("summeries", summs);
        return "Summery";
    }

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
        model.put("summs", summs1);
        return "UserPage";
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

