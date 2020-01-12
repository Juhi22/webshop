package homeproject.webshop.webshop.service;

import homeproject.webshop.webshop.domain.Cart;
import homeproject.webshop.webshop.domain.Comment;
import homeproject.webshop.webshop.domain.Product;
import homeproject.webshop.webshop.domain.WebShopUser;
import homeproject.webshop.webshop.repository.CartRepository;
import homeproject.webshop.webshop.repository.CommentRepository;
import homeproject.webshop.webshop.repository.ProductRepository;
import homeproject.webshop.webshop.repository.UserRepository;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    private CommentRepository commentRepository;

    private UserRepository userRepository;

    private CartRepository cartRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CommentRepository commentRepository, UserRepository userRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        try {
            return productRepository.findById(id).get();
        } catch (NullPointerException exception) {
            throw new NullPointerException();
        }
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

    @Override
    public Product postComment(String text, Long productId, Long userId) {
        Product recentProduct = null;
        WebShopUser recentUser;
        Comment comment = new Comment();
        comment.setText(text);
        if(userRepository.findById(userId).isPresent()){
            recentUser = userRepository.findById(userId).get();
            comment.setUserName(recentUser.getUserName());
        }
        if(productRepository.findById(productId).isPresent()){
            recentProduct = productRepository.findById(productId).get();
            recentProduct.getComments().add(comment);
        }
        commentRepository.save(comment);
        productRepository.save(recentProduct);
        return recentProduct;
    }

    @Override
    public void removeProduct(Long userId, Long productId) {
        if(cartRepository.findById(userId).isPresent() && productRepository.findById(productId).isPresent()) {
            Cart cart = cartRepository.findById(userId).get();
            Product product = productRepository.findById(productId).get();
            cart.getProducts().remove(product);
            cartRepository.save(cart);
        }
    }
}
