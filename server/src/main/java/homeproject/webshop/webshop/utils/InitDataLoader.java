package homeproject.webshop.webshop.utils;

import homeproject.webshop.webshop.domain.Cart;
import homeproject.webshop.webshop.domain.Product;
import homeproject.webshop.webshop.domain.ProductCategories;
import homeproject.webshop.webshop.domain.WebShopUser;
import homeproject.webshop.webshop.service.CartServiceImpl;
import homeproject.webshop.webshop.service.ProductServiceImpl;
import homeproject.webshop.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDataLoader implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private ProductServiceImpl productService;

    @Override
    public void run(String... args) throws Exception {

        WebShopUser user1 = new WebShopUser();
        Cart cart1 = new Cart();
        Product product1 = new Product();
        Product product2 = new Product();

        user1.setUserName("Peter");
        user1.setPassword("12345");
        user1.setDeleted(false);
        user1.setCart(cart1);

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

        userService.addUser(user1);
        cartService.addCart(cart1);
        productService.addProduct(product1);
        productService.addProduct(product2);

        cartService.addProductToCart(product1, cart1.getId());
        cartService.addProductToCart(product2, cart1.getId());
    }

}
