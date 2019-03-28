package com.logy.controller;

import com.logy.form.NewsForm;
import com.logy.mode.News;
import com.logy.service.inter.NewsService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 帖子消息控制类
 */
@RestController
@RequestMapping("news")
public class NewsController {
    /**
     * 声明帖子消息服务类对象
     */
    @Autowired
    private NewsService newsService;

    /**
     * 查询所有的帖子数据
     * @param newsForm
     * @return
     */
    @RequestMapping("news_list")
    public DataResponse queryAllFeedback(NewsForm newsForm) {
        return newsService.queryAllNews(newsForm);
    }

    /**
     * 查询帖子数据
     * @param news
     * @param request
     * @return
     */
    @RequestMapping("news_i")
    public DataResponse insertFeedback(News news, HttpServletRequest request) {
        return newsService.insertNews(news, request);
    }

    /**
     * 删除帖子数据
     * @param news
     * @return
     */
    @RequestMapping("news_d_list")
    public DataResponse delFeedbackBatch(String news) {
        return newsService.delNewsBatch(news);
    }

}
