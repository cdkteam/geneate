package com.logy.controller;

import com.logy.form.SublineForm;
import com.logy.mode.Subline;
import com.logy.service.inter.SublineService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支系管理类
 */
@RestController
@RequestMapping("subline")
public class SublineController {
    /**
     * 声明支系管理服务类对象
     */
    @Autowired
    private SublineService sublineService;

    /**
     * 查询所有支系数据
     * @param sublineForm
     * @return
     */
    @RequestMapping("sub_list")
    public DataResponse queryAllSubline(SublineForm sublineForm) {
        return sublineService.queryAllSubline(sublineForm);
    }

    /**
     * 向数据库中插入支系数据
     * @param subline
     * @return
     */
    @RequestMapping("sub_i")
    public DataResponse insertSub(@RequestBody Subline subline) {
        return sublineService.insertSub(subline);
    }

    /**
     * 从数据库中删除支系数据
     * @param subs
     * @return
     */
    @RequestMapping("sub_d_list")
    public DataResponse delSubBatch(String subs) {
        return sublineService.delSubBatch(subs);
    }
}
