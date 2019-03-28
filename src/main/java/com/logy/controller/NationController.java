package com.logy.controller;

import com.logy.service.inter.NationService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 民族控制类
 */
@RestController
@RequestMapping("nation")
public class NationController {
    /**
     * 民族服务类对象
     */
    @Autowired
    private NationService nationService;

    /**
     * 查询所有的民族信息
     * @return
     */
    @RequestMapping("user_list")
    public DataResponse queryAllNation() {
        return nationService.queryAllNation();
    }
}
