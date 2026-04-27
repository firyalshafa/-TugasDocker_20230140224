package com.example.praktikum5.controller;

import com.example.praktikum5.model.UserData;
import com.example.praktikum5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepository;

    // Folder tempat menyimpan foto
    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";

    @GetMapping("/")
    public String loginPage() { return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (username.equals("admin") && password.equals("20230140224")) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Username atau password salah!");
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("dataList", userRepository.findAll());
        return "dashboard";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("userData", new UserData());
        return "form";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute UserData userData,
                         @RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            // Buat folder jika belum ada
            Path pathDir = Paths.get(UPLOAD_DIR);
            if (!Files.exists(pathDir)) Files.createDirectories(pathDir);

            // Beri nama unik agar file tidak tertukar
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path pathFile = pathDir.resolve(fileName);
            Files.copy(file.getInputStream(), pathFile, StandardCopyOption.REPLACE_EXISTING);

            userData.setFoto(fileName);
        }

        userRepository.save(userData);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() { return "redirect:/"; }
}