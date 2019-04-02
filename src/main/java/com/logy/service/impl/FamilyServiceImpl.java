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

/**
 * 家族服务实现类
 */
@Service
public class FamilyServiceImpl implements FamilyService {
    private Logger logger = LoggerFactory.getLogger(FamilyServiceImpl.class);

    @Autowired
    private FamilyMapper familyMapper;

    /**
     * 查询所有家族
     * @param familyForm
     * @return
     */
    @Override
    public DataResponse queryAllFamily(FamilyForm familyForm) {
        DataResponse<List<Family>> dataResponse = new DataResponse<>();
        List<Family> familyList = familyMapper.queryAllFamily(familyForm);//将查询到的列表赋值到新列表中
        int familyCount = familyMapper.countFamily(familyForm);//将统计到该家族的数量赋值给新的int变量
        dataResponse.setData(familyList);//给返回数据对象设置家族列表
        dataResponse.setPageCount(familyCount);//给返回对象设置家族数量
        return dataResponse;
    }

    /**
     * 插入家族
     * @param family
     * @param request
     * @return
     */
    @Override
    public DataResponse insertFamily(Family family, HttpServletRequest request) {
        DataResponse<Family> dataResponse = new DataResponse<>();
        LocalDate localDate = LocalDate.now();//获取系统当前时间
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyyMMdd");//格式化日期数据
        family.setFamilyCreateDate(localDate.format(d));//将日期设置给家族对象
        int result = familyMapper.insertFamily(family);//向数据库中插入家族
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

    /**
     * 删除家族
     * @param fas
     * @return
     */
    @Override
    public DataResponse delFamilyBatch(String fas) {
        DataResponse<Family> dataResponse = new DataResponse<>();
        List<Family> familyList = JSONArray.parseArray(fas, Family.class);//使用json解析字符串
        int result = familyMapper.delFamilyBatch(familyList);//从数据库重伤删除家族
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

}
