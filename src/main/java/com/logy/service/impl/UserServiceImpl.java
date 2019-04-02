package com.logy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.logy.mapper.UserMapper;
import com.logy.form.UserForm;
import com.logy.mode.User;
import com.logy.service.inter.UserService;
import com.logy.utils.DataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 后台管理账户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户
     * @param user
     * @param request
     * @return
     */
    @Override
    public DataResponse queryUserByAccountAndPass(User user, HttpServletRequest request) {
        DataResponse<User> dataResponse = new DataResponse<>();//声明数据响应对象
        User user1 = userMapper.queryUserByAccountAndPass(user);//查询用户
        if(user1 != null) {//如果对象不等于空 说明已在数据库中查询到该用户数据
            dataResponse.setData(user1);//向响应数据对象设置查询到的用户数据
            HttpSession session = request.getSession();//获取请求session
            session.setAttribute("userLogin", user1);//将数据信息设置到session中
        } else {
            dataResponse.setMessage("未找到该用户");//如果对象为空  则表示数据库中没有该对象
            dataResponse.setCode(500);//设置响应码
        }
        return dataResponse;
    }

    /**
     * 查询所有用户
     * @param userForm
     * @return
     */
    @Override
    public DataResponse queryAllUser(UserForm userForm) {
        DataResponse<List<User>> dataResponse = new DataResponse<>();//声明相应数据  数据是用户列表
        List<User> userList = userMapper.queryAllUser(userForm);//查询所有用户
        int userCount = userMapper.countUser(userForm);//统计用户数量
        dataResponse.setData(userList);//向相应数据中设置查询到的用户数据列表
        dataResponse.setPageCount(userCount);//向响应数据对象设置条数
        return dataResponse;//返回响应数据对象
    }

    /**
     * 插入后台管理账号
     * @param user
     * @return
     */
    @Transactional
    @Override
    public DataResponse insertAdmin(User user) {
        DataResponse<User> dataResponse = new DataResponse<>();
        LocalDate localDate = LocalDate.now();//获取当前时间
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyyMMdd");
        user.setAdminCreateDate(localDate.format(d));
        int result = userMapper.insertAdmin(user);//向数据库中插入用户数据
        if(result <= 0) {
            dataResponse.setMessage("fail");
            dataResponse.setCode(500);
        }
        dataResponse.setData(user);
        return dataResponse;
    }

    /**
     * 修改用户密码
     * @param userForm
     * @return
     */
    @Override
    public DataResponse updateAdminPassword(UserForm userForm) {
        DataResponse<User> dataResponse = new DataResponse<>();
        int result = userMapper.updateAdminPassword(userForm);//更新用户密码
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

    /**
     * 更改账号信息
     * @param userForm
     * @return
     */
    @Override
    public DataResponse updateAdminaccount(UserForm userForm) {
        DataResponse<User> dataResponse = new DataResponse<>();
        int result = userMapper.updateAdminaccount(userForm);//更新用户数据
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

    @Override
    public DataResponse delAdmin(User user) {
        DataResponse<User> dataResponse = new DataResponse<>();
        int result = userMapper.delAdmin(user);
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

    /**
     * 删除用户数据
     * @param users
     * @return
     */
    @Override
    public DataResponse delAdminBatch(String users) {
        DataResponse<User> dataResponse = new DataResponse<>();
        List<User> userList = JSONArray.parseArray(users, User.class);
        int result = userMapper.delAdminBatch(userList);//从数据库中删除用户数据
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }
}
