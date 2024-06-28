package practice.brandkon.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    // 의존성 주입: 생성자 주입(이것만 사용함)
    // 생성자를 통해 외부에서 만든 오브젝트를 주입받는 것.


    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    // 메서드
    public List<ProductResponseDto> findAll(Long brandId, Long categoryId, String sort) {

        List<Product> products = productRepository.findAll();

        if(brandId != null) {
            if(sort.equals("POPULAR")) {
                products = productRepository.findAllByBrandIdOrderBySalesDesc(brandId);
            } else {
                products = productRepository.findAllByBrandId(brandId);
            }
        } else if (categoryId != null) {
            if(sort.equals("POPULAR")) {
                products  = productRepository.findAllByCategoryIdOrderBySalesDesc(categoryId);
            } else {
                products = productRepository.findAllByCategoryId(categoryId);
            }
        } else {
            if(sort.equals("POPULAR")) {
                products = productRepository.findAllByOrderBySalesDesc();
            } else {
                products = productRepository.findAll();
            }
        }

        return products
                .stream().map(product -> ProductResponseDto.of(product))
                .toList();
    }

    // 메서드
    public ProductDetailResponseDto findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 아이디의 상품을 찾을 수 없습니다."));

        ProductDetailResponseDto productDetailResponseDto = new ProductDetailResponseDto(
                product.getId(),
                product.getName(),
                product.getBrand().getId(),
                product.getBrand().getName(),
                product.getPrice(),
                product.getExpiryDate()
        );

        return productDetailResponseDto;
    }

    public List<ProductResponseDto> findAllMybatis(Long brandId, Long categoryId, String sort) {
        return productMapper.findAllMybatis(brandId, categoryId, sort);
    }
}
