package com.fema.edu.pesqueiro.infra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fema.edu.pesqueiro.infra.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;

    @JsonIgnore
    private String password;

    private String nome;
    private String cpf;
    private String email;
    private String celular;
    private float salario;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @JsonIgnore
    private Boolean active;

    @JsonIgnore
    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ROOT)
            return List.of(new SimpleGrantedAuthority("ROLE_ROOT"), new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        else if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else if (this.role == UserRole.USER)
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        return null;
    }


    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }

}
