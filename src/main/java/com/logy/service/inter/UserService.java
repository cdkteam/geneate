package com.logy.service.inter;

import com.logy.form.UserForm;
import com.logy.mode.CarsouleImg;
import com.logy.mode.User;
import com.logy.utils.DataResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    DataResponse queryUserByAccountAndPass(User user, HttpServletRequest request);
    DataResponse queryAllUser(UserForm userForm);
    DataResponse insertAdmin(User user);
    DataResponse updateAdminPassword(UserForm userForm);
    DataResponse updateAdminaccount(UserForm userForm);
    DataResponse delAdmin(User user);
    DataResponse delAdminBatch(String users);
}
