package com.example.kinocms.controllers.admin;

import com.example.kinocms.services.SharesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/shares")
public class SharesController {
    final SharesService sharesService;

    public SharesController(SharesService sharesService) {
        this.sharesService = sharesService;
    }

    @GetMapping()
    public String sharesPage(Model model) {
        return "admin/pages/shares";
    }

    @ResponseBody
    @GetMapping("/shares-getAll")
    public String getshares() {
        return sharesService.findALL();
    }

    @ResponseBody
    @GetMapping("/shares-getById")
    public String getsharesById(Long id) {
        return sharesService.findById(id);
    }


    @ResponseBody
    @PostMapping("/shares-add")
    public String addshares(
            @RequestParam("shares_info") String shares_info,
            @RequestParam("main_image") MultipartFile main_image,
            @RequestParam("gallery_images") MultipartFile[] gallery_images) {


        return sharesService.save(
                shares_info,
                main_image, gallery_images
        );
    }

    @ResponseBody
    @PostMapping("/shares-update")
    public String updateshares(
            @RequestParam("shares_info") String shares_info,
            @RequestParam(name = "main_image", required = false) MultipartFile main_image,
            @RequestParam(name = "gallery_images", required = false) MultipartFile[] gallery_images) {


        return sharesService.update(
                shares_info,
                main_image, gallery_images
        );
    }

    @ResponseBody
    @PostMapping("/shares-deleteById")
    public String deletesharesById(Long id) {
        return sharesService.deleteById(id);
    }
}
