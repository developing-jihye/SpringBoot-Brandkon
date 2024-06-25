package practice.brandkon.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @GetMapping
    public List<ProductResponseDto> findAll() {
        return List.of();
    }

    @GetMapping("/{id}")
    public ProductDetailResponseDto findById(@PathVariable Long id) {
        return new ProductDetailResponseDto(
                0L,
                "",
                0L,
                "",
                0L,
                0
        );
    }

}
