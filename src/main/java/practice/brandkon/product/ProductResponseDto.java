package practice.brandkon.product;

public record ProductResponseDto(
        long productId,
        String imageUrl,
        long price,
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
