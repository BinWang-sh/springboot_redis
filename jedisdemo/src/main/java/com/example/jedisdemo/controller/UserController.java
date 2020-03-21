package com.example.jedisdemo.controller;


import com.example.jedisdemo.pojo.User;
import com.example.jedisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService usrService;

    @RequestMapping("/adduser")
    public String AddUserToRedis(@RequestParam("userId") String uId,
                                 @RequestParam("userName") String uName,
                                 @RequestParam("groupId") long grpId) {
        User usr = new User();
        usr.setName(uName);
        usr.setUID(uId);
        usr.setGroupID(grpId);

        usrService.setUser(usr);

        return "OK";
    }

    @RequestMapping("/getuser")
    public String GetUserFromRedis(@RequestParam("userId") String uId) {
        User usr = usrService.getUser(uId);

        return usr.toString();
    }
}
