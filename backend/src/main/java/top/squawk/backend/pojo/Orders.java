package top.squawk.backend.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @TableId(type = IdType.AUTO)
    private Integer orderId;
    private Integer productId;
    private Integer purchaseQuantity;
    private Double cost;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date submittime;
    private Integer userId;
    private Integer orderstatusId;
    private Integer paywayId;

}
