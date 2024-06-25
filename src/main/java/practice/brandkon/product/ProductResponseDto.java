package practice.brandkon.product;

public record ProductResponseDto(
        long productId,
        String imageUrl,
        long price,
        String productName,
        String brandName
) {
}
