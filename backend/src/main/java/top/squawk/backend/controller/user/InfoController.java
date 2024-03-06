package top.squawk.backend.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.squawk.backend.service.user.InfoService;

import java.util.Map;

@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping("/api/user/account/info/")//得到信息， 获取信息一般是Get
    public Map<String, String> getinfo() {
        return infoService.getinfo();
    }

}
