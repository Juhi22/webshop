package homeproject.webshop.webshop.repository;

import homeproject.webshop.webshop.domain.WebShopUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<WebShopUser, Long> {

    //TODO auth
    WebShopUser findByUserName(String userName);

    //TODO auth
    WebShopUser findByPassword(String password);

}
