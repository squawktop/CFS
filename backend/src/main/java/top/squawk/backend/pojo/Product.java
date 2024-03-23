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
public class Product {
    @TableId(type = IdType.AUTO)        //注解实现Id自增，该注解来自 Mybatis-plus
    private Integer productId;
    private String name;
    private String brand;
    private String size;
    private String color;
    private String season;
    private String style;
    private String cloth;
    private Integer amount;
    private Float price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date uptime;
    private String description;
    private String image;
    private int providerId;
    private int categoryId;
}
