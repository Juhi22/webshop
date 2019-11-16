package homeproject.webshop.webshop.controller;

import homeproject.webshop.webshop.domain.Cart;
import homeproject.webshop.webshop.domain.Product;
import homeproject.webshop.webshop.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartControllerImpl implements CartController {

    @Autowired
    private CartServiceImpl cartService;

    @Override
    @PostMapping("/addCart")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.addCart(cart));
    }

    @Override
    @GetMapping("/getAllCarts")
    public ResponseEntity<List<Cart>> getAllCarts(){
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @Override
    @PostMapping("/addProductToCart/{id}")
    public ResponseEntity<Cart> addProductToCart(@RequestBody Product product,@PathVariable Long id){
        return ResponseEntity.ok(cartService.addProductToCart(product, id));
    }

}
