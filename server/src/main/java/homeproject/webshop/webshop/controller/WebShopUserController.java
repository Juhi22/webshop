package homeproject.webshop.webshop.controller;

import homeproject.webshop.webshop.domain.WebShopUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

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
     * Log in user
     *
     * @param user A user with given username and password
     * @return If user exists return user
     */
    WebShopUser login(@RequestBody WebShopUser user);

}
