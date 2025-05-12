package test.clon.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import test.clon.restapi.model.User;
import test.clon.restapi.repository.UserRepository;
import test.clon.restapi.request.UserReq;
import test.clon.restapi.response.ResponseMessage;
import test.clon.restapi.security.CustomUserDetails;
import test.clon.restapi.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService serviceUser;

    // Original endpoint for /api/hello
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World ! The first Api in JAVA Spring boot.";
    }

    // New endpoint for /api/user to get all users
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/user-add")
    public ResponseEntity<ResponseMessage> insertUsers(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof CustomUserDetails userDetails)) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }

        serviceUser.insertUser(user);

        ResponseMessage responseMessage = new ResponseMessage("000", "User Insert Successfully", true);
        // Return the custom response
        return ResponseEntity.ok(responseMessage);
    }
    // Endpoint to fetch account updates by BIN and Card Number
    @PostMapping("/by-user-email")
    public ResponseEntity<List<User>> getUserByEmail(@RequestBody UserReq req) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof CustomUserDetails userDetails)) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }

        if (req.getEmail() == null || req.getEmail().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Integer bin = userDetails.getBin();

        Optional<User> data = serviceUser.findByBinAndEmail(bin, req.getEmail());

        if (data.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(List.of(data.get()));
    }

}
