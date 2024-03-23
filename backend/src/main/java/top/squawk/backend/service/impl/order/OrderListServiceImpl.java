package top.squawk.backend.service.impl.order;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.squawk.backend.mapper.OrdersMapper;
import top.squawk.backend.service.impl.order.utils.Order;
import top.squawk.backend.service.order.OrderListService;

import java.util.List;


@Service
public class OrderListServiceImpl implements OrderListService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Order> getlist() {
        JSONObject resp = new JSONObject();

        List<Order> orderList = ordersMapper.selectOrderList();
        JSONArray jsonArray = new JSONArray(orderList);
        resp.put("result", jsonArray);

        return orderList;
    }
}
