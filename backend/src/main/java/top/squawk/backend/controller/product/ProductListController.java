package top.squawk.backend.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.squawk.backend.pojo.Product;
import top.squawk.backend.service.impl.product.ProductListServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
public class ProductListController {
    @Autowired
    private ProductListServiceImpl productListService ;

    @GetMapping("/api/product/getlist/")
    public Map<String, List<Product>> getlist(){

        return productListService.getList();
    }
}
