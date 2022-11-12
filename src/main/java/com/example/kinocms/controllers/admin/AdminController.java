package com.example.kinocms.controllers.admin;

import com.example.kinocms.models.*;
import com.example.kinocms.repositorys.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Value("${upload.path}")
    private String uploadPath;

    private final NewsRepository newsRepository;



    public AdminController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/")
    public String greeting(Model model) {

        return "admin/admin";
    }


    @PostMapping("/test/add")
    public String add(@RequestParam(name = "test12") MultipartFile imageFile, @RequestParam String name, Model model) {
        ///Test test = Test.builder().name(name).describe(describe)..build();


//        System.out.println(name);
//        System.out.println(imageFile.getName());


        return "redirect:/test";
    }

//    @PostMapping("admin/news-add")
//    public String addNews(
//            @RequestParam String name, @RequestParam @DateTimeFormat(pattern="yyyy-mm-dd") Date data, @RequestParam(defaultValue = "false") Boolean active,
//            @RequestParam String descriptions, @RequestParam String link,
//
//            @RequestParam(name = "main-image") MultipartFile main_image, @RequestParam(name = "gallery-image") MultipartFile[] gallery_images,
//
//            @RequestParam(name = "seo-link") String seo_link, @RequestParam(name = "seo-title") String seo_title,
//            @RequestParam(name = "seo-keywords") String seo_keywords, @RequestParam(name = "seo-descriptions") String seo_descriptions,
//
//            Model model) {

//        Path folder = Paths.get(Folder.IMAGE.toString(), Folder.NEWS.toString(), name);
//
//        String path_main_image = Paths.get(folder.toString(), Storage.generateNameFile(main_image)).toString();
//        Storage.save(Paths.get(uploadPath, path_main_image), main_image);
//
//
//        AtomicInteger i = new AtomicInteger();
//        String[] path_gallery_images = Arrays.stream(gallery_images).map(image -> folder.toString() + "/" + Storage.generateNameFile(image) + "-" + i.getAndIncrement()).toArray(String[]::new);
//        Storage.save(Arrays.stream(path_gallery_images).map(image -> Paths.get(uploadPath, image)).toArray(Path[]::new), gallery_images);
//
//
//
//        newsRepository.save(
//                News.builder()
//                        .name(name).date_publication(data).active(active)
//                        .descriptions(descriptions).video_link(link)
//
//                        .seo(SEO.builder()
//                                .url(seo_title).title(seo_title)
//                                .keywords(seo_keywords).descriptions(seo_descriptions)
//
//                                .build())
//
//                        .main_image(new MainImage(path_main_image))
//                        .gallery_images(Arrays.stream(path_gallery_images).map(GalleryImage::new).toList())
//
//                        .build());
//
//
//        return "redirect:/admin/";
//    }

    @GetMapping("/tmp")
    public String test(Model model) {
        return "/tmp";
    }


}
