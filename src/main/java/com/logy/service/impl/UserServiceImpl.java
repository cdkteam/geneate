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


@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;


    @Override
    public DataResponse queryUserByAccountAndPass(User user, HttpServletRequest request) {
        DataResponse<User> dataResponse = new DataResponse<>();
        User user1 = userMapper.queryUserByAccountAndPass(user);
        if(user1 != null) {
            dataResponse.setData(user1);

            HttpSession session = request.getSession();

            session.setAttribute("userLogin", user1);
        } else {
            dataResponse.setMessage("未找到该用户");
            dataResponse.setCode(500);
        }
        return dataResponse;
    }

    @Override
    public DataResponse queryAllUser(UserForm userForm) {
        DataResponse<List<User>> dataResponse = new DataResponse<>();
        List<User> userList = userMapper.queryAllUser(userForm);
        int userCount = userMapper.countUser(userForm);
        dataResponse.setData(userList);
        dataResponse.setPageCount(userCount);
        return dataResponse;
    }

    @Transactional
    @Override
    public DataResponse insertAdmin(User user) {
        DataResponse<User> dataResponse = new DataResponse<>();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyyMMdd");
        user.setAdminCreateDate(localDate.format(d));
        int result = userMapper.insertAdmin(user);
        if(result <= 0) {
            dataResponse.setMessage("fail");
            dataResponse.setCode(500);
        }
        dataResponse.setData(user);
        return dataResponse;
    }

    @Override
    public DataResponse updateAdminPassword(UserForm userForm) {
        DataResponse<User> dataResponse = new DataResponse<>();
        int result = userMapper.updateAdminPassword(userForm);
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

    @Override
    public DataResponse updateAdminaccount(UserForm userForm) {
        DataResponse<User> dataResponse = new DataResponse<>();
        int result = userMapper.updateAdminaccount(userForm);
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

    @Override
    public DataResponse delAdminBatch(String users) {
        DataResponse<User> dataResponse = new DataResponse<>();
        List<User> userList = JSONArray.parseArray(users, User.class);
        int result = userMapper.delAdminBatch(userList);
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }
}
