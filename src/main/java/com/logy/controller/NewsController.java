package com.logy.controller;

import com.logy.form.NewsForm;
import com.logy.mode.News;
import com.logy.service.inter.NewsService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("news_list")
    public DataResponse queryAllFeedback(NewsForm newsForm) {
        return newsService.queryAllNews(newsForm);
    }

    @RequestMapping("news_i")
    public DataResponse insertFeedback(News news, HttpServletRequest request) {
        return newsService.insertNews(news, request);
    }

    @RequestMapping("news_d_list")
    public DataResponse delFeedbackBatch(String news) {
        return newsService.delNewsBatch(news);
    }

}
