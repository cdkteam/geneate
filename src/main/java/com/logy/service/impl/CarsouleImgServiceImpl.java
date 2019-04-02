package com.logy.service.impl;

import com.logy.mapper.CarsouleImgMapper;
import com.logy.mode.CarsouleImg;
import com.logy.service.inter.CarsouleImgService;
import com.logy.utils.DataResponse;
import com.logy.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 上传照片服务实现类
 */
@Service
public class CarsouleImgServiceImpl implements CarsouleImgService {
    @Autowired
    private CarsouleImgMapper carsouleImgMapper;

    /**
     * 向数据库中插入轮播图片数据
     * @param file
     * @param type
     * @return
     */
    @Transactional
    @Override
    public DataResponse insertCarsouleImg(MultipartFile file, Integer type) {
        DataResponse<String> dataResponse = new DataResponse();//声明返回数据对象  数据是字符串
        CarsouleImg carsouleImg = new CarsouleImg();//声明图片对象
        String imgPath = UploadUtil.uploadImage(file);//获取图片上传存储路径
        carsouleImg.setImgUrl(imgPath);//向图片对象中添加路径
        carsouleImg.setType(type);//向图片对象添加类型
        carsouleImgMapper.insertCarsouleImg(carsouleImg);//向数据库中插入图片对象数据
        dataResponse.setId(carsouleImg.getId());//获取图片对象的id并设置给返回数据对象
        dataResponse.setData(imgPath);//给返回数据设置图片路径
        return dataResponse;//返回数据
    }

    /**
     * 查询所有轮播图片
     * @return
     */
    @Override
    public List<CarsouleImg> queryFindAll() {
        return carsouleImgMapper.queryFindAll();
    }

    /**
     * 删除图片
     * @param imgId
     */
    @Transactional
    @Override
    public void delCarousel(List<Integer> imgId) {
        carsouleImgMapper.delCarousel(imgId);
    }

}
