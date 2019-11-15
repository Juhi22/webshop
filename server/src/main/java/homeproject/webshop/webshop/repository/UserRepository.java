package homeproject.webshop.webshop.repository;

import homeproject.webshop.webshop.domain.WebShopUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<WebShopUser, Long> {

    public WebShopUser findByUserName(String userName);

    public WebShopUser findByPassword(String password);

}
