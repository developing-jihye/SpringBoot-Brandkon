package practice.brandkon.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    ProductService productService;
    ProductMapper productMapper;

    public ProductRestController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    // Get /products?sort=POPULAR
    // Get /products?brandId=23&sort=POPULAR
    // GET /products?categoryd=6&sort=POPULAR
    @GetMapping
    public List<ProductResponseDto> findAll(
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String sort) {

        return productService.findAll(brandId, categoryId, sort);
    }

    @GetMapping("/{id}")
    public ProductDetailResponseDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/mybatis")
    public List<ProductResponseDto> findAllMybatis(
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String sort
            ) {
        return productService.findAllMybatis(brandId, categoryId, sort);
    }

}
