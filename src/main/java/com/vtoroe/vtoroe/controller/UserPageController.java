package com.vtoroe.vtoroe.controller;
import com.vtoroe.vtoroe.domain.Comment;
import com.vtoroe.vtoroe.repos.CommentRepo;
import com.vtoroe.vtoroe.repos.SummRepo;
import com.vtoroe.vtoroe.domain.Summ;
import com.vtoroe.vtoroe.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserPageController {
    @Autowired
    private SummRepo summRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CommentRepo commentRepo;

    @GetMapping("/UserPage")
    public String UserPage(Summ summ, Model model, Comment comment) {
        Iterable<Summ> summs = summRepo.findAll();
        Iterable<Comment> comments=commentRepo.findAll();
        model.addAttribute("comments",comments);
        model.addAttribute("summs", summs);
        return "UserPage";
    }

    @GetMapping("/UserPage/{summ}")
    public String userForm(@PathVariable Summ summ, Model model) {
        Iterable<Summ> summs = summRepo.findAll();
        model.addAttribute("summs", summs);
        return "Read";
    }
    @GetMapping("/UserPage/Page/{summ}")
    public String userFormPage(@PathVariable Summ summ, Model model) {
        Iterable<Summ> summs = summRepo.findAll();
        model.addAttribute("summs", summs);
        return "SummeryEdit";
    }

    @PostMapping("/UserPage/Page")
    public String summSave(
            @RequestParam String title,
            @RequestParam String descript,
            @RequestParam String number,
            @RequestParam String text,
            @RequestParam Map<String, String> form,
            @RequestParam("summId") Summ summ
    ) {

        summ.setTitle(title);
        summ.setDescript(descript);
        summ.setNumber(number);
        summ.setText(text);
        summRepo.save(summ);

        return "redirect:/UserPage";
    }
}
