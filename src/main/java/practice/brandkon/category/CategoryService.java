package practice.brandkon.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponseDto> findAll() {

        return categoryRepository.findAll()
                .stream().map(category -> new CategoryResponseDto(
                        category.getId(),
                        category.getImageUrl(),
                        category.getName()
                )).toList();
    }
}
