package com.bdrive.examen.DTO;

import lombok.Data;

@Data
public class UserRequest {
    private Long userId;
    private String userName;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
}
