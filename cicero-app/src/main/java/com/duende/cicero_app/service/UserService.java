package com.duende.cicero_app.service;

import com.duende.cicero_app.dto.user.UserCreateDTO;
import com.duende.cicero_app.dto.user.UserResponseDTO;
import com.duende.cicero_app.model.UserModel;
import com.duende.cicero_app.repository.UserRepository;
import com.duende.cicero_app.repository.infected.InfectedRepository;
import com.duende.cicero_app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService (
            UserRepository userRepository,
            InfectedRepository infectedRepository
    ) {
        this.userRepository = userRepository;
    }

    // GET ALL
    public List<UserResponseDTO> findAllUsers () {

        return userRepository.findAll()
                .stream()
                .map(UserResponseDTO::fromEntity)
                .collect(Collectors.toList());

    }

    // GET BY ID
    public UserResponseDTO findUserById (UUID id) {

        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        return UserResponseDTO.fromEntity(user);

    }

    // CREATE
    public void createUser (UserCreateDTO dto) {

        UserModel user = new UserModel();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());

        userRepository.save(user);

    }

    // UPDATE
    public void updateUser(UUID id, UserCreateDTO dto) {

        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Utils.copyNonNullProperties(dto, user);
        UserModel updated = userRepository.save(user);

        UserResponseDTO.fromEntity(updated);

    }

    // DELETE
    public void deleteUser (UUID id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuário não existe");
        }

        userRepository.deleteById(id);

    }

}
