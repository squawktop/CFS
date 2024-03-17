package top.squawk.backend.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.squawk.backend.mapper.UserInfoMapper;
import top.squawk.backend.pojo.UserInfo;
import top.squawk.backend.service.user.DeleteUserInfoService;

import java.util.HashMap;
import java.util.Map;


@Service
public class DeleteUserInfoServiceImpl implements DeleteUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Map<String, String> deleteUser(int id) {
        Map<String, String> resp = new HashMap<>();
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        int row = userInfoMapper.delete(queryWrapper);

        if (row > 0) {
            resp.put("error_message", "success");
        } else {
            resp.put("error_message", "failed");
        }

        return resp;
    }
}
