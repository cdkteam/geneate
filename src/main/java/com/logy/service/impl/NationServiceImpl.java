package com.logy.service.impl;

import com.logy.mapper.NationMapper;
import com.logy.mode.Nation;
import com.logy.mode.User;
import com.logy.service.inter.NationService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 民族服务实现类
 */
@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationMapper nationMapper;

    /**
     * 查询所有民族信息
     * @return
     */
    @Override
    public DataResponse queryAllNation() {
        DataResponse<List<Nation>> dataResponse = new DataResponse<>();
        List<Nation> nationList = nationMapper.queryAllNation();//查询所有民族信息
        dataResponse.setData(nationList);//向相应数据设置查询到的民族信息
        return dataResponse;//返回响应数据
    }
}
