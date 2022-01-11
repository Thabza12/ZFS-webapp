package com.vico.ZFS.repository;

import com.vico.ZFS.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository<User, Integer> {

    User findByEmailId(String email);

    User findByEmailIdAndPassword(String email, String password);
}
