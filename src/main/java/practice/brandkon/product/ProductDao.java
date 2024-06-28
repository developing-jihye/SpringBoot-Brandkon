package practice.brandkon.product;

public record ProductDao(
        Long id,
        String imageUrl,
        String name,
        Long price,
        String brandName
) {
}
