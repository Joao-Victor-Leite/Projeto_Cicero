package com.duende.cicero_app.service;

import com.duende.cicero_app.dto.user.UserCreateDTO;
import com.duende.cicero_app.dto.user.UserResponseDTO;
import com.duende.cicero_app.model.UserModel;
import com.duende.cicero_app.repository.UserRepository;
import com.duende.cicero_app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET ALL
    public List<UserResponseDTO> findAllUsers(){
        return userRepository.findAll().stream()
                .map(UserResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public UserResponseDTO findUserByID(Long id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com este id"));
        return UserResponseDTO.fromEntity(user);
    }

    // POST
    public UserResponseDTO createUser(UserCreateDTO dto) {

        UserModel user = new UserModel();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());          // fazer verificacao de email
        user.setPassword(dto.getPassword());    // fazer criptografia depois

        UserModel userSaved = userRepository.save(user);
        return UserResponseDTO.fromEntity(userSaved);
    }

    // PUT
    public UserResponseDTO updateUser(Long id, UserCreateDTO dto) {
        UserModel userExisting = userRepository.findById(id)
                .orElse(null);

        UserModel userUpdated = new UserModel();
        userUpdated.setName(dto.getName());
        userUpdated.setEmail(dto.getEmail());
        userUpdated.setPassword(dto.getPassword());

        Utils.copyNonNullProperties(userUpdated, userExisting);

        UserModel userSaved = userRepository.save(userExisting);
        return  UserResponseDTO.fromEntity(userSaved);
    }

    // DELETE
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        userRepository.deleteById(id);
    }

}
