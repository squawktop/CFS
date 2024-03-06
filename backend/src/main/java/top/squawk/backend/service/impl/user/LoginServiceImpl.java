package top.squawk.backend.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import top.squawk.backend.mapper.UserMapper;
import top.squawk.backend.pojo.User;
import top.squawk.backend.service.impl.utils.UserDetailsImpl;
import top.squawk.backend.service.user.LoginService;
import top.squawk.backend.utils.JwtUtil;

import java.util.HashMap;
import java.util.Map;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, String> getToken(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);  //登陆失败，会自动处理

        UserDetailsImpl loginUser = (UserDetailsImpl)authenticate.getPrincipal() ;

        User user = loginUser.getUser();

        String jwt = JwtUtil.createJWT(user.getId().toString());    //将userid 封装成 Jwt token


        Map<String , String > map = new HashMap<>() ;
        map.put("error_message","success") ;
        map.put("token",jwt) ;

        return map;
    }
}