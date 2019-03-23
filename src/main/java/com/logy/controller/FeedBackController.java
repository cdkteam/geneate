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

@RestController
@RequestMapping("feedback")
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @RequestMapping("fb_list")
    public DataResponse queryAllFeedback(FeedBackForm feedBackForm) {
        return feedBackService.queryAllFeedback(feedBackForm);
    }

    @RequestMapping("fb_my_list")
    public DataResponse queryFeedback(FeedBackForm feedBackForm) {
        return feedBackService.queryFeedback(feedBackForm);
    }

    @RequestMapping("fb_i")
    public DataResponse insertFeedback(FeedBack feedBack) {
        return feedBackService.insertFeedback(feedBack);
    }

    @RequestMapping("fb_d_list")
    public DataResponse delFeedbackBatch(String fbs) {
        return feedBackService.delFeedbackBatch(fbs);
    }

}
