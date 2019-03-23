package com.logy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *    控制后台页面跳转
 *
 * @author XingZengZhi
 * @date 2019/3/5 0:03
 * @param pageIndex=xx_xx_xx
 *        xx_xx_xx为页面路径最后的xx应当为页面文件的名称，前面则是页面的路径地址
 * @return
 */

@Controller
public class BackStageController {
    @RequestMapping("bs_index")
    public String JumpPage(String pageIndex){
        String pageStr = "";
        String[] pageStrArr = pageIndex.split("_");
        int pageLength = pageStrArr.length;
        for (int i = 0; i < pageLength; i++) {
            pageStr += pageStrArr[i];
            if(i != pageLength - 1) {
                pageStr += "/";
            }
        }
        return pageStr;
    }
}
