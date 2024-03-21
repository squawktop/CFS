package top.squawk.backend.service.impl.order;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.squawk.backend.mapper.OrdersMapper;
import top.squawk.backend.mapper.ProductMapper;
import top.squawk.backend.mapper.UserInfoMapper;
import top.squawk.backend.pojo.Orders;
import top.squawk.backend.pojo.Product;
import top.squawk.backend.pojo.UserInfo;
import top.squawk.backend.service.impl.order.utils.Order;
import top.squawk.backend.service.order.OrderListService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OrderListServiceImpl implements OrderListService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public JSONObject getlist() {
        JSONObject resp = new JSONObject();

        List<Orders> orders = ordersMapper.selectList(null);



        List<Order> orderlist = new ArrayList<>();
        Order order = null;

        for (Orders o : orders) {
            QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>() ;
            userInfoQueryWrapper.eq("user_id" ,o.getUserId() );
            UserInfo userInfo = userInfoMapper.selectOne(userInfoQueryWrapper);

            String username = userInfo.getName();
            Integer orderId = o.getOrderId();

            QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("product_id", o.getProductId());
            String product = productMapper.selectOne(queryWrapper).getName();
            Date submittime = o.getSubmittime();
            String address = userInfo.getAddress();
            Integer statusId = o.getOrderstatusId();
            String paywayId = o.getPaywayId().toString();
            order = new Order(
                    username,
                    orderId,
                    product,
                    submittime,
                    address,
                    statusId,
                    paywayId
            );
            orderlist.add(order);
        }


        resp.put("result", orderlist);

        return resp;
    }
}
