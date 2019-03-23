package com.logy.mode;

import lombok.Getter;
import lombok.Setter;

/**
 *    图片类
 *
 * @author XingZengZhi
 * @date 2019/3/18 22:33
 * @param
 * @return
 */
@Getter
@Setter
public class CarsouleImg {
    private Integer id;
    private Integer type;
    private String imgUrl;
    private String createDate;

    public CarsouleImg(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public CarsouleImg(){}

}
