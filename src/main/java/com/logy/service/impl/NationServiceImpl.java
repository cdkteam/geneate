package com.logy.service.impl;

import com.logy.mapper.NationMapper;
import com.logy.mode.Nation;
import com.logy.mode.User;
import com.logy.service.inter.NationService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationMapper nationMapper;

    @Override
    public DataResponse queryAllNation() {
        DataResponse<List<Nation>> dataResponse = new DataResponse<>();
        List<Nation> nationList = nationMapper.queryAllNation();
        dataResponse.setData(nationList);
        return dataResponse;
    }
}
