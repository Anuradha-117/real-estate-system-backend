package edu.icet.real_estate_system.service;

import edu.icet.real_estate_system.entity.UserEntity;
import edu.icet.real_estate_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserEntity registerUser(UserEntity user) {
        // no role,default to customer
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("Customer");
        }
        return repository.save(user);
    }

    public UserEntity loginUser(String email, String password) {
        Optional<UserEntity> foundUser = repository.findByEmail(email);

        //validate
        if (foundUser.isPresent() && foundUser.get().getPassword().equals(password)) {
            return foundUser.get();
        }
        return null;
    }

    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}