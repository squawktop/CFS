package top.squawk.backend.service.impl.order.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    private String username ;
    private Integer orderId ;
    private String product ;
    private Integer cost ;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date submittime ;
    private String address ;
    private Integer status ;
    private String payway ;
}
