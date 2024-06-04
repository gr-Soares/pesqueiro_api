package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.dto.LoginDTO;
import com.fema.edu.pesqueiro.dto.TokenDTO;
import com.fema.edu.pesqueiro.infra.model.User;
import com.fema.edu.pesqueiro.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO data) {

        try {
            var authToken = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());
            var auth = authenticationManager.authenticate(authToken);

            String tkString = tokenService.generateToken((User) auth.getPrincipal());

            TokenDTO token = new TokenDTO(tkString);

            return ResponseEntity.ok(token);
        } catch (Exception ex) {
            System.out.println(ex);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping({"/token"})
    public ResponseEntity<?> validate(@RequestBody TokenDTO data) {
        try {
            String username = tokenService.validateToken(data.getToken());

            if (!username.isEmpty()) {
                return ResponseEntity.ok().build();
            }

            return ResponseEntity.badRequest().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
