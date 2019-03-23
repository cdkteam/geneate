package com.logy.mapper;

import com.logy.form.NewsForm;
import com.logy.form.UserForm;
import com.logy.mode.News;
import com.logy.mode.User;

import java.util.List;


public interface NewsMapper {
    List<News> queryAllNews(NewsForm newsForm);
    Integer countNews(NewsForm newsForm);
    Integer updateNews(News news);
    Integer insertNews(News news);
    Integer delNewsBatch(List<News> news);
}
