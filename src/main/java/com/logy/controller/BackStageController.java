package com.logy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *    控制后台页面跳转
 *
 * @author xky
 * @date 2019/3/5 0:03
 * @param pageIndex=xx_xx_xx
 *        xx_xx_xx为页面路径最后的xx应当为页面文件的名称，前面则是页面的路径地址
 * @return
 */
@Controller
public class BackStageController {
    /**
     * 获取跳转界面的路径
     * @param pageIndex
     * @return
     */
    @RequestMapping("bs_index")
    public String JumpPage(String pageIndex){
        //声明页面路径字符串
        String pageStr = "";
        //分解字符串并赋值到字符串数组中
        String[] pageStrArr = pageIndex.split("_");
        //获取字符串数组的长度
        int pageLength = pageStrArr.length;
        //循环遍历字符串数组，并拼接路径
        for (int i = 0; i < pageLength; i++) {
            pageStr += pageStrArr[i];
            if(i != pageLength - 1) {
                pageStr += "/";
            }
        }
        //返回路径
        return pageStr;
    }
}
