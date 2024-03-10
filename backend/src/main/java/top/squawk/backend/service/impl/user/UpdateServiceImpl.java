package top.squawk.backend.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import top.squawk.backend.mapper.UserInfoMapper;
import top.squawk.backend.pojo.User;
import top.squawk.backend.pojo.UserInfo;
import top.squawk.backend.service.impl.utils.UserDetailsImpl;
import top.squawk.backend.service.user.UpdateService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Map<String, String> update(Map<String, String> data) {
        //授权成功 ， 会从上下文当中将我们的信息提取出来
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();

        Integer userId = user.getId();
        String name = data.get("name");
        String sex = "0".equals(data.get("sex")) ? "男" : "女";
        String fullAddress = data.get("province") + data.get("city") + data.get("area") + data.get("address");
        String email = data.get("email");
        String phone = data.get("phone");
        String zipcode = data.get("zipcode");

        UserInfo u = new UserInfo(user.getId(), name, sex, fullAddress, email, zipcode, phone, 0, 0);


        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>() ;
        queryWrapper.eq("user_id" ,userId );


        List<UserInfo> userInfoList = userInfoMapper.selectList(queryWrapper);

        Map<String, String> resp = new HashMap<>();

        if( !userInfoList.isEmpty()){
            userInfoMapper.update(u,queryWrapper) ;
            resp.put("error_message" , "success") ;
            return resp;
        }else{
            userInfoMapper.insert(u) ;
        }

        resp.put("error_message" , "error") ;
        return resp;


    }
}
