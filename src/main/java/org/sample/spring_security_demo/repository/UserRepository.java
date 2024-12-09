package org.sample.spring_security_demo.repository;

import org.sample.spring_security_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Integer>{
    boolean existsByEmail(String email);

    UserDetails findByEmail(String username);
}
