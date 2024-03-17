package top.squawk.backend.service.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.squawk.backend.mapper.ProductMapper;
import top.squawk.backend.pojo.Product;
import top.squawk.backend.service.product.ProductListService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductListServiceImpl implements ProductListService {

    @Autowired
    private ProductMapper productMapper ;
    @Override
    public Map<String, List<Product>> getList() {

        Map<String, List<Product>> resp  = new HashMap<>() ;
        resp.put("result" ,productMapper.selectList(null) ) ;

        return resp;
    }
}
