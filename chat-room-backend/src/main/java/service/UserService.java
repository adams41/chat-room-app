package service;

import dto.UserDto;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(encryptPassword(userDto.getPassword()));
        user.setRegisteredAt(LocalDateTime.now());
        userRepository.save(user);
    }

    public UserDto getUserProfile() {
        // Implementation für Profilabfrage
        return null;
    }

    private String encryptPassword(String password) {
        // Passwortverschlüsselung
        return null;
    }
}
