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

@Service
public class CarsouleImgServiceImpl implements CarsouleImgService {
    @Autowired
    private CarsouleImgMapper carsouleImgMapper;

    @Transactional
    @Override
    public DataResponse insertCarsouleImg(MultipartFile file, Integer type) {
        DataResponse<String> dataResponse = new DataResponse();
        CarsouleImg carsouleImg = new CarsouleImg();
        String imgPath = UploadUtil.uploadImage(file);
        carsouleImg.setImgUrl(imgPath);
        carsouleImg.setType(type);
        carsouleImgMapper.insertCarsouleImg(carsouleImg);
        dataResponse.setId(carsouleImg.getId());
        dataResponse.setData(imgPath);
        return dataResponse;
    }

    @Override
    public List<CarsouleImg> queryFindAll() {
        return carsouleImgMapper.queryFindAll();
    }

    @Transactional
    @Override
    public void delCarousel(List<Integer> imgId) {
        carsouleImgMapper.delCarousel(imgId);
    }

}
