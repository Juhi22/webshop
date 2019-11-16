package homeproject.webshop.webshop.service;

import homeproject.webshop.webshop.domain.Cart;
import homeproject.webshop.webshop.domain.Product;

import java.util.List;

public interface CartService {

    /**
     * Add a cart
     *
     * @param cart Added cart
     * @return Cart
     */
    Cart addCart(Cart cart);

    /**
     * Get all carts
     *
     * @return List<Cart>
     */
    List<Cart> getAllCarts();

    /**
     * Add product to cart
     *
     * @param product Added product
     * @param id Id of the cart
     * @return Cart
     */
    Cart addProductToCart(Product product, Long id);
}
