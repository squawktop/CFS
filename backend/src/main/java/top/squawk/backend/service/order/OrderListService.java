package top.squawk.backend.service.order;

import com.alibaba.fastjson.JSONObject;
import top.squawk.backend.service.impl.order.utils.Order;

import java.util.List;
import java.util.Map;

public interface OrderListService {
    public List<Order> getlist();
}
