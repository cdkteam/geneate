package com.logy.service.inter;

import com.logy.form.CountForm;
import com.logy.utils.DataResponse;

public interface CountService {
    DataResponse countBaseData(CountForm countForm, Integer type);
}
