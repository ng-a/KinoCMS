package com.example.kinocms.controllers.admin;

import com.example.kinocms.services.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/news")
public class NewsController {
    final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping()
    public String newsPage(Model model) {
        return "admin/pages/news";
    }

    @ResponseBody
    @GetMapping("/news-getAll")
    public String getNews() {
        return newsService.findALL();
    }

    @ResponseBody
    @GetMapping("/news-getById")
    public String getNewsById(Long id) {
        return newsService.findById(id);
    }


    @ResponseBody
    @PostMapping("/news-add")
    public String addNews(
            @RequestParam("news_info") String news_info,
            @RequestParam("main_image") MultipartFile main_image,
            @RequestParam("gallery_images") MultipartFile[] gallery_images) {


        return newsService.save(
                        news_info,
                        main_image, gallery_images
        );
    }

    @ResponseBody
    @PostMapping("/news-update")
    public String updateNews(
            @RequestParam("news_info") String news_info,
            @RequestParam(name = "main_image", required = false) MultipartFile main_image,
            @RequestParam(name = "gallery_images", required = false) MultipartFile[] gallery_images) {


        return newsService.update(
                news_info,
                main_image, gallery_images
        );
    }

    @ResponseBody
    @PostMapping("/news-deleteById")
    public String deleteNewsById(Long id) {
        return newsService.deleteById(id);
    }
}
