package com.logy.service.inter;

import com.logy.form.FamilyForm;
import com.logy.form.SublineForm;
import com.logy.mode.Family;
import com.logy.mode.Subline;
import com.logy.utils.DataResponse;

import javax.servlet.http.HttpServletRequest;

public interface FamilyService {
    DataResponse queryAllFamily(FamilyForm familyForm);
    DataResponse insertFamily(Family family, HttpServletRequest request);
    DataResponse delFamilyBatch(String fas);
}
