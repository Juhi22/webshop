package homeproject.webshop.webshop.service;

import homeproject.webshop.webshop.domain.Cart;
import homeproject.webshop.webshop.domain.Product;
import homeproject.webshop.webshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addCart(Cart cart){
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    @Override
    public Cart addProductToCart(Product product, Long id){
        if(cartRepository.findById(id).isPresent()) {
            cartRepository.findById(id).get().getProducts().add(product);
        }
        return cartRepository.findById(id).get();
    }
}
