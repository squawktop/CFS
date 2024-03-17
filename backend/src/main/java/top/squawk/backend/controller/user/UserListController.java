package top.squawk.backend.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.squawk.backend.pojo.UserInfo;
import top.squawk.backend.service.user.UserListService;

import java.util.List;
import java.util.Map;

@RestController
public class UserListController {

    @Autowired
    private UserListService userListService ;

    @GetMapping("/api/user/account/getlist/")
    public Map<String, List<UserInfo>> getList() {
            return userListService.getList() ;
    }
}
