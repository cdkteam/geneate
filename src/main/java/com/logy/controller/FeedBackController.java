package com.logy.controller;

import com.logy.form.FeedBackForm;
import com.logy.form.MemberForm;
import com.logy.mode.FeedBack;
import com.logy.mode.Member;
import com.logy.service.inter.FeedBackService;
import com.logy.service.inter.MemberService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 反馈控制类
 */
@RestController
@RequestMapping("feedback")
public class FeedBackController {
    /**
     * 声明反馈控制服务类对象
     */
    @Autowired
    private FeedBackService feedBackService;

    /**
     * 查询所有反馈数据
     * @param feedBackForm
     * @return
     */
    @RequestMapping("fb_list")
    public DataResponse queryAllFeedback(FeedBackForm feedBackForm) {
        return feedBackService.queryAllFeedback(feedBackForm);
    }

    /**
     * 按照参数查询反馈类数据
     * @param feedBackForm
     * @return
     */
    @RequestMapping("fb_my_list")
    public DataResponse queryFeedback(FeedBackForm feedBackForm) {
        return feedBackService.queryFeedback(feedBackForm);
    }

    /**
     * 向数据库中插入反馈数据
     * @param feedBack
     * @return
     */
    @RequestMapping("fb_i")
    public DataResponse insertFeedback(FeedBack feedBack) {
        return feedBackService.insertFeedback(feedBack);
    }

    /**
     * 从数据库中删除反馈数据
     * @param fbs
     * @return
     */
    @RequestMapping("fb_d_list")
    public DataResponse delFeedbackBatch(String fbs) {
        return feedBackService.delFeedbackBatch(fbs);
    }

}
