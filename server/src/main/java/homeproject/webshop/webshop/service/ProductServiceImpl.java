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
    public Product addNewRating(Long id, Integer rating) {
        Product recentProduct = null;
        if(productRepository.findById(id).isPresent()){
            recentProduct = productRepository.findById(id).get();
            recentProduct.getRatings().add(rating);
            recentProduct.setRating(recentProduct.getRatings().stream().mapToInt(rate -> rate).summaryStatistics().getAverage());
            productRepository.save(recentProduct);
        }
        return recentProduct;
    }

}
