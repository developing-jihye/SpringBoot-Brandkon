package practice.brandkon.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private final ProductRepository productRepository;
    // 의존성 주입: 생성자 주입(이것만 사용함)
    // 생성자를 통해 외부에서 만든 오브젝트를 주입받는 것.
    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductResponseDto> findAll() {
        return productRepository.findAll()
                .stream().map(product -> ProductResponseDto.of(product)).toList();
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
