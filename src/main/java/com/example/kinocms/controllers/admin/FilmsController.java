package com.example.kinocms.controllers.admin;

import com.example.kinocms.services.FilmsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/films")
public class FilmsController {
    private final FilmsService filmsService;

    public FilmsController(FilmsService filmsService) {
        this.filmsService = filmsService;
    }

    @GetMapping()
    public String filmsPage(Model model) {
        return "admin/pages/films";
    }

    @ResponseBody
    @GetMapping("/films-getAll")
    public String getFilms() {
        return filmsService.findALL();
    }

    @ResponseBody
    @GetMapping("/films-getById")
    public String getFilmById(Long id) {
        return filmsService.findById(id);
    }


    @ResponseBody
    @PostMapping("/films-add")
    public String addFilm(
            @RequestParam("film_info") String film_info,
            @RequestParam("main_image") MultipartFile main_image,
            @RequestParam("gallery_images") MultipartFile[] gallery_images) {


        return filmsService.save(
                film_info,
                main_image, gallery_images
        );
    }

    @ResponseBody
    @PostMapping("/films-update")
    public String updateFilm(
            @RequestParam("film_info") String film_info,
            @RequestParam(name = "main_image", required = false) MultipartFile main_image,
            @RequestParam(name = "gallery_images", required = false) MultipartFile[] gallery_images) {


        return filmsService.update(
                film_info,
                main_image, gallery_images
        );
    }

    @ResponseBody
    @PostMapping("/films-deleteById")
    public String deleteFilmById(Long id) {
        return filmsService.deleteById(id);
    }
}
