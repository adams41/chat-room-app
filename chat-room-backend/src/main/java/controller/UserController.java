package controller;

import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity.ok("User registered");
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getUserProfile() {
        return ResponseEntity.ok(userService.getUserProfile());
    }
}
