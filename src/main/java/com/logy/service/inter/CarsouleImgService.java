package com.logy.service.inter;

import com.logy.mode.CarsouleImg;
import com.logy.utils.DataResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CarsouleImgService {
    DataResponse insertCarsouleImg(MultipartFile file, Integer type);

    List<CarsouleImg> queryFindAll();

    void delCarousel(List<Integer> imgId);
}
