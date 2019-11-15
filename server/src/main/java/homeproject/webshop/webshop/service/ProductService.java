package homeproject.webshop.webshop.service;

import homeproject.webshop.webshop.domain.Product;
import homeproject.webshop.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //TODO
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    //TODO //????
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
