package homeproject.webshop.webshop.service;

import homeproject.webshop.webshop.domain.WebShopUser;

import java.util.List;

public interface UserService {

    WebShopUser addUser(WebShopUser user);

    List<WebShopUser> getAllUser();

    WebShopUser deleteUser(Long id);

}
