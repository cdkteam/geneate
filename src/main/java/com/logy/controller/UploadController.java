package com.logy.controller;

import com.logy.service.impl.CarsouleImgServiceImpl;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传文件管理类
 */
@Controller
@RequestMapping("upload")
public class UploadController {
    /**
     * 声明上传文件服务类对象
     */
    @Autowired
    private CarsouleImgServiceImpl carsouleImgService;

    /**
     * 向数据库中插入文件上传的数据
     * @param carsouleImageFile
     * @param type
     * @return
     * @throws IOException
     */
    @RequestMapping("carsoule_upload")
    @ResponseBody
    public DataResponse carsouleUpload(MultipartFile carsouleImageFile, Integer type) throws IOException {
        return carsouleImgService.insertCarsouleImg(carsouleImageFile, type);
    }
}
