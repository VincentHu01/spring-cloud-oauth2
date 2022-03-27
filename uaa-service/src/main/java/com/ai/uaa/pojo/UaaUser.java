package com.ai.uaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

@Data
public class UaaUser {

    private  String username;

    private String password;

}
