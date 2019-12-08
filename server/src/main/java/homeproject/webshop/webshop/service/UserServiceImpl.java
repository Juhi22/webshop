package homeproject.webshop.webshop.service;

import homeproject.webshop.webshop.domain.WebShopUser;
import homeproject.webshop.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public WebShopUser addUser(WebShopUser user){

        return userRepository.save(user);
    }

    @Override
    public List<WebShopUser> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public WebShopUser deleteUser(Long id){
        WebShopUser user = null;
        if(userRepository.findById(id).isPresent()) {
            user = userRepository.findById(id).get();
            user.setDeleted(true);
            return userRepository.save(user);
        }
        return user;
    }

    //TODO auth
    @Override
    public WebShopUser isUserExists(WebShopUser user) {
        WebShopUser loginUser = userRepository.findByUserName(user.getUserName());
        if(loginUser.getPassword().equals(user.getPassword()) && !loginUser.isDeleted()) {
            return loginUser;
        }
        return null;
    }

}
