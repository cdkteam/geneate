package com.logy.service.inter;

import com.logy.form.FeedBackForm;
import com.logy.form.MemberForm;
import com.logy.mode.FeedBack;
import com.logy.mode.Member;
import com.logy.utils.DataResponse;

import java.util.List;

public interface FeedBackService {
    DataResponse queryAllFeedback(FeedBackForm feedBackForm);
    DataResponse queryFeedback(FeedBackForm feedBackForm);
    DataResponse insertFeedback(FeedBack feedBack);
    DataResponse delFeedbackBatch(String fbs);
}
