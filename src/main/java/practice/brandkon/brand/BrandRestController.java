package practice.brandkon.brand;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandRestController {

    @GetMapping
    public List<BrandResponseDto> findAll() {
        return List.of();
    }


}
