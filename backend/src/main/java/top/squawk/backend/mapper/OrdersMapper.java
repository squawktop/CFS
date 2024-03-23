package top.squawk.backend.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import top.squawk.backend.pojo.Orders;
import top.squawk.backend.service.impl.order.utils.Order;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    @Select("select userinfo.name username,order_id,product.name product, cost , submittime,address,orderstatus_id,payway_id from user,orders,product,userinfo where user.id = orders.user_id and user.id = userinfo.user_id and orders.product_id = product.product_id")
    @Results({
            @Result(column="username", property="username"),
            @Result(column="product", property="product"),
            @Result(column="orderstatus_id", property="status"),
            @Result(column="payway_id", property="payway"),
    })
    List<Order> selectOrderList() ;
}

