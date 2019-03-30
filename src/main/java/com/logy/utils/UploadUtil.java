package com.logy.utils;

import com.logy.mode.CarsouleImg;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 图片上传方法
 */
public class UploadUtil {

    public static String uploadImage(MultipartFile multipartFile) {
        //声明日期格式对象
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //获取本地时间
        LocalDateTime localDateTime = LocalDateTime.now();
        //将本地时间按照日期格式转换
        String localTimeFormatter = localDateTime.format(dateFormatter);
        //获取上传文件的文件名，包含后缀名
        String fileFullName = multipartFile.getOriginalFilename();
        //拿取上传的文件的后缀名
        String suffixName = fileFullName.substring(fileFullName.indexOf("."), fileFullName.length());
        //给图片随机取名
        String newFileFullName = UUID.randomUUID().toString() + localTimeFormatter + suffixName;
        //声明图片存储文件件
        File file = new File("F:/upload/" + localTimeFormatter + "/" + newFileFullName);
        //如果其文件夹不存在，则创建文件夹
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        //捕获输入输出异常
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
