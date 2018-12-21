package com.face.yr.web;

import com.face.yr.domain.po.FaceUser;
import com.face.yr.service.FaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * FaceUser 控制层
 *
 */
@Controller
public class FaceUserController {
    @Autowired
    private FaceUserService faceUserService;


    @RequestMapping(value = "/user/query", method = RequestMethod.GET)
    @ResponseBody
    public String queryUser(Integer id){
        return faceUserService.queryUser(id);
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    @ResponseBody
    public String addTea(FaceUser user){
        return faceUserService.addTea(user);
    }

    @RequestMapping(value = "/user/del", method = RequestMethod.GET)
    @ResponseBody
    public String delTea(Integer id){
        return faceUserService.delUser(id);
    }


    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(FaceUser user){
        return faceUserService.updateUser(user);
    }

    @RequestMapping(value = "/user/listTea", method = RequestMethod.GET)
    public String listTea(Model model){
        faceUserService.listUser(model,2);
        return "teaList";
    }

    @RequestMapping(value = "/user/listStu", method = RequestMethod.GET)
    public String listStu(Model model){
        faceUserService.listUser(model,3);
        return "stuList";
    }

}