package com.forum.serviceimp;

import com.forum.dao.LoginDao;
import com.forum.entities.User;
import com.forum.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by onedayrex on 2016/2/5.
 */
@Service("LoginService")
public class LoginServiceImp implements LoginService {
    private LoginDao loginDao;

    public LoginDao getLoginDao() {
        return loginDao;
    }
    @Resource(name = "LoginDao")
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public String findUserById(HttpServletRequest req) {
        String userid = req.getParameter("userid");
        String password = req.getParameter("password");
        User user = null;
        if(userid!=null&&!userid.equals("")){
            user = (User) loginDao.findUserById(new Integer(userid));
            if (user!=null) {
                if(user.getPassword().equals(password)){
                    //登录成功
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);
                    return "redirect:toalltitle.do";
                }
            } else {
                req.setAttribute("error","用户ID有误");
            }
        }
        if(userid==null||userid.equals("")||user==null){
            req.setAttribute("error","用户ID有误");
        }else{
            req.setAttribute("error","密码错误");
        }


        return "login/login";
    }


}
