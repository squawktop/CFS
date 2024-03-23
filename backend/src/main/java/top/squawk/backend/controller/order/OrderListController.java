package top.squawk.backend.controller.order;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.squawk.backend.service.impl.order.utils.Order;
import top.squawk.backend.service.order.OrderListService;

import java.util.List;
import java.util.Map;

@RestController
public class OrderListController {

    @Autowired
    private OrderListService orderListService ;

    @GetMapping("/api/order/getlist/")
    public List<Order> getlist(){user
        return orderListService.getlist();
    }
}
