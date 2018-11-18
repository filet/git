package com.vtoroe.vtoroe.controller;
import com.vtoroe.vtoroe.domain.Rol;
import com.vtoroe.vtoroe.domain.User;
import com.vtoroe.vtoroe.repos.SummRepo;
import com.vtoroe.vtoroe.domain.Summ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class UserPageController {
    @Autowired
    private SummRepo summRepo;

    @GetMapping("/UserPage")
    public String UserPage(Summ summ, Model model) {
        Iterable<Summ> summs = summRepo.findAll();
        model.addAttribute("summs", summs);
        return "UserPage";
    }

    @GetMapping("/UserPage/{summ}")
    public String userForm(@PathVariable Summ summ, Model model) {
        Iterable<Summ> summs = summRepo.findAll();
        model.addAttribute("summs", summs);
        return "SummeryEdit";
    }

    @PostMapping("/UserPage")
    public String summSave(
            @RequestParam String title,
            @RequestParam String descript,
            @RequestParam String number,
            @RequestParam String tags,
            @RequestParam String text,
            @RequestParam Map<String, String> form,
            @RequestParam("summId") Summ summ
    ) {
        summ.setTitle(title);
        summ.setDescript(descript);
        summ.setNumber(number);
        summ.setTags(tags);
        summ.setText(text);
        summRepo.save(summ);
        return "redirect:/UserPage";
    }
}

