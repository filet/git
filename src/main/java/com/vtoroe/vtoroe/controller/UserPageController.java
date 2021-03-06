package com.vtoroe.vtoroe.controller;
import com.vtoroe.vtoroe.domain.Comment;
import com.vtoroe.vtoroe.domain.Rating;
import com.vtoroe.vtoroe.domain.User;
import com.vtoroe.vtoroe.repos.CommentRepo;
import com.vtoroe.vtoroe.repos.RatingRepo;
import com.vtoroe.vtoroe.repos.SummRepo;
import com.vtoroe.vtoroe.domain.Summ;
import com.vtoroe.vtoroe.repos.UserRepo;
import com.vtoroe.vtoroe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserPageController {
    @Autowired
    private SummRepo summRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private RatingRepo ratingRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/UserPage")
    public String UserPage(Summ summ, Model model, Comment comment, Rating rating) {
        List<Summ> summs=summRepo.findAll();
        Summ[] summs1=summs.toArray(new Summ[summs.size()]);
        Arrays.sort(summs1);
        model.addAttribute("user", userService.findAll());
        model.addAttribute("summs1",summs1);
        return "UserPage";
    }

    @GetMapping("/Neaut")
    public String Summaries(Model model) {
        return "greeting";
    }

    @GetMapping("/UserPage/{summ}")
    public String userForm(@PathVariable Summ summ, Model model,@AuthenticationPrincipal User user) {
        Iterable<Summ> summs = summRepo.findAll();
        model.addAttribute("rating",getRatingUserInSummary(user, summ));
        model.addAttribute("summs", summs);
        return "Read";
    }

    @GetMapping("/home/{summ}")
    public String userS(@PathVariable Summ summ, Model model) {
        Iterable<Summ> summs = summRepo.findAll();
        model.addAttribute("summs", summs);
        return "Readneaut";}

    @GetMapping("/UserPage/Page/{summ}")
    public String userFormPage(@PathVariable Summ summ, Model model) {
        Iterable<Summ> summs = summRepo.findAll();
        model.addAttribute("summs", summs);
        return "stars";
    }
    @GetMapping("/cabinet")
    public String userMessages(@AuthenticationPrincipal User user,
                               Model model) {
        List<Summ> summs=userRepo.getOne(user.getId()).getSumm();
        model.addAttribute("user", user);
        model.addAttribute("summs",summs);
        return "cabinet";
    }

    @PostMapping("/UserPage")
    public String summSave(
            @RequestParam String commentar,
            @RequestParam Long summId,
            @AuthenticationPrincipal User user
            ) {
        Comment comment = new Comment(commentar);
        comment.setUser(user);
        Summ summ = summRepo.getOne(summId);
        comment.setSumm(summ);
        commentRepo.save(comment);

        return "redirect:/UserPage/"+summ.getId();
    }

    @PostMapping("/UserPage/Page")
     public String editSave(
             @RequestParam String title,
            @RequestParam String descript,
           @RequestParam String number,
           @RequestParam String text,

            @RequestParam Map<String, Object> model,
            @RequestParam ("file") MultipartFile file,
            @RequestParam("summId") Summ summ,
            @AuthenticationPrincipal User user
    ) throws IOException {
        if (file!=null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
           String uuidFile= UUID.randomUUID().toString();
           String resultFilename = uuidFile + "."+ file.getOriginalFilename();
           file.transferTo(new File("D:"+uploadPath+"/"+(resultFilename)));
           summ.setFilename(resultFilename);
        }
        summ.setTitle(title);
        summ.setDescript(descript);
        summ.setNumber(number);
        summ.setText(text);
        summRepo.save(summ);

       return "redirect:/cabinet";
    }
    private double getRatingUserInSummary(User user, Summ summ) {
        double rating = 0;
        List<Rating> ratingsUser = userRepo.getOne(user.getId()).getRatings();
        for(int i = 0; i < ratingsUser.size(); i++) {
            if (ratingsUser.get(i).getSumm() == summ) {
                rating = ratingsUser.get(i).getRating();
                return rating;
            }
        }
        return rating;
    }

    }

