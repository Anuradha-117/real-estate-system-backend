package edu.icet.real_estate_system.config;

import edu.icet.real_estate_system.entity.UserEntity;
import edu.icet.real_estate_system.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminSeeder implements CommandLineRunner {
    private final UserRepository userRepository;

    public AdminSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String adminEmail = "admin@system.com";

        Optional<UserEntity> existingAdmin = userRepository.findByEmail(adminEmail);
        if (existingAdmin.isEmpty()) {
            UserEntity admin = new UserEntity();
            admin.setName("System Administrator"); // Change if your field is named differently
            admin.setEmail(adminEmail);
            admin.setPassword("admin123");
            admin.setRole("Admin");
            userRepository.save(admin);
            System.out.println("✅ Default Admin account created successfully!");
        } else {
            System.out.println("⚡ Admin account already exists. Skipping setup.");
        }
    }
}