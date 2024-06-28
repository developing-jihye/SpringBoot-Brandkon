package practice.brandkon.product;

public record ProductResponseDto(
        Long productId,
        String imageUrl,
        Long price,
        String productName,
        String brandName
) {

    static ProductResponseDto of(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getImageUrl(),
                product.getPrice(),
                product.getName(),
                product.getBrand().getName()
        );
    }
}
