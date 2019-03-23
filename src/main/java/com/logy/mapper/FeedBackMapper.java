package com.logy.mapper;

import com.logy.form.FeedBackForm;
import com.logy.mode.FeedBack;
import com.logy.mode.Member;

import java.util.List;

public interface FeedBackMapper {
    List<FeedBack> queryAllFeedback(FeedBackForm feedBackForm);
    List<FeedBack> queryFeedback(FeedBackForm feedBackForm);
    Integer countFeedback(FeedBackForm feedBackForm);
    Integer insertFeedback(FeedBack feedBack);
    Integer updateFeedback(FeedBack feedBack);
    Integer delFeedbackBatch(List<FeedBack> fbs);
}
