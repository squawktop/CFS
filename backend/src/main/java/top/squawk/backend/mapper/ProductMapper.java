package top.squawk.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.squawk.backend.pojo.Product;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
