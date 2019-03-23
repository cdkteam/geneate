package com.logy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.logy.form.FeedBackForm;
import com.logy.mapper.FeedBackMapper;
import com.logy.mode.FeedBack;
import com.logy.service.inter.FeedBackService;
import com.logy.utils.DataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class FeedBackServiceImpl implements FeedBackService {
    private Logger logger = LoggerFactory.getLogger(FeedBackServiceImpl.class);

    @Autowired
    private FeedBackMapper feedBackMapper;

    @Override
    public DataResponse queryAllFeedback(FeedBackForm feedBackForm) {
        DataResponse<List<FeedBack>> dataResponse = new DataResponse<>();
        List<FeedBack> feedBackList = feedBackMapper.queryAllFeedback(feedBackForm);
        int memberCount = feedBackMapper.countFeedback(feedBackForm);
        dataResponse.setData(feedBackList);
        dataResponse.setPageCount(memberCount);
        return dataResponse;
    }

    @Override
    public DataResponse queryFeedback(FeedBackForm feedBackForm) {
        DataResponse<List<FeedBack>> dataResponse = new DataResponse<>();
        List<FeedBack> feedBackList = feedBackMapper.queryFeedback(feedBackForm);
        dataResponse.setData(feedBackList);
        return dataResponse;
    }


    @Transactional
    @Override
    public DataResponse insertFeedback(FeedBack feedBack) {
        DataResponse<FeedBack> dataResponse = new DataResponse<>();
        int result = 0;
        if(feedBack.getFbID() != null) {
            result = feedBackMapper.updateFeedback(feedBack);
        } else {
            result = feedBackMapper.insertFeedback(feedBack);
        }

        if(result <= 0) {
            dataResponse.setMessage("fail");
            dataResponse.setCode(500);
        }
        dataResponse.setData(feedBack);
        return dataResponse;
    }

    @Transactional
    @Override
    public DataResponse delFeedbackBatch(String mes) {
        DataResponse<FeedBack> dataResponse = new DataResponse<>();
        List<FeedBack> feedBackList = JSONArray.parseArray(mes, FeedBack.class);
        int result = feedBackMapper.delFeedbackBatch(feedBackList);
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

}
