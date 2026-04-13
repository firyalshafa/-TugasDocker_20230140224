package com.example.praktikum5.controller;

import com.example.praktikum5.model.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private List<UserData> dataList = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (username.equals("admin") && password.equals("20230140224")) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Username atau password salah!");
            return "login";
        }
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("dataList", dataList);
        return "dashboard";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("userData", new UserData());
        return "form";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute UserData userData) {
        dataList.add(userData);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}