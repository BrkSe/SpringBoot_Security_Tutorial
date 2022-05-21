package com.burakkutbay.springboot_security_example.repository;

import com.burakkutbay.springboot_security_example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String userName);
}
