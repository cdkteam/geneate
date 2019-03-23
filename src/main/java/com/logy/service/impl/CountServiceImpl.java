package com.logy.service.impl;

import com.logy.mapper.CountMapper;
import com.logy.mode.CountData;
import com.logy.service.inter.CountService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {
    @Autowired
    private CountMapper countMapper;

    @Override
    public DataResponse countBaseData() {
        DataResponse<CountData> response = new DataResponse<>();
        CountData countData = countMapper.countData();
        if(countData == null) {
            response.setCode(500);
            response.setMessage("fail");
        }
        response.setData(countData);
        return response;
    }

    @Override
    public DataResponse countSex() {
        DataResponse<CountData> response = new DataResponse<>();
        CountData countData = countMapper.countSex();
        if(countData == null) {
            response.setCode(500);
            response.setMessage("fail");
        }
        response.setData(countData);
        return response;
    }
}
