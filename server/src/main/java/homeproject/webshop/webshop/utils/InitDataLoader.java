package homeproject.webshop.webshop.utils;

import homeproject.webshop.webshop.domain.Cart;
import homeproject.webshop.webshop.domain.Product;
import homeproject.webshop.webshop.domain.ProductCategories;
import homeproject.webshop.webshop.domain.WebShopUser;
import homeproject.webshop.webshop.repository.CartRepository;
import homeproject.webshop.webshop.repository.ProductRepository;
import homeproject.webshop.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitDataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository webShopUserRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        WebShopUser user1 = new WebShopUser();
        Cart cart1 = new Cart();
        Product product1 = new Product();
        Product product2 = new Product();

        user1.setUserName("Peter");
        user1.setPassword("12345");
        user1.setDeleted(false);

        product1.setName("cheese");
        product1.setCategory(ProductCategories.FOOD);
        product1.setQuantity(30);
        product1.setDescription("dairy product");
        product1.setPrice(100.0);

        product2.setName("lego");
        product2.setCategory(ProductCategories.TOYS);
        product2.setQuantity(15);
        product2.setDescription("block game for kids and adults");
        product2.setPrice(2000.0);

        user1.setCart(cart1);

        webShopUserRepository.save(user1);

        productRepository.save(product1);
        productRepository.save(product2);

        cart1.getProducts().add(product1);
        cart1.getProducts().add(product2);

        webShopUserRepository.save(user1);
    }

}
