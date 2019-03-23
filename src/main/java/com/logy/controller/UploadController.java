package com.logy.controller;

import com.logy.service.impl.CarsouleImgServiceImpl;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private CarsouleImgServiceImpl carsouleImgService;

    @RequestMapping("carsoule_upload")
    @ResponseBody
    public DataResponse carsouleUpload(MultipartFile carsouleImageFile, Integer type) throws IOException {
        return carsouleImgService.insertCarsouleImg(carsouleImageFile, type);
    }
}
