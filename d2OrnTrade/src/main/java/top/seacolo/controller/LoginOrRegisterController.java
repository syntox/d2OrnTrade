package top.seacolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.seacolo.service.impl.LoginOrRegisterServiceImpl;

@Controller
@RequestMapping("/")
public class LoginOrRegisterController {
    @Autowired
    private LoginOrRegisterServiceImpl loginOrRegisterService;


}
