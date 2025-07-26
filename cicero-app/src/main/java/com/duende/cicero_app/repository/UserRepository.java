package com.duende.cicero_app.repository;

import com.duende.cicero_app.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserModel, Long>{}
