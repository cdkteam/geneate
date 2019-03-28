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

    /**
     * 向外界提供查询所有消息的方法
     * @param newsForm
     * @return
     */
    @Override
    public DataResponse queryAllNews(NewsForm newsForm) {
        //声明一个消息列表数据响应类对象
        DataResponse<List<News>> dataResponse = new DataResponse<>();
        //从数据库中查询所有消息并且赋值给一个消息列表
        List<News> newsList = newsMapper.queryAllNews(newsForm);
        //得到消息的条数
        int countNews = newsMapper.countNews(newsForm);
        //给数据响应类对象设置数据
        dataResponse.setData(newsList);
        //给数据响应类对象设置条数
        dataResponse.setPageCount(countNews);
        //返回数据响应类
        return dataResponse;
    }



    /**
     * 给外界提供向数据库中插入消息的方法
     * @param news 消息对象
     * @param request 请求体
     * @return 消息的查寻结果
     */
    @Transactional
    @Override
    public DataResponse insertNews(News news, HttpServletRequest request) {
        //声明一个消息数据响应类对象
        DataResponse<News> dataResponse = new DataResponse<>();
        //声明一个int类型的变量
        int result = 0;
        //如果消息对象的id不等于空值
        if(news.getNewsID() != null) {
            //更新数据库数据并且得到返回值
            result = newsMapper.updateNews(news);
        } else {
            //如果消息对象的id等于空值
            //从请求体中获取session对象
            HttpSession session = request.getSession();
            //从session对象中获取用户对象
            User user = (User) session.getAttribute("userLogin");
            //如果用户对象不等于空
            if(user != null) {
                //将消息的家族ID设置为用户的家族ID
                news.setNewsFamilyID(user.getAdminID().longValue());
            }
            //消息的时间设置为当前系统的时间
            news.setNewsTime(DateUtils.getLocalDateNow().toString());
            //向数据库中插入消息数据
            result = newsMapper.insertNews(news);
        }
        //如果以上的返回结果只小于或等于0
        if(result <= 0) {
            //将响应对象的消息设置为"fail"
            dataResponse.setMessage("fail");
            //将响应对象的响应码设置为500
            dataResponse.setCode(500);
        }
        //给数据响应对象设置数据
        dataResponse.setData(news);
        //返回数据响应对象
        return dataResponse;
    }

    /**
     * 给外界提供一个删除消息的方法
     * @param news  消息对象的json字符串
     * @return
     */
    @Transactional
    @Override
    public DataResponse delNewsBatch(String news) {
        //声明一个消息数据响应类对象
        DataResponse<News> dataResponse = new DataResponse<>();
        //使用json解析消息对象的json字符串，解析完赋值给消息列表
        List<News> newsList = JSONArray.parseArray(news, News.class);
        //从数据库中删除消息列表并且得到一个返回值
        int result = newsMapper.delNewsBatch(newsList);
        //如果返回值小于或等于0
        if(result <= 0) {
            //给数据响应对象设置响应码
            dataResponse.setCode(500);
            //给数据响应对象设置消息数据
            dataResponse.setMessage("fail");
        }
        //返回数据响应类
        return dataResponse;
    }

}
