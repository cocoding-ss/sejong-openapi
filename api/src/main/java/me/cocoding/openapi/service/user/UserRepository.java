package me.cocoding.openapi.service.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByClientIdAndClientSecret(String clientId, String clientSecret);
    Optional<User> findUserByStdNum(String stdNum);
}
