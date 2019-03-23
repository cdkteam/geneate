package com.logy.utils;

import com.logy.mode.CarsouleImg;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class UploadUtil {

    public static String uploadImage(MultipartFile multipartFile) {
        DataResponse<CarsouleImg> dataResponse = new DataResponse<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDateTime = LocalDateTime.now();
        String localTimeFormatter = localDateTime.format(dateFormatter);
        String fileFullName = multipartFile.getOriginalFilename();
        String fileName = fileFullName.substring(0, fileFullName.indexOf("."));
        String suffixName = fileFullName.substring(fileFullName.indexOf("."), fileFullName.length());
        String newFileFullName = UUID.randomUUID().toString() + localTimeFormatter + suffixName;

        File file = new File("F:/upload/" + localTimeFormatter + "/" + newFileFullName);
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            String imagePath = "http://localhost" + file.getCanonicalPath().substring(2, file.getCanonicalPath().length())
                    .replace("\\", "/");
            multipartFile.transferTo(file);
            return imagePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
