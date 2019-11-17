package homeproject.webshop.webshop.service;

import homeproject.webshop.webshop.domain.Product;
import homeproject.webshop.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product addNewRating(Product product, Integer rating) {
        Product recentProduct = null;
        if(productRepository.findById(product.getId()).isPresent()){
            recentProduct = productRepository.findById(product.getId()).get();
            recentProduct.getRatings().add(rating);
            recentProduct.setRating(recentProduct.getRatings().stream().mapToInt(rate -> rate).summaryStatistics().getAverage());
        }
        return recentProduct;
    }

}
