package com.example.ecommercewebsite.Model;


import com.example.ecommercewebsite.Model.Enumerations.Role;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Getter
@Entity
@Table(name = "Pazar3_Users")
public class User implements UserDetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String email;
    String name;
    String lastName;
    String address;
    String username;
    String password;
    String phoneNumber;
    @Enumerated(EnumType.STRING)
    Role role;

    boolean isAccountNonExpired = true;
    boolean isAccountNonLocked = true;
    boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;


    @OneToMany (
            mappedBy = "user",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    List<Product> productsList;

    public User(String email, String name, String lastName, String address, String username, String password, String phoneNumber, List<Product> productsList) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.productsList = productsList;
        this.role = Role.ROLE_USER;
    }

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
