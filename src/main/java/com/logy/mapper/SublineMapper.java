package com.logy.mapper;

import com.logy.form.SublineForm;
import com.logy.mode.Subline;

import java.util.List;

public interface SublineMapper {
    List<Subline> queryAllSubline(SublineForm sublineForm);
    Integer countSubline(SublineForm sublineForm);
    Integer insertSub(Subline subline);
    Integer updateSub(Subline subline);
    Integer delSubBatch(List<Subline> subs);
}
