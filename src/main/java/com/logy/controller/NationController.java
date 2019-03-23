package com.logy.controller;

import com.logy.service.inter.NationService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nation")
public class NationController {
    @Autowired
    private NationService nationService;

    @RequestMapping("user_list")
    public DataResponse queryAllNation() {
        return nationService.queryAllNation();
    }
}
