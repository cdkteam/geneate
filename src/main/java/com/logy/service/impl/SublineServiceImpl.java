package com.logy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.logy.mapper.SublineMapper;
import com.logy.form.SublineForm;
import com.logy.mode.Subline;
import com.logy.service.inter.SublineService;
import com.logy.utils.DataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * 支系列表服务实现类
 */
@Service
public class SublineServiceImpl implements SublineService {
    private Logger logger = LoggerFactory.getLogger(SublineServiceImpl.class);

    @Autowired
    private SublineMapper sublineMapper;

    /**
     * 查询所有支系
     * @param sublineForm
     * @return
     */
    @Override
    public DataResponse queryAllSubline(SublineForm sublineForm) {
        DataResponse<List<Subline>> dataResponse = new DataResponse<>();//声明响应数据对象
        List<Subline> sublineList = sublineMapper.queryAllSubline(sublineForm);//查询所有数据
        int sublineCount = sublineMapper.countSubline(sublineForm);//统计支系条目数量
        dataResponse.setData(sublineList);//向响应数据对象设置查询到的所有数据
        dataResponse.setPageCount(sublineCount);//向相应数据设置条目数
        return dataResponse;//返回响应数据对象
    }

    @Override
    public DataResponse insertSub(Subline subline) {
        DataResponse<Subline> dataResponse = new DataResponse<>();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyyMMdd");
        subline.setSubCreateDate(localDate.format(d));
        subline.setSubCode(UUID.randomUUID().toString().replace("-", ""));
        int result = sublineMapper.insertSub(subline);
        if(result <= 0) {
            dataResponse.setMessage("fail");
            dataResponse.setCode(500);
        }
        dataResponse.setData(subline);
        return dataResponse;
    }

    @Override
    public DataResponse delSubBatch(String subs) {
        DataResponse<Subline> dataResponse = new DataResponse<>();
        List<Subline> sublineList = JSONArray.parseArray(subs, Subline.class);
        int result = sublineMapper.delSubBatch(sublineList);
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

}
