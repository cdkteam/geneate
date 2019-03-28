package com.logy.controller;


import com.logy.form.UserForm;
import com.logy.mode.User;
import com.logy.service.inter.UserService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *    RestController 用于请求方法返回JSON数据
 *
 *    RequestMapping 请求路径
 *
 * @author xky
 * @date 2019/3/14 0:00
 * @param
 * @return
 */
@RestController
@RequestMapping("user_operator")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("user_l")
    public DataResponse userLogin(User user, HttpServletRequest request) {
        return userService.queryUserByAccountAndPass(user, request);
    }

    @RequestMapping("user_list")
    public DataResponse userLogin(UserForm userForm) {
        return userService.queryAllUser(userForm);
    }

    @RequestMapping("user_i")
    public DataResponse insertAdmin(User user) {
        return userService.insertAdmin(user);
    }

    @RequestMapping("user_d")
    public DataResponse delAdmin(User user) {
        return userService.delAdmin(user);
    }

    @RequestMapping("user_c")
    public DataResponse updateAdminPassword(UserForm userForm) {
        return userService.updateAdminPassword(userForm);
    }

    @RequestMapping("user_c_a")
    public DataResponse updateAdminaccount(UserForm userForm) {
        return userService.updateAdminaccount(userForm);
    }

    @RequestMapping("user_d_list")
    public DataResponse delAdmin(String users) {
        return userService.delAdminBatch(users);
    }
}
