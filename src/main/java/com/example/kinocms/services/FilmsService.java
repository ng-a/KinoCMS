package com.example.kinocms.services;

import com.example.kinocms.config.Storage;
import com.example.kinocms.enums.Folder;
import com.example.kinocms.models.Films;
import com.example.kinocms.models.News;
import com.example.kinocms.repositorys.FilmsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ListIterator;

@Service
public class FilmsService {
    private final Storage storage;
    private final ObjectMapper mapper;
    private final FilmsRepository filmsRepository;

    public FilmsService(Storage storage, ObjectMapper mapper, FilmsRepository filmsRepository) {
        this.storage = storage;
        this.mapper = mapper;
        this.filmsRepository = filmsRepository;
    }

    public String save(String film_info, MultipartFile main_image, MultipartFile[] gallery_images) {
        try {
            Films film = mapper.readValue(film_info, Films.class);
            String path = storage.generatePath(Folder.FILMS.toString(), film.getName());

            film.setMain_image(
                    storage.save(path, main_image)
            );

            film.setGallery_images(
                    storage.save(path, gallery_images)
            );

            filmsRepository.save(film);

            return mapper.writeValueAsString(film);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String update(String film_info, MultipartFile main_image, MultipartFile[] gallery_images) {
        try {
            Films film = mapper.readValue(film_info, Films.class);
            String path = storage.generatePath(Folder.FILMS.toString(), film.getName());

            if(main_image != null) {
                film.setMain_image(
                        storage.save(path, main_image)
                );
            }

            if(gallery_images != null) {
                int index = 0;
                ListIterator<String> images = film.getGallery_images().listIterator();

                while (images.hasNext()) {
                    if (images.next().equals("change")) {
                        images.set(storage.save(path, gallery_images[index]));

                        index++;
                    }
                }

            }


            filmsRepository.save(film);

            return mapper.writeValueAsString(film);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public String findALL() {
        try {
            return  mapper.writeValueAsString(filmsRepository.findAll());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String findById(Long id) {
        try {
            return  mapper.writeValueAsString(filmsRepository.findById(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteById(Long id) {
        try {
            storage.delete(
                    storage.generatePath(Folder.NEWS.toString(),
                            filmsRepository.findById(id).get().getName())
            );

            filmsRepository.deleteById(id);

            return mapper.writeValueAsString("success");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
