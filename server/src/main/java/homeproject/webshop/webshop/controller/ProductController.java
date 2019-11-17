package homeproject.webshop.webshop.controller;

import homeproject.webshop.webshop.domain.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {

    /**
     * Add a product
     *
     * @param product Added product
     * @return ResponseEntity<Product>
     */
    ResponseEntity<Product> addProduct(Product product);

    /**
     * Get all products
     *
     * @return ResponseEntity<List<Product>>
     */
    ResponseEntity<List<Product>> getAllProducts();

    /**
     * Add rating to product
     *
     * @param id Id of rated product
     * @param rate Given rating to product
     * @return ResponseEntity<Product>
     */
    ResponseEntity<Product> addNewRating(Long id, Integer rate);
}
