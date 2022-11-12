package com.example.kinocms.services;

import com.example.kinocms.config.Storage;
import com.example.kinocms.enums.Folder;
import com.example.kinocms.models.News;
import com.example.kinocms.repositorys.NewsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.ListIterator;

@Service
public class NewsService {
    private final Storage storage;
    private final ObjectMapper mapper;
    private final NewsRepository newsRepository;


    public NewsService(ObjectMapper mapper, NewsRepository newsRepository, Storage storage) {
        this.mapper = mapper;
        this.newsRepository = newsRepository;
        this.storage = storage;
    }


//    public void save(
//            String name, Date data, Boolean active,
//            String descriptions, String link,
//
//            MultipartFile main_image, MultipartFile[] gallery_images,
//
//            String seo_link, String seo_title,
//            String seo_keywords, String seo_descriptions
//            ) {
//
//
//        String folderPath = Storage.generatePath(Folder.NEWS.toString(), name);
//
//        String mainImagePath = Storage.generatePath(uploadPath, folderPath, Storage.generateNameFile(main_image));
//        Storage.save(mainImagePath, main_image);
//
//
//        String[] galleryImagesPaths = Arrays.stream(Storage.generateNameFiles(gallery_images)).map(
//                nameFile -> Storage.generatePath(uploadPath, folderPath, nameFile))
//                .toArray(String[]::new);
//
//        Storage.save(galleryImagesPaths, gallery_images);
//
//
//        newsRepository.save(
//                News.builder()
//                        .name(name).date(data).active(active)
//                        .descriptions(descriptions).video_link(link)
//
//                        .seo(SEO.builder()
//                                .url(seo_title).title(seo_title)
//                                .keywords(seo_keywords).descriptions(seo_descriptions)
//
//                                .build())
//
//                        .main_image(new MainImage(mainImagePath))
//                        .gallery_images(Arrays.stream(galleryImagesPaths).map(GalleryImage::new).toList())
//
//                        .build());
//    }

    public String save(String news_info, MultipartFile main_image, MultipartFile[] gallery_images) {
        try {
            News news = mapper.readValue(news_info, News.class);
            String path = storage.generatePath(Folder.NEWS.toString(), news.getName());

            news.setMain_image(
                    storage.save(path, main_image)
            );

            news.setGallery_images(
                    storage.save(path, gallery_images)
            );

            newsRepository.save(news);

            return mapper.writeValueAsString(news);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String update(String news_info, MultipartFile main_image, MultipartFile[] gallery_images) {
        try {
            News news = mapper.readValue(news_info, News.class);
            String path = storage.generatePath(Folder.NEWS.toString(), news.getName());

            if(main_image != null) {
                news.setMain_image(
                        storage.save(path, main_image)
                );
            }

            if(gallery_images != null) {
                int index = 0;
                ListIterator<String> images = news.getGallery_images().listIterator();

                while (images.hasNext()) {
                    if (images.next().equals("change")) {
                        images.set(storage.save(path, gallery_images[index]));

                        index++;
                    }
                }

            }


            newsRepository.save(news);

            return mapper.writeValueAsString(news);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public String findALL() {
        try {
            return  mapper.writeValueAsString(newsRepository.findAll());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String findById(Long id) {
        try {
            return  mapper.writeValueAsString(newsRepository.findById(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteById(Long id) {
        try {
            storage.delete(
                    storage.generatePath(Folder.NEWS.toString(),
                    newsRepository.findById(id).get().getName())
            );

            newsRepository.deleteById(id);

            return mapper.writeValueAsString("success");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
