package com.api.crud.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	
}
