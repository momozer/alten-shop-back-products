package fr.momozer.test.alten.shopBackend.shopBackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Column(name = "code") @NotBlank
    private String code;


    @Column(name = "name") @NotBlank
    private String name;

    @Column(name = "description") @NotBlank
    private String description;

    @Column(name = "price") @NotNull
    private BigDecimal price;

    @Column(name = "quantity") @NotBlank
    private Long quantity;

    @Enumerated(EnumType.STRING) @NotBlank
    @Column(name = "inventory_status")
    private EInventoryStatus inventoryStatus;

    @Enumerated(EnumType.STRING) @NotBlank
    @Column(name = "category")
    private ECategory category;

    @Column(name = "image")
    private String image;

    @Column(name = "rating")
    @Min(0)
    @Max(10)
    //les @Min et @Max permettent de définir un système de notation. La plus petit valeur autorisée est 0 et la plus
    // grande 10
    private double rating;
}
