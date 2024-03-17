package top.squawk.backend.service.user;

import top.squawk.backend.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserListService {
    public Map<String , List<UserInfo>> getList();
}
