package com.example.kinocms.services;

import com.example.kinocms.config.Storage;
import com.example.kinocms.enums.Folder;
import com.example.kinocms.models.News;
import com.example.kinocms.models.Shares;
import com.example.kinocms.repositorys.SharesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.ListIterator;

@Service
public class SharesService {
    private final Storage storage;
    private final ObjectMapper mapper;
    private final SharesRepository sharesRepository;

    public SharesService(Storage storage, ObjectMapper mapper, SharesRepository sharesRepository) {
        this.storage = storage;
        this.mapper = mapper;
        this.sharesRepository = sharesRepository;
    }

    public String save(String shares_info, MultipartFile main_image, MultipartFile[] gallery_images) {
        try {
            Shares shares = mapper.readValue(shares_info, Shares.class);
            String path = storage.generatePath(Folder.SHARES.toString(), shares.getName());

            shares.setMain_image(
                    storage.save(path, main_image)
            );

            shares.setGallery_images(
                    storage.save(path, gallery_images)
            );

            sharesRepository.save(shares);

            return mapper.writeValueAsString(shares);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String update(String shares_info, MultipartFile main_image, MultipartFile[] gallery_images) {
        try {
            Shares shares = mapper.readValue(shares_info, Shares.class);
            String path = storage.generatePath(Folder.SHARES.toString(), shares.getName());

            if(main_image != null) {
                shares.setMain_image(
                        storage.save(path, main_image)
                );
            }

            if(gallery_images != null) {
                int index = 0;
                ListIterator<String> images = shares.getGallery_images().listIterator();

                while (images.hasNext()) {
                    if (images.next().equals("change")) {
                        images.set(storage.save(path, gallery_images[index]));

                        index++;
                    }
                }

            }


            sharesRepository.save(shares);

            return mapper.writeValueAsString(shares);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    public String findALL() {
        try {
            return  mapper.writeValueAsString(sharesRepository.findAll());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String findById(Long id) {
        try {
            return  mapper.writeValueAsString(sharesRepository.findById(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteById(Long id) {
        try {
            storage.delete(
                    storage.generatePath(Folder.SHARES.toString(),
                            sharesRepository.findById(id).get().getName())
            );

            sharesRepository.deleteById(id);

            return mapper.writeValueAsString("success");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
