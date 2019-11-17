package homeproject.webshop.webshop.service;

import homeproject.webshop.webshop.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * Add a product
     *
     * @param product Added product
     * @return Product
     */
    Product addProduct(Product product);

    /**
     * Get all products
     *
     * @return List<Products>
     */
    List<Product> getAllProducts();

    /**
     * Add rating to product
     *
     * @param id Id of rated product
     * @param rating Given rating to product
     * @return Product
     */
    Product addNewRating(Long id, Integer rating);

}
