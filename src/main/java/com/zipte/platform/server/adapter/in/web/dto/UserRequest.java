package com.zipte.platform.server.adapter.in.web.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String email;
    private String password;
    private String phoneNumber;
}

