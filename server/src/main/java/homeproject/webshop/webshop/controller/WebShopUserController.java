package homeproject.webshop.webshop.controller;

import homeproject.webshop.webshop.domain.WebShopUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WebShopUserController {

    /**
     * Add a user
     *
     * @param user Added user
     * @return ResponseEntity<WebShopUser>
     */
    ResponseEntity<WebShopUser> addUser(WebShopUser user);

    /**
     * Get all users
     *
     * @return ResponseEntity<List<WebShopUser>>
     */
    ResponseEntity<List<WebShopUser>> getAllUsers();

    /**
     * Delete a user
     *
     * @param id Id of the user
     * @return ResponseEntity<WebShopUser>
     */
    ResponseEntity<WebShopUser> deleteUser(Long id);

    /**
     *Login to webshop
     *
     * @param user Webshop user
     * @return The user if it exists else return null
     */
    ResponseEntity<WebSHopUser> login(WebShopUser user);

}
