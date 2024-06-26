package practice.brandkon.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBrandId(Long brandId);
    List<Product> findAllByBrandIdOrderBySalesDesc(Long brandId);
    List<Product> findAllByCategoryId(Long categoryId);
    List<Product> findAllByCategoryIdOrderBySalesDesc(Long categoryId);
    List<Product> findAllByOrderBySalesDesc();
    List<Product> findAll();
}
