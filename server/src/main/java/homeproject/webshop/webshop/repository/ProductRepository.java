package homeproject.webshop.webshop.repository;

import homeproject.webshop.webshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
