package com.example.userservice.View.RequestObjects;



import com.example.userservice.Entities.UserType;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private UserType userType;
}
