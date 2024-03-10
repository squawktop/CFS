package top.squawk.backend.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.squawk.backend.service.user.UpdateService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UpdateUserController {

    @Autowired
    private UpdateService updateService;


    @PostMapping("/api/user/account/update/")
    public Map<String, String> update(@RequestParam Map<String, String> data) {
         return updateService.update(data) ;

    }
}
