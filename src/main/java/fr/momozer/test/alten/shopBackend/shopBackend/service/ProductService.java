package fr.momozer.test.alten.shopBackend.shopBackend.service;

import fr.momozer.test.alten.shopBackend.shopBackend.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    /**
     * Récupère tous les produits
     * @return la liste de tous les produits
     */
    List<Product> findAll();

    /**
     * Crée un nouveau produit
     * @param entity les infos du produit à créer
     * @return le produit sauvegardé
     */
    Product save(Product entity);

    /**
     * Met à jour les informations d'un produit
     * @param product les informations du produit à modifier
     * @return le produit modifié
     */
    Product update(Product product);

    /**
     * Recherche un produit par son id.
     * Si aucun produit n'est trouvé, retourne un 404
     * @param id l'id du produit à trouver
     * @return le produit trouvé
     */
    Product findById(Long id);

    /**
     * Recherche un produit par son name.
     * @param name du produit à rechercher
     * @return le produit correspondant au nom
     */
    Optional<Product> findByName(String name);

    /**
     * Supprime un produit par son id
     * @param id l'id du produit à supprimer
     */
    void deleteById(Long id);
}
