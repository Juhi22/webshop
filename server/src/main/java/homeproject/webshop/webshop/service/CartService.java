package homeproject.webshop.webshop.service;

import homeproject.webshop.webshop.domain.Cart;
import homeproject.webshop.webshop.domain.Product;
import homeproject.webshop.webshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    //TODO all null etc...
    public Cart addCart(Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    public Cart addProductToCart(Product product, Long id){
        if(cartRepository.findById(id).isPresent()) {
            cartRepository.findById(id).get().getProducts().add(product);
        }
        return cartRepository.findById(id).get();
    }
}
