package top.squawk.backend.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.squawk.backend.mapper.UserInfoMapper;
import top.squawk.backend.pojo.UserInfo;
import top.squawk.backend.service.user.UserListService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserListServiceImpl implements UserListService {
    @Autowired
    private UserInfoMapper userInfoMapper ;

    @Override
    public Map<String, List<UserInfo>> getList() {
        Map<String , List<UserInfo>> resp = new HashMap<>();

        List<UserInfo> userInfoList = userInfoMapper.selectList(null);

        resp.put("result" , userInfoList);

        return resp ;

    }
}
