package homeproject.webshop.webshop.service;

import homeproject.webshop.webshop.domain.WebShopUser;
import homeproject.webshop.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public WebShopUser addUser(WebShopUser user){
        return userRepository.save(user);
    }

    public List<WebShopUser> getAllUser() {
        return userRepository.findAll();
    }

    public WebShopUser deleteUser(Long id){
        WebShopUser user = userRepository.findById(id).get();
        user.setDeleted(true);
        return userRepository.save(user);
    }

    public boolean isUserExists(WebShopUser user) {
        WebShopUser loginUser = userRepository.findByUserName(user.getUserName());
        if(loginUser == null) {
            return false;
        }
        if(loginUser.getPassword().equals(user.getPassword()) && !loginUser.isDeleted()){
            return true;
        }
        return false;
    }

}
