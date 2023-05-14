package fr.momozer.test.alten.shopBackend.shopBackend.repository;

import fr.momozer.test.alten.shopBackend.shopBackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    boolean existsById(Long id);

    Product save(Product entity);

    Optional<Product> findById(Long id);

    void deleteById(Long id);
}
