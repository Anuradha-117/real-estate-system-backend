package edu.icet.real_estate_system.repository;

import edu.icet.real_estate_system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Custom method to find a user when they try to log in
    Optional<UserEntity> findByEmail(String email);
}