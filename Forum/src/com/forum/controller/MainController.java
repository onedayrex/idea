package com.forum.controller;

import com.forum.entities.Manage;
import com.forum.entities.User;
import com.forum.service.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Tarena-java on 2016/2/3.
 */
@Controller("maincontroller")
public class MainController {
    private TopicService topicService;
    private TitleService titleService;
    private LoginService loginService;
    private RegistService registService;
    private ReplayService replayService;
    private UserService userService;
    private ManageService manageService;

    public ManageService getManageService() {
        return manageService;
    }
    @Resource(name = "ManageService")
    public void setManageService(ManageService manageService) {
        this.manageService = manageService;
    }

    public UserService getUserService() {
        return userService;
    }
    @Resource(name = "UserService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ReplayService getReplayService() {
        return replayService;
    }

    @Resource(name = "ReplayService")
    public void setReplayService(ReplayService replayService) {
        this.replayService = replayService;
    }

    public RegistService getRegistService() {
        return registService;
    }
    @Resource(name = "RegistService")
    public void setRegistService(RegistService registService) {
        this.registService = registService;
    }

    public LoginService getLoginService() {
        return loginService;
    }
    @Resource(name = "LoginService")
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public TitleService getTitleService() {
        return titleService;
    }
    @Resource(name = "TitleService")
    public void setTitleService(TitleService titleService) {
        this.titleService = titleService;
    }

    public TopicService getTopicService() {
        return topicService;
    }
    @Resource(name = "TopicService")
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping("toregist.do")
    public String toRegist(){
        return "regist/regist";
    }

    @RequestMapping("regist.do")
    public String Regist(User user){
        registService.creatUser(user);
        return "redirect:tologin.do";
    }

    @RequestMapping("tologin.do")
    public String toLogin(){
        return "login/login";
    }
    @RequestMapping("login.do")
    public String login(HttpServletRequest req){
        return  loginService.findUserById(req);
    }
    @RequestMapping("/totopic.do")
    public String toTopic(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "redirect:tologin.do";
        }
        return "topic/topic";
    }

    @RequestMapping("/creattopic.do")
    public String Creattopic(HttpSession session,HttpServletRequest req){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "redirect:tologin.do";
        }
        topicService.CreateTopic(req);
        return "redirect:toalltitle.do";
    }

    @RequestMapping("/toshow.do")
    public String toShwo(HttpServletRequest req){
        topicService.getTopicById(req);
        replayService.findReplayServiceByID(req);
        return "topic/show";
    }

    @RequestMapping("/toalltitle.do")
    public String toAllTitle(HttpServletRequest req){
        titleService.findAllTitle(req);
        return "title/alltitle";
    }
    @RequestMapping("/replay.do")
    public String replay(HttpSession session,HttpServletRequest req){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "redirect:tologin.do";
        }
        replayService.creatReplay(req);
        String topicid = req.getParameter("topicid");
        return "redirect:toshow.do?id="+topicid;
    }

    @RequestMapping("/toupdata.do")
    public String toUpdataPwd(HttpSession session,HttpServletRequest req){
        User currentuser = (User) session.getAttribute("user");
        if(currentuser==null){
            return "redirect:tologin.do";
        }
        User user = userService.toupdata(req);
        req.setAttribute("user",user);
        return "user/updata";
    }

    @RequestMapping("/updata.do")
    public String updata(HttpServletRequest req){
        userService.updataPassword(req);
        return "redirect:tologin.do";
    }

    @RequestMapping("/tomanagelogin.do")
    public String toManageLogin(){
        return "manage/managelogin";
    }

    @RequestMapping("/managelogin.do")
    public String ManageLogin(Manage manage,HttpServletRequest req){
        if(manageService.checkManage(manage,req)){
            return "redirect:toalltitle.do";
        }else {
            return "redirect:tomanagelogin.do";
        }
    }

    @RequestMapping("/deletetopic.do")
    public String deleteTopic(HttpServletRequest req){
        String topicid= req.getParameter("id");
        manageService.deleteTopic(new Integer(topicid));
        return "redirect:toalltitle.do";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.removeAttribute("manage");
        return "redirect:toalltitle.do";
    }

//    @ExceptionHandler
//    public String execeptionHandler(Exception e,HttpServletRequest req){
//        if(e instanceof EmptyResultDataAccessException){
//            req.setAttribute("error","用户ID不存在");
//        }
//        return "login/login";
//    }
}
