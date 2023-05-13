package fr.momozer.test.alten.shopBackend.shopBackend.service.serviceImpl;

import fr.momozer.test.alten.shopBackend.shopBackend.entity.Product;
import fr.momozer.test.alten.shopBackend.shopBackend.repository.ProductRepository;
import fr.momozer.test.alten.shopBackend.shopBackend.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(Product.class);
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Récupère tous les produits
     * @return la liste de tous les produits
     */
    public List<Product> findAll() {
        logger.info("Return all existing products");
        return repository.findAll();
    }

    /**
     * Crée un nouveau produit
     * @param entity les infos du produit à créer
     * @return le produit sauvegardé
     */
    public Product save(Product entity) {
        logger.info("Save a new product");
        return repository.save(entity);
    }

    /**
     * Met à jour les informations d'un produit
     * @param product les informations du produit à modifier
     * @return le produit modifié
     */
    public Product update(Product product) {
        if (!this.repository.existsById(product.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Product not found.");
        }
        logger.info("Update the product");
        return this.repository.save(product);
    }

    /**
     * Recherche un produit par son id.
     * Si aucun produit n'est trouvé, retourne un 404
     * @param id l'id du produit à trouver
     * @return le produit trouvé
     */
    public Product findById(Long id) {
        logger.info("Returns the product by his id");
        return repository.findById(id).orElseThrow(() -> {
            logger.warn("findByIdInvalid: " +id);
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    /**
     * Recherche un produit par son name.
     * @param name du produit à rechercher
     * @return le produit correspondant au nom
     */
    public Optional<Product> findByName(String name){
        logger.info("Returns the product by his name");
        return repository.findByName(name);
    }

    /**
     * Supprime un produit par son id
     * @param id l'id du produit à supprimer
     */
    public void deleteById(Long id) {
        logger.info("Delete the product by his id");
        repository.deleteById(id);
    }

}
