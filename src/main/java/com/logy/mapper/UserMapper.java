package com.logy.mapper;

import com.logy.form.UserForm;
import com.logy.mode.User;

import java.util.List;


public interface UserMapper {
    User queryUserByAccountAndPass(User user);
    List<User> queryAllUser(UserForm userForm);
    Integer countUser(UserForm userForm);
    Integer updateAdminPassword(UserForm userForm);
    Integer updateAdminaccount(UserForm userForm);
    Integer insertAdmin(User user);
    Integer delAdmin(User user);
    Integer delAdminBatch(List<User> users);
}
