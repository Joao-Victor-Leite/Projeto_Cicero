package com.duende.cicero_app.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {

    private String name;
    private String email;
    private String password;

}
