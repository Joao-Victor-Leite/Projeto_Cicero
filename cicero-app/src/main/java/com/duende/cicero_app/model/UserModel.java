package com.duende.cicero_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name="tb_user")
public class UserModel {

    @Id
    private UUID id;

    private String name;
    private String email;
    private String password;
}
