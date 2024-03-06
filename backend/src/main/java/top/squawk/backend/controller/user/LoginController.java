package top.squawk.backend.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.squawk.backend.service.user.LoginService;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    //登录操作 ， 一般是post请求 ， post是看不到明文的，get是在url呈现
    @PostMapping("/api/user/account/token/")            //这里定义完之后要去放行，公开化
    public Map<String, String> getToken(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        return loginService.getToken(username, password);
    }
}
