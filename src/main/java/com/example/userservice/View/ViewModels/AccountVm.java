package com.example.userservice.View.ViewModels;

import com.example.userservice.Entities.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountVm {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private UserType userType;
    private LocalDateTime timestamp;
}
