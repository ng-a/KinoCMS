package com.example.kinocms.controllers;

import com.example.kinocms.models.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class MainController {

    String[] test;

    @GetMapping("/")
    public String greeting(Model model) {

        return "user/main";
    }

    @PostMapping("/registration")
    public String registration(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String nickname,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String gender,
            @RequestParam String birthday,
            @RequestParam String city,
            @RequestParam String address,
            @RequestParam String card,
            Model model) {

        System.out.println(name);
        System.out.println(surname);
        System.out.println(nickname);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(password);
        System.out.println(gender);
        System.out.println(birthday);
        System.out.println(city);
        System.out.println(address);
        System.out.println(card);

        return "redirect:/test";
    }
}
