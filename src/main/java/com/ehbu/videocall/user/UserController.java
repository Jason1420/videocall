package com.ehbu.videocall.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    public void register(
            @RequestBody User user
    ) {
        userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody User email) {
        userService.logout(email.getEmail());
    }
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex){
        ex.printStackTrace();
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}
