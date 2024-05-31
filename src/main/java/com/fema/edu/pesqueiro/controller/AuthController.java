package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.dto.LoginDTO;
import com.fema.edu.pesqueiro.infra.model.User;
import com.fema.edu.pesqueiro.security.TokenService;
import com.fema.edu.pesqueiro.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO data, HttpServletRequest request){

        try{
            Authentication authToken = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());
            authenticationManager.authenticate(authToken);

            String token = tokenService.generateToken((User) authToken.getPrincipal());

            return ResponseEntity.ok(token);
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping({"/token"})
    public ResponseEntity<?> validate(@PathVariable("token") String token){
        try{
            String username = tokenService.validateToken(token);

            if(!username.isEmpty()){
                return ResponseEntity.ok().build();
            }

            return ResponseEntity.badRequest().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
