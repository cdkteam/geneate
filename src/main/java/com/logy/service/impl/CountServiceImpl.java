package com.logy.service.impl;

import com.logy.form.CountForm;
import com.logy.mapper.CountMapper;
import com.logy.mode.CountData;
import com.logy.service.inter.CountService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 统计服务实现类
 */
@Service
public class CountServiceImpl implements CountService {
    @Autowired
    private CountMapper countMapper;

    /**
     * 统计基础数据
     * @param countForm
     * @param type
     * @return
     */
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
            // 辈分分布
            case 4:
                countData = countMapper.countSubline(countForm);
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
