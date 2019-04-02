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

/**
 * 反馈数据服务实现类
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
    private Logger logger = LoggerFactory.getLogger(FeedBackServiceImpl.class);

    @Autowired
    private FeedBackMapper feedBackMapper;

    /**
     * 查询所有反馈意见
     * @param feedBackForm
     * @return
     */
    @Override
    public DataResponse queryAllFeedback(FeedBackForm feedBackForm) {
        DataResponse<List<FeedBack>> dataResponse = new DataResponse<>();
        List<FeedBack> feedBackList = feedBackMapper.queryAllFeedback(feedBackForm);//将查询到的列表复制到新列表中
        int memberCount = feedBackMapper.countFeedback(feedBackForm);//统计反馈数据条数
        dataResponse.setData(feedBackList);//向返回数据对象设置反馈列表
        dataResponse.setPageCount(memberCount);//相反会数据设置条数
        return dataResponse;
    }

    /**
     * 查询反馈数据
     * @param feedBackForm
     * @return
     */
    @Override
    public DataResponse queryFeedback(FeedBackForm feedBackForm) {
        DataResponse<List<FeedBack>> dataResponse = new DataResponse<>();
        List<FeedBack> feedBackList = feedBackMapper.queryFeedback(feedBackForm);//将查询到的数据设置给新的列表
        dataResponse.setData(feedBackList);//将列表赋值给返回数据对象
        return dataResponse;
    }

    /**
     * 插入反馈数据
     * @param feedBack
     * @return
     */
    @Transactional
    @Override
    public DataResponse insertFeedback(FeedBack feedBack) {
        DataResponse<FeedBack> dataResponse = new DataResponse<>();
        int result = 0;
        if(feedBack.getFbID() != null) {
            result = feedBackMapper.updateFeedback(feedBack);//更新
        } else {
            result = feedBackMapper.insertFeedback(feedBack);//插入
        }

        if(result <= 0) {
            dataResponse.setMessage("fail");
            dataResponse.setCode(500);
        }
        dataResponse.setData(feedBack);
        return dataResponse;
    }

    /**
     * 从数据库重伤喊出反馈
     * @param mes
     * @return
     */
    @Transactional
    @Override
    public DataResponse delFeedbackBatch(String mes) {
        DataResponse<FeedBack> dataResponse = new DataResponse<>();
        List<FeedBack> feedBackList = JSONArray.parseArray(mes, FeedBack.class);//使用json解析数据
        int result = feedBackMapper.delFeedbackBatch(feedBackList);//将删除结果赋值给int变量  -1删除失败
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

}
