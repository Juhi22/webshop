package homeproject.webshop.webshop.controller;

import homeproject.webshop.webshop.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

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
     * Get a product by its id.
     *
     * @param id Id of the product
     * @return {@link Product}
     */
    Product getProduct(Long id);

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

    /**
     * Post a comment to the product
     *
     * @param text Commented text
     * @param productId Id of product
     * @param userId Id of user
     * @return ResponseEntity<Product>
     */
    ResponseEntity<Product> postComment(String text, Long productId, Long userId);

    /**
     * Remove given product from the cart of the given user
     *
     * @param userId Id of the user
     * @param productId Id of the product
     */
    void removeProduct(Long userId, Long productId);
}
