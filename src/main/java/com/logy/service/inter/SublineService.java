package com.logy.service.inter;

import com.logy.form.SublineForm;
import com.logy.form.UserForm;
import com.logy.mode.Subline;
import com.logy.mode.User;
import com.logy.utils.DataResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SublineService {
    DataResponse queryAllSubline(SublineForm sublineForm);
    DataResponse insertSub(Subline subline);
    DataResponse delSubBatch(String users);
}
