package homeproject.webshop.webshop.controller;

import homeproject.webshop.webshop.domain.WebShopUser;
import homeproject.webshop.webshop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class WebShopUserControllerImpl implements WebShopUserController{

    @Autowired
    private UserServiceImpl userService;

    @Override
    @PostMapping("/addUser")
    public ResponseEntity<WebShopUser> addUser(@RequestBody WebShopUser user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @Override
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<WebShopUser>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @Override
    @GetMapping("/deleteUser/{id}")
    public ResponseEntity<WebShopUser> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    //TODO auth
    @Override
    @PostMapping("/login")
    public WebShopUser login(@RequestBody WebShopUser user) {
        return userService.isUserExists(user);
    }

    @Override
    @PostMapping("/registration")
    public WebShopUser registration(@RequestBody WebShopUser user) {
        return userService.registration(user);
    }
}
