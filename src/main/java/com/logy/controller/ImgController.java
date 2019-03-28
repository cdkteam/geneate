package com.logy.controller;


import com.logy.mode.CarsouleImg;
import com.logy.service.inter.CarsouleImgService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片上传控制类
 */
@RestController
@RequestMapping("img")
public class ImgController {
    /**
     * 图片上擦混服务类对象
     */
    @Autowired
    private CarsouleImgService carsouleImgService;

    /**
     * 查询所有的图片
     * @return
     */
    @RequestMapping("carousel")
    public List<CarsouleImg> findAllCarousel() {
        return carsouleImgService.queryFindAll();
    }

    /**
     * 删除图片
     * @param imgStr
     * @return
     */
    @RequestMapping(value = "delcarousel")
    public DataResponse delcarousel(String imgStr) {
        //声明字符串数据响应类对象
        DataResponse<String> dataResponse = new DataResponse<>();
        //字符串分割并保存到字符串数组中
        String[] imgId = imgStr.split(",");
        //声明整型列表
        List<Integer> imgList = new ArrayList<>();
        //遍历数组
        for (String s : imgId) {
            //Integer.valueOf(s)将字符串类型转换为整型
            //向整型列表中添加数组数据
            imgList.add(Integer.valueOf(s));
        }
        //try  捕获异常
        try {
            //使用图片服务类删除图片数据
            carsouleImgService.delCarousel(imgList);
            //设置数据响应类消息数据
            dataResponse.setMessage("删除成功");
        } catch (Exception e) {
            //抛出异常
            ////设置数据响应类消息数据
            dataResponse.setData(e.getMessage());
            //设置响应码
            dataResponse.setCode(500);
        }
        //返回响应对象
        return dataResponse;
    }
}
