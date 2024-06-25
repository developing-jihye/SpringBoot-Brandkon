package practice.brandkon.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

    @GetMapping
    public List<CategoryResponseDto> findAll() {
        return List.of();
    }
}
