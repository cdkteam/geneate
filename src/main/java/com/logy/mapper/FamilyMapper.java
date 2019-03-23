package com.logy.mapper;

import com.logy.form.FamilyForm;
import com.logy.form.SublineForm;
import com.logy.mode.Family;
import com.logy.mode.Subline;

import java.util.List;

public interface FamilyMapper {
    List<Family> queryAllFamily(FamilyForm familyForm);
    Integer countFamily(FamilyForm familyForm);
    Integer insertFamily(Family family);
    Integer delFamilyBatch(List<Family> fas);
    void updateFamilyNum(FamilyForm familyForm);
}
