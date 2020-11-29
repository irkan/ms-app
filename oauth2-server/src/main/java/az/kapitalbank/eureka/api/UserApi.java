package az.kapitalbank.gateway.api;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserApi {

    @GetMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }

    @PostMapping("/user")
    @ResponseBody
    public Principal userPost(Principal user) {
        return user;
    }
}
