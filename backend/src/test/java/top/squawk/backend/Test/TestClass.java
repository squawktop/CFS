package top.squawk.backend.Test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.squawk.backend.mapper.OrdersMapper;
import top.squawk.backend.mapper.UserMapper;
import top.squawk.backend.pojo.Orders;
import top.squawk.backend.service.impl.order.utils.Order;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestClass {


    @Autowired
    private OrdersMapper orderMapper;


    @Test
    public void demo() {
        List<Order> orderList = orderMapper.selectOrderList();

        for(Order order : orderList){
            System.out.println(order);
        }



    }
}
