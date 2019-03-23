package com.logy.controller;


import com.logy.mode.CarsouleImg;
import com.logy.service.inter.CarsouleImgService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("img")
public class ImgController {
    @Autowired
    private CarsouleImgService carsouleImgService;

    @RequestMapping("carousel")
    public List<CarsouleImg> findAllCarousel() {
        return carsouleImgService.queryFindAll();
    }

    @RequestMapping(value = "delcarousel")
    public DataResponse delcarousel(String imgStr) {
        DataResponse<String> dataResponse = new DataResponse<>();
        String[] imgId = imgStr.split(",");
        List<Integer> imgList = new ArrayList<>();
        for (String s : imgId) {
            imgList.add(Integer.valueOf(s));
        }
        try {
            carsouleImgService.delCarousel(imgList);
            dataResponse.setMessage("删除成功");
        } catch (Exception e) {
            dataResponse.setData(e.getMessage());
            dataResponse.setCode(500);
        }
        return dataResponse;
    }
}
