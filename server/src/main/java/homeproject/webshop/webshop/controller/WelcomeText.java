package homeproject.webshop.webshop.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeText {

    //TODO WRITE DESCRIPTION TO EVERYWHERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    @RequestMapping("/")
    @Secured("ROLE_ADMIN")
    public String welcomeText(){
        return "szia hello őőőőőőőőőőőőőőőőőőőőőőőőőőőőőőőőőőőőőő";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "szia hello hello hello hello";
    }

}
