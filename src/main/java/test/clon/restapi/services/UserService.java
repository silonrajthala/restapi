package test.clon.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.clon.restapi.model.User;
import test.clon.restapi.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User insertUser(User insert) {
        return userRepository.save(insert);  // safer and more conventional
    }

    public Optional<User> findByBinAndEmail(Integer bin, String email) {
        return userRepository.findByBinAndEmail(bin, email);
    }
}
