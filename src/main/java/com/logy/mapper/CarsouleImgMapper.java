package com.logy.mapper;

import com.logy.mode.CarsouleImg;

import java.util.List;

public interface CarsouleImgMapper {
    Integer insertCarsouleImg(CarsouleImg carsouleImg);

    List<CarsouleImg> queryFindAll();

    void delCarousel(List<Integer> imgId);
}
