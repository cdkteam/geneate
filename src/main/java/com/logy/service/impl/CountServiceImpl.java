package com.logy.service.impl;

import com.logy.form.CountForm;
import com.logy.mapper.CountMapper;
import com.logy.mode.CountData;
import com.logy.service.inter.CountService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountServiceImpl implements CountService {
    @Autowired
    private CountMapper countMapper;

    @Override
    public DataResponse countBaseData(CountForm countForm, Integer type) {
        DataResponse<List<CountData>> response = new DataResponse<>();
        List<CountData> countData = null;
        switch (type) {
            // 后台首页基础数据
            case 1:
                countData = countMapper.countData();
            break;
            // 男女统计
            case 2:
                countData = countMapper.countSex(countForm);
            break;
            // 年龄分布
            case 3:
                countData = countMapper.countAge(countForm);
            break;
        }
        if(countData == null) {
            response.setCode(500);
            response.setMessage("fail");
        }
        response.setData(countData);
        return response;
    }

}
