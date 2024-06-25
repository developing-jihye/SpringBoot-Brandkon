package practice.brandkon.product;

public record ProductDetailResponseDto(
        long productId,
        String productName,
        long brandId,
        String brandName,
        long price,
        int expiryDate
) {
}
