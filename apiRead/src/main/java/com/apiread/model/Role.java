package com.apiread.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(30)", unique = true)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    public Role(long id) {
        this.id = id;
    }

    public Role() {
    }

}
