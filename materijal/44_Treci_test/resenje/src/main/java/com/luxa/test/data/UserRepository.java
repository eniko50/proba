package com.luxa.test.data;

import com.luxa.test.model.user.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<SecurityUser, Long> {
    SecurityUser findByUsername(String username);
}
