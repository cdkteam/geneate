package com.logy.service.inter;

import com.logy.form.NewsForm;
import com.logy.mode.News;
import com.logy.utils.DataResponse;

import javax.servlet.http.HttpServletRequest;

public interface NewsService {
    DataResponse queryAllNews(NewsForm newsForm);
    DataResponse insertNews(News news, HttpServletRequest request);
    DataResponse delNewsBatch(String news);
}
