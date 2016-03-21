package com.forum.serviceimp;

import com.forum.dao.UserDao;
import com.forum.entities.User;
import com.forum.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by onedayrex on 2016/2/12.
 */
@Service("UserService")
public class UserServiceImp implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    @Resource(name = "UserDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void updataPassword(HttpServletRequest req) {
        String id = req.getParameter("userid");
        String password = req.getParameter("password");
        User user = new User();
        user.setId(new Integer(id));
        user.setPassword(password);
        userDao.updataPassword(user);
        HttpSession session = req.getSession();
        session.removeAttribute("user");
    }

    @Override
    public User toupdata(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return userDao.getUserById(user.getId());
    }


}
