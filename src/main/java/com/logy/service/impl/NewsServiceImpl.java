package com.logy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.logy.form.FeedBackForm;
import com.logy.form.NewsForm;
import com.logy.mapper.FeedBackMapper;
import com.logy.mapper.NewsMapper;
import com.logy.mode.FeedBack;
import com.logy.mode.News;
import com.logy.mode.User;
import com.logy.service.inter.FeedBackService;
import com.logy.service.inter.NewsService;
import com.logy.utils.DataResponse;
import com.logy.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class NewsServiceImpl implements NewsService {
    private Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public DataResponse queryAllNews(NewsForm newsForm) {
        DataResponse<List<News>> dataResponse = new DataResponse<>();
        List<News> newsList = newsMapper.queryAllNews(newsForm);
        int countNews = newsMapper.countNews(newsForm);
        dataResponse.setData(newsList);
        dataResponse.setPageCount(countNews);
        return dataResponse;
    }


    @Transactional
    @Override
    public DataResponse insertNews(News news, HttpServletRequest request) {
        DataResponse<News> dataResponse = new DataResponse<>();
        int result = 0;
        if(news.getNewsID() != null) {
            result = newsMapper.updateNews(news);
        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("userLogin");
            if(user != null) {
                news.setNewsFamilyID(user.getAdminID().longValue());
            }
            news.setNewsTime(DateUtils.getLocalDateNow().toString());
            result = newsMapper.insertNews(news);
        }

        if(result <= 0) {
            dataResponse.setMessage("fail");
            dataResponse.setCode(500);
        }
        dataResponse.setData(news);
        return dataResponse;
    }

    @Transactional
    @Override
    public DataResponse delNewsBatch(String news) {
        DataResponse<News> dataResponse = new DataResponse<>();
        List<News> newsList = JSONArray.parseArray(news, News.class);
        int result = newsMapper.delNewsBatch(newsList);
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

}
