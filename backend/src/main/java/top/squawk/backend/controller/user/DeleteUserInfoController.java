package top.squawk.backend.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.squawk.backend.service.user.DeleteUserInfoService;

import java.util.Map;

@RestController
public class DeleteUserInfoController {
    @Autowired
    private DeleteUserInfoService deleteUserInfoService ;


    @PostMapping("/api/user/account/deleteuserinfo/")
    public Map<String,String> deleteUserInfo(@RequestParam int id){
        return deleteUserInfoService.deleteUser(id);
    }
}
