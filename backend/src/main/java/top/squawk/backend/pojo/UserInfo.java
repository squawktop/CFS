package top.squawk.backend.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@TableName("userinfo")
public class UserInfo {


    private int userId;
    private String name;
    private String sex;
    private String address;
    private String email;
    private String zipcode;
    private String phone;
    private int provinceId;
    private int countryId;

}
