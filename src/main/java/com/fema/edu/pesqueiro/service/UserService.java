package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.dto.PasswordUpdateDTO;
import com.fema.edu.pesqueiro.dto.UserInsertDTO;
import com.fema.edu.pesqueiro.dto.UserUpdateDTO;
import com.fema.edu.pesqueiro.infra.model.User;
import com.fema.edu.pesqueiro.infra.repository.UserRepository;
import com.fema.edu.pesqueiro.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    SecurityConfig securityConfig;

    @Autowired
    UserRepository repository;


    public void insert(UserInsertDTO newUser) {
        final String username = newUser.getUsername();

        User result = findByUsername(username);
        if (result == null) {
            User user = new User();

            user.setId(null);
            user.setActive(false);
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            user.setNome(newUser.getNome());
            user.setCelular(newUser.getCelular());
            user.setSalario(newUser.getSalario());
            user.setCpf(newUser.getCpf());

            String encryptedPass = securityConfig.passwordEncoder().encode(newUser.getPassword());
            user.setPassword(encryptedPass);

            repository.save(user);
        } else {
            throw new RuntimeException("Usuario com username ja existente!");
        }
    }

    public User findById(UUID id) {
        Optional<User> result = repository.findById(id);
        return result.orElse(null);
    }

    public User findByUsername(String username) {
        Optional<User> result = repository.findByUsername(username);
        return result.orElse(null);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User update(UserUpdateDTO update) {
        final UUID uuid = update.getId();
        User result = findById(uuid);
        if (result != null) {
            result.setUsername(update.getUsername());
            result.setCelular(update.getCelular());
            result.setEmail(update.getEmail());
            result.setSalario(update.getSalario());
            result.setActive(update.isActive());

            repository.save(result);
            return result;
        } else {
            throw new RuntimeException("Usuario invalido!");
        }
    }

    public User updatePassword(PasswordUpdateDTO updt) {
        User result = findById(updt.getId());
        if (result != null) {

            String encryptedPass = securityConfig.passwordEncoder().encode(updt.getPassword());
            result.setPassword(encryptedPass);

            repository.save(result);
            return result;
        } else {
            throw new RuntimeException("Usuario invalido!");
        }
    }

}
