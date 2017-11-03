package top.seacolo.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.seacolo.dao.UserLoginAndRegisterDao;
import top.seacolo.service.impl.LoginOrRegisterServiceImpl;
import top.seacolo.util.ReturnSty;

public class UserServiceTest extends BaseTest{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserLoginAndRegisterDao userLoginAndRegisterDao;
    @Autowired
    private LoginOrRegisterServiceImpl loginOrRegisterServiceImpl;

    @Test
    public void insertUser() {
        ReturnSty returnSty = loginOrRegisterServiceImpl.registerByMail("aa","123","123");
        if(returnSty.getRetCode().equals("666")){
            System.out.println("success");
        }else {
            System.out.println("fail");
        }
    }
}
