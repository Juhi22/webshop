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
    @PostMapping("/addNewRating")
    public ResponseEntity<Product> addNewRating(@RequestBody Product product, @PathVariable Integer rating) {
        return ResponseEntity.ok(productService.addNewRating(product, rating));
    }

}
