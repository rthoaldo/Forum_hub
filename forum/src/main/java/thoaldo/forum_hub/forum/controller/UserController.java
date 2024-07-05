package thoaldo.forum_hub.forum.controller;

import thoaldo.forum_hub.forum.model.Usuario;
import thoaldo.forum_hub.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Usuario registerUser(@RequestBody Usuario user) {
        return userService.saveUser(user);
    }
}

