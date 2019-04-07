package com.logy.mode;



/**
 *    图片类
 *
 * @author xky
 * @date 2019/3/18 22:33
 * @param
 * @return
 */

public class CarsouleImg {
    private Integer id;
    private Integer type;
    private String imgUrl;
    private String createDate;

    public CarsouleImg(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public CarsouleImg(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
