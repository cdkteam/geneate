package com.logy.controller;

import com.logy.form.FamilyForm;
import com.logy.form.SublineForm;
import com.logy.mode.Family;
import com.logy.mode.Subline;
import com.logy.service.inter.FamilyService;
import com.logy.service.inter.SublineService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("family")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @RequestMapping("fa_list")
    public DataResponse queryAllFamily(FamilyForm familyForm) {
        return familyService.queryAllFamily(familyForm);
    }

    @RequestMapping("fa_i")
    public DataResponse insertFamily(Family family, HttpServletRequest request) {
        return familyService.insertFamily(family, request);
    }

    @RequestMapping("fa_d_list")
    public DataResponse delFamilyBatch(String fas) {
        return familyService.delFamilyBatch(fas);
    }
}
