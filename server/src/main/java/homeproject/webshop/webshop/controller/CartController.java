package homeproject.webshop.webshop.controller;

import homeproject.webshop.webshop.domain.Cart;
import homeproject.webshop.webshop.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CartController {

    /**
     * Add a cart
     *
     * @param cart Added cart
     * @return ResponseEntity<Cart>
     */
    ResponseEntity<Cart> addCart(Cart cart);

    /**
     * Get all existing carts
     *
     * @return ResponseEntity<List<Cart>>
     */
    ResponseEntity<List<Cart>> getAllCarts();

    /**
     * Add a product to the cart
     *
     * @param product Added product
     * @param id Id of the cart
     * @return ResponseEntity<Cart>
     */
    ResponseEntity<Cart> addProductToCart(Product product, Long id);
}
