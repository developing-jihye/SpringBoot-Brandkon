package practice.brandkon.brand;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BrandService {

    public final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandResponseDto> findAll() {
        return brandRepository.findAll()
                .stream().map(brand -> new BrandResponseDto(
                        brand.getId(),
                        brand.getImageUrl(),
                        brand.getName()
                )).toList();
    }

    public List<BrandResponseDto> findAllByCategoryId(Long categoryId) {
        return brandRepository.findAllByCategoryId(categoryId)
                .stream().map(brand -> new BrandResponseDto(
                        brand.getId(),
                        brand.getImageUrl(),
                        brand.getName()
                )).toList();

    }

//    public List<BrandResponse> findAllByCategoryId(Long categoryId) {
//        return brandRepository.findAll()
//                .stream()
//                .filter(b -> b.getCategory().getId() == categoryId)
//                .map(b -> new BrandResponse(
//                        b.getId(),
//                        b.getImageUrl(),
//                        b.getName()))
//                .toList();
//    }
}
