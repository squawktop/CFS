package top.squawk.backend.controller.order;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.squawk.backend.service.order.OrderListService;

import java.util.Map;

@RestController
public class OrderListController {

    @Autowired
    private OrderListService orderListService ;

    @GetMapping("/api/order/getlist/")
    public JSONObject getlist(){

        return orderListService.getlist();
    }
}
