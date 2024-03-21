package top.squawk.backend.Test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.squawk.backend.mapper.OrdersMapper;

public class test {

    @Autowired
    private OrdersMapper orderMapper ;
    @Test
    public void demo(){
        System.out.println("hello world");
    }
}
