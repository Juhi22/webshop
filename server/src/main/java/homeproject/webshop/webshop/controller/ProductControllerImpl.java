package homeproject.webshop.webshop.controller;

import homeproject.webshop.webshop.domain.Product;
import homeproject.webshop.webshop.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Override
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @Override
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Override
    @PostMapping("/addNewRating/{id}/{rating}")
    public ResponseEntity<Product> addNewRating(@PathVariable Long id, @PathVariable Integer rating) {
        return ResponseEntity.ok(productService.addNewRating(id, rating));
    }

    @Override
    @PostMapping("/postComment/{productId}/{userId}")
    public ResponseEntity<Product> postComment(@RequestParam(value = "text") String text,@PathVariable Long productId,@PathVariable Long userId) {
        return ResponseEntity.ok(productService.postComment(text, productId, userId));
    }

}
