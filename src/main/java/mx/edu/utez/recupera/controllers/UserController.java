package mx.edu.utez.recupera.controllers;

import mx.edu.utez.recupera.models.User;
import mx.edu.utez.recupera.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"*"})
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.SaveUser(user), HttpStatus.CREATED) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.getUser(id), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.SaveUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.disabledUser(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> enabledUser(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.enabledUser(id), HttpStatus.OK);
    }

}
