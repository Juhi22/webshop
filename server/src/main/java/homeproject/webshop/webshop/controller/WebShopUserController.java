package homeproject.webshop.webshop.controller;

import homeproject.webshop.webshop.domain.WebShopUser;
import homeproject.webshop.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class WebShopUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<WebShopUser> addUser(@RequestBody WebShopUser user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<WebShopUser>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/deleteUser/{id}")
    public ResponseEntity<WebShopUser> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PostMapping("/login")
    public boolean login(@RequestBody WebShopUser user) {
        return userService.isUserExists(user);
    }
}
