package com.example.kinocms.controllers.admin;

import com.example.kinocms.services.FilmsService;
import com.example.kinocms.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/films")
public class FilmsController {
    private final FilmsService filmsService;

    public FilmsController(FilmsService filmsService) {
        this.filmsService = filmsService;
    }

    @GetMapping()
    public String newsPage(Model model) {
        return "admin/pages/films";
    }

    @ResponseBody
    @GetMapping("/films-getAll")
    public String getNews() {
//        return filmsService.findALL();
        return "";
    }
}
