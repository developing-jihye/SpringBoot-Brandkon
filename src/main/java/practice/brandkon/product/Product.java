package practice.brandkon.product;

import jakarta.persistence.*;
import practice.brandkon.brand.Brand;
import practice.brandkon.category.Category;

import java.time.OffsetDateTime;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String name;

    @Column(nullable = false)
    private Long price;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Category category;

    private int expiryDate;

    private Long sales;

    // getter

    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getExpiryDate() {
        return expiryDate;
    }
}

