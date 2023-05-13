package fr.momozer.test.alten.shopBackend.shopBackend.repository;

import fr.momozer.test.alten.shopBackend.shopBackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
