package com.example.kinocms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class Storage {

    @Value("${upload.path}")
    String uploadPath;

    public String generatePath(String first, String... more) {
        if (more.length == 0) {
            return first;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(first);

        for (String path : more) {
            if (!path.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append('/');
                }
                sb.append(path);
            }
        }
        return sb.toString();
    }

    public String save(String folderPath, MultipartFile file) {
        File folder = new File(uploadPath, folderPath);
        File image = new File(folder, UUID.randomUUID() + "-" + Objects.requireNonNull(file.getOriginalFilename()));

        if(!folder.exists()) {
            folder.mkdirs();
        }

        try {
            file.transferTo(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return generatePath(folderPath, image.getName());
    }

    public List<String> save(String folderPath, MultipartFile[] files) {

    return Arrays.stream(files).map(
                file -> save(folderPath, file)
        ).toList();
    }

    public void delete(String folderPath) {
        File folder = new File(uploadPath, folderPath);

        if (!folder.exists()) {
            return;
        }

        Arrays.stream(Objects.requireNonNull(folder.listFiles())).forEach(File::delete);
        folder.delete();
    }


//
//
//    public static String generateNameFile(MultipartFile file) {
//        return file.getName() + "." + file.getContentType().split("/")[1];
//    }
//
//    public static String[] generateNameFiles(MultipartFile[] files) {
//        AtomicInteger counter = new AtomicInteger(1);
//
//        return Arrays.stream(files).map(file ->
//                file.getName() + "-" + counter  + "." + file.getContentType().split("/")[1]
//        ).toArray(String[]::new);
//    }
//
//    public static void save(String uploadPath, MultipartFile file) {
//        Path path = Path.of(uploadPath);
//        File folder = path.getParent().toFile();
//
//        if(!folder.exists()) {
//            folder.mkdirs();
//        }
//
//        try {
//            file.transferTo(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void save(String[] paths, MultipartFile[] files) {
////        for (int i = 0; (i < paths.length) && (i < files.length); i++) {
////            save(paths[i], files[i]);
////        }
//        Iterator<String> pathsIterator = Arrays.stream(paths).iterator();
//        Iterator<MultipartFile> filesIterator = Arrays.stream(files).iterator();
//
//        while(pathsIterator.hasNext() && filesIterator.hasNext())
//        {
//            save(pathsIterator.next(), filesIterator.next());
//        }
//
//    }

}
