package com.face.yr.web;

import com.face.yr.domain.po.FaceUser;
import com.face.yr.service.FaceUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author zhengql
 * @date 2018/12/20 15:00
 */

@Controller
public class BaseController {

    @Autowired
    private FaceUserService faceUserService;
    /**
     * 跳转登录
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String searchFace(Model model,HttpSession session) {
        session.invalidate();
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model,HttpSession session) {
        session.invalidate();
        return "login";
    }
    /**
     * 跳转首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model,HttpSession session) {
        FaceUser user = (FaceUser) session.getAttribute("sessionUser");
        user = faceUserService.selectById(user.getId());
        Map<String,Object> map = new HashMap<>();
        map = faceUserService.checkSign(map,user);
        model.addAllAttributes(map);
        session.setAttribute("sessionUser",user);
        return "index";
    }

    /**
     * 跳转教师页
     * @param model
     * @return
     */
    @RequestMapping(value = "/tea", method = RequestMethod.GET)
    public String tea(Model model) {
        return "teaList";
    }


    /***
     * 跳转注册页
     * @param model
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        return "register";
    }


    /***
     * 跳转签到页
     * @param model
     * @return
     */
    @RequestMapping(value = "/stuSign", method = RequestMethod.GET)
    public String stuSign(Model model) {
        return "sign";
    }

    /***
     * 登录
     * @param faceUser
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(FaceUser faceUser, HttpSession session,Model model) {
//        return faceUserService.login2(faceUser,session,model);
        return faceUserService.login(faceUser,session,model);
    }
}
