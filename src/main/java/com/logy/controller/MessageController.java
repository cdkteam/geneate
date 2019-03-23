package com.logy.controller;

import com.logy.utils.DataResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *    消息反馈类
 *
 * @author XingZengZhi
 * @date 2019/3/16 0:04
 * @param
 * @return
 */
@RestController
@RequestMapping("message")
public class MessageController {
    @RequestMapping("app_index_message")
    public DataResponse appIndexMessage(HttpServletRequest request) {
        DataResponse<String> dataResponse = new DataResponse();
        HttpSession session = request.getSession();
        if(session.getAttribute("family_read") != null) {
            if(session.getAttribute("family_message") != null) {
                // 拉取家族消息
                dataResponse.setMessage((String) session.getAttribute("family_message"));
            }
        } else {
            dataResponse.setCode(404);
        }
        return dataResponse;
    }

    /**
     * 将消息属性移除，设为已读状态
     * @param request
     * @return
     */
    @RequestMapping("app_index_read")
    public DataResponse appIndexReadMessage(HttpServletRequest request) {
        DataResponse<String> dataResponse = new DataResponse();
        request.getSession().removeAttribute("family_read");
        return dataResponse;
    }
}
