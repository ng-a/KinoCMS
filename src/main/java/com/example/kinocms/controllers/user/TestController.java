package com.example.kinocms.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("/")
    public String homePage() {
        return "test/index";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "test/contact";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "test/about";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin/index";
    }

    @GetMapping("/admin_l")
    public String adminLPage() {
        return "admin/admin_layout";
    }

}
