package com.example.kinocms.controllers;

import com.example.kinocms.models.Test;
import com.example.kinocms.repositorys.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class AdminController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/admin")
    public String greeting(Model model) {

        return "admin/admin";
    }

    @GetMapping("/test")
    public String greetin(Model model) {

        Iterable<Test> iterable = testRepository.findAll();
        model.addAttribute("tmp", iterable);

        return "test";
    }

    @PostMapping("/test/add")
    public String add(@RequestParam String name, @RequestParam String describe, @RequestParam String trail, @RequestParam String data, Model model) {
        ///Test test = Test.builder().name(name).describe(describe)..build();



        Test test = new Test(name, describe, LocalDate.parse(data), trail, "type");
        testRepository.save(test);

        return "redirect:/test";
    }
}
