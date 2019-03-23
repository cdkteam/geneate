package com.logy.controller;

import com.logy.form.SublineForm;
import com.logy.mode.Subline;
import com.logy.service.inter.SublineService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subline")
public class SublineController {
    @Autowired
    private SublineService sublineService;

    @RequestMapping("sub_list")
    public DataResponse queryAllSubline(SublineForm sublineForm) {
        return sublineService.queryAllSubline(sublineForm);
    }

    @RequestMapping("sub_i")
    public DataResponse insertSub(Subline subline) {
        return sublineService.insertSub(subline);
    }

    @RequestMapping("sub_d_list")
    public DataResponse delSubBatch(String subs) {
        return sublineService.delSubBatch(subs);
    }
}
