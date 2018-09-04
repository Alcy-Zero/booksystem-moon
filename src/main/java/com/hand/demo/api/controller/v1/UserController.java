package com.hand.demo.api.controller.v1;

import com.hand.demo.api.service.UserService;
import com.hand.demo.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/v1/users")
public class UserController {

    private static final String USER_FORM = "userForm";
    private static final String REDIRECT_USER = "login";

    @Autowired
    private UserService userService;

    /**
     * 获取创建 User 表单
     */
    @GetMapping("/create")
    public String createUserForm(ModelMap map) {
        map.addAttribute("user", new User());
        map.addAttribute("action", "create");
        return USER_FORM;
    }
    /**
     * 新建 User，返回login界面
     */
    @PostMapping("/create")
    public String postUser(@ModelAttribute User user) {
        userService.insertByUser(user);
        return REDIRECT_USER;
    }
}
