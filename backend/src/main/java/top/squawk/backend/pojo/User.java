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
public class User {
    @TableId(type = IdType.AUTO)        //注解实现Id自增，该注解来自 Mybatis-plus
    private Integer id ;
    private String username ;
    private String password ;
    private String nickname ;
    private String phone ;
    private String picture ;
    private String email ;
    private String description ;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime ;
    private int state ;
    private String keyCode ;
    private int scale ;
}
