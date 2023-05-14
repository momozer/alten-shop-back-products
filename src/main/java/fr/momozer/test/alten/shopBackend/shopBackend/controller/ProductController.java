package fr.momozer.test.alten.shopBackend.shopBackend.controller;

import fr.momozer.test.alten.shopBackend.shopBackend.entity.Product;
import fr.momozer.test.alten.shopBackend.shopBackend.service.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("shopBackend/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    @Autowired
    private final ProductServiceImpl service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    /**
     * Récupère tous les produits
     *
     * @return la liste de tous les produits
     */
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Product> findAll() {
        return service.findAll();
    }

    /**
     * Crée un nouveau produit
     *
     * @param entity les infos du produit à créer
     * @return le produit sauvegardé
     */
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product save(@RequestBody Product entity) {
        return service.save(entity);
    }

    /**
     * Met à jour les informations d'un produit
     *
     * @param product les informations du produit à modifier
     * @return le produit modifié
     */
    @PatchMapping("/edit/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Product update(@RequestBody Product product, @PathVariable Long id) {
        if ( !id.equals(product.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not found.");
        }
        return this.service.update(product);
    }

    /**
     * Recherche un produit par son id.
     * Si aucun produit n'est trouvé, retourne un 404
     *
     * @param id l'id du produit à trouver
     * @return le produit trouvé
     */
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Product findById(@PathVariable Long id) {
        return service.findById(id);
    }

    /**
     * Recherche un produit par son name.
     *
     * @param name du produit à rechercher
     * @return le produit correspondant au nom
     */
    @GetMapping("/{name}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Optional<Product> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    /**
     * Supprime un produit par son id
     *
     * @param id l'id du produit à supprimer
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
