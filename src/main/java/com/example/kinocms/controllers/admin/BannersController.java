package com.example.kinocms.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/banners")
public class BannersController {

    @GetMapping()
    public String filmsPage(Model model) {
        return "admin/pages/banners";
    }
}
