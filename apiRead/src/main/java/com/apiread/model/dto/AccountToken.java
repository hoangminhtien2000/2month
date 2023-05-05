package com.apiread.model.dto;

import com.apiread.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountToken {
    private Long id;
    private String username;
    private List<Role> roles;
    private String token;
}
