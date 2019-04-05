package com.logy.controller;

import com.logy.form.FamilyForm;
import com.logy.form.SublineForm;
import com.logy.mode.Family;
import com.logy.mode.Subline;
import com.logy.service.inter.FamilyService;
import com.logy.service.inter.SublineService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 家族控制类
 */
@RestController
@RequestMapping("family")
public class FamilyController {
    /**
     * 家族控制服务类对象
     */
    @Autowired
    private FamilyService familyService;

    /**
     * 查询所有家族数据
     * @param familyForm
     * @return
     */
    @RequestMapping("fa_list")
    public DataResponse queryAllFamily(FamilyForm familyForm) {
        return familyService.queryAllFamily(familyForm);
    }

    /**
     * 插入家族数据
     * @param family
     * @param request
     * @return
     */
    @RequestMapping("fa_i")
    public DataResponse insertFamily(@RequestBody Family family, HttpServletRequest request) {
        return familyService.insertFamily(family, request);
    }

    /**
     * 删除家族数据
     * @param fas
     * @return
     */
    @RequestMapping("fa_d_list")
    public DataResponse delFamilyBatch(String fas) {
        return familyService.delFamilyBatch(fas);
    }
}
