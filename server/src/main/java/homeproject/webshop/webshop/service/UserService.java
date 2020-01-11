package homeproject.webshop.webshop.service;

import homeproject.webshop.webshop.domain.WebShopUser;

import java.util.List;

public interface UserService {

    /**
     * Add a user
     *
     * @param user Added user
     * @return ResponseEntity<WebShopUser>
     */
    WebShopUser addUser(WebShopUser user);

    /**
     * Get all users
     *
     * @return ResponseEntity<List<WebShopUser>>
     */
    List<WebShopUser> getAllUser();

    /**
     * Delete a user
     *
     * @param id Id of the user
     * @return ResponseEntity<WebShopUser>
     */
    WebShopUser deleteUser(Long id);

    /**
     *Login to webshop
     *
     * @param user Webshop user
     * @return The user if it exists else return null
     */
    WebShopUser isUserExists(WebShopUser user);

    /**
     * Register an user
     *
     * @param user User which is wanted to be registered
     * @return If success return the user
     */
    WebShopUser registration(WebShopUser user);

}
