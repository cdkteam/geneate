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
 *  用户管理类
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
    /**
     * 声明用户管理服务类对象
     */
    @Autowired
    private UserService userService;

    /**
     * 用户登录（查询单个数据）
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("user_l")
    public DataResponse userLogin(User user, HttpServletRequest request) {
        return userService.queryUserByAccountAndPass(user, request);
    }

    /**
     * 用户登录（查询所有用户数据）
     * @param userForm
     * @return
     */
    @RequestMapping("user_list")
    public DataResponse userLogin(UserForm userForm) {
        return userService.queryAllUser(userForm);
    }
    /**
     * 向数据库中插入用户数据
     */
    @RequestMapping("user_i")
    public DataResponse insertAdmin(User user) {
        return userService.insertAdmin(user);
    }

    /**
     * 从数据库中删除用户数据
     * @param user
     * @return
     */
    @RequestMapping("user_d")
    public DataResponse delAdmin(User user) {
        return userService.delAdmin(user);
    }

    /**
     * 更新用户密码
     * @param userForm
     * @return
     */
    @RequestMapping("user_c")
    public DataResponse updateAdminPassword(UserForm userForm) {
        return userService.updateAdminPassword(userForm);
    }

    /**
     * 更新用户账号
     * @param userForm
     * @return
     */
    @RequestMapping("user_c_a")
    public DataResponse updateAdminaccount(UserForm userForm) {
        return userService.updateAdminaccount(userForm);
    }

    /**
     * 删除用户
     * @param users
     * @return
     */
    @RequestMapping("user_d_list")
    public DataResponse delAdmin(String users) {
        return userService.delAdminBatch(users);
    }
}
