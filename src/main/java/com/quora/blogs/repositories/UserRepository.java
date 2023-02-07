package com.quora.blogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quora.blogs.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
