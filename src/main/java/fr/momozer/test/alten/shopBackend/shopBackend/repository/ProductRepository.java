package fr.momozer.test.alten.shopBackend.shopBackend.repository;

import fr.momozer.test.alten.shopBackend.shopBackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
