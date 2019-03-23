package com.logy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.logy.mapper.FamilyMapper;
import com.logy.form.FamilyForm;
import com.logy.mode.Family;
import com.logy.service.inter.FamilyService;
import com.logy.utils.DataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class FamilyServiceImpl implements FamilyService {
    private Logger logger = LoggerFactory.getLogger(FamilyServiceImpl.class);

    @Autowired
    private FamilyMapper familyMapper;

    @Override
    public DataResponse queryAllFamily(FamilyForm familyForm) {
        DataResponse<List<Family>> dataResponse = new DataResponse<>();
        List<Family> familyList = familyMapper.queryAllFamily(familyForm);
        int familyCount = familyMapper.countFamily(familyForm);
        dataResponse.setData(familyList);
        dataResponse.setPageCount(familyCount);
        return dataResponse;
    }

    @Override
    public DataResponse insertFamily(Family family, HttpServletRequest request) {
        DataResponse<Family> dataResponse = new DataResponse<>();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyyMMdd");
        family.setFamilyCreateDate(localDate.format(d));
        int result = familyMapper.insertFamily(family);
        if(result <= 0) {
            dataResponse.setMessage("fail");
            dataResponse.setCode(500);
        }
        // 设置添加家族的消息
        request.getSession().setAttribute("family_message", "欢迎" + family.getFamilyName() + "家族加入系统");
        // 设为未读状态
        request.getSession().setAttribute("family_read", 0);
        dataResponse.setData(family);
        return dataResponse;
    }

    @Override
    public DataResponse delFamilyBatch(String fas) {
        DataResponse<Family> dataResponse = new DataResponse<>();
        List<Family> familyList = JSONArray.parseArray(fas, Family.class);
        int result = familyMapper.delFamilyBatch(familyList);
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

}
