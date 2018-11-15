package com.vtoroe.vtoroe.controller;
import com.vtoroe.vtoroe.domain.Rol;
import com.vtoroe.vtoroe.domain.User;
import com.vtoroe.vtoroe.repos.SummRepo;
import com.vtoroe.vtoroe.domain.Summ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class UserPageController {
    @Autowired
    private SummRepo summRepo;
    @GetMapping("/UserPage")
    public String UserPage(Summ summ, Model model){
        Iterable<Summ> summs=summRepo.findAll();
        model.addAttribute("summs", summs);
        return "UserPage";
    }

    @GetMapping("/UserPage/{summ}")
    public String userForm(@PathVariable Summ summ, Model model) {
        Iterable<Summ> summs=summRepo.findAll();
        model.addAttribute("summs", summs);
        return "SummeryEdit";
    }
}

