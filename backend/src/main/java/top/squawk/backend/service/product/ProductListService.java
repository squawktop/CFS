package top.squawk.backend.service.product;

import top.squawk.backend.pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductListService {
    public Map<String , List<Product>> getList();
}
