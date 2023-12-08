package com.example.userservice.View.Controller;
import com.example.userservice.Core.AccountService;
import com.example.userservice.Core.Security.TokenDecoder;
import com.example.userservice.Entities.UserType;
import com.example.userservice.View.RequestObjects.CreateUserRequest;
import com.example.userservice.View.ViewModels.AccountVm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/user")
public class AccountController {

    private final AccountService accountService;


    @PostMapping("/create")
    public void register(@RequestBody CreateUserRequest request, @RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7);
        String role = TokenDecoder.getRoleFromToken(token);
        request.setUserType(UserType.valueOf(role));
        accountService.createUser(request);
    }





    @GetMapping("/{userEmail}")
    public ResponseEntity<AccountVm> getUserByEmail(@PathVariable String userEmail){
        AccountVm res = accountService.getUserByEmail(userEmail);
        return ResponseEntity.ok(res);
    }
    @GetMapping("/userid/{userid}")
    public ResponseEntity<AccountVm> getUserByEmail(@PathVariable long userid){
        AccountVm res = accountService.getUserById(userid);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/workers")
    public ResponseEntity<List<AccountVm>> getWorkers(){
        List<AccountVm> res = accountService.getWorkers();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<AccountVm>> getPatients(){
        List<AccountVm> res = accountService.getPatients();
        return ResponseEntity.ok(res);
    }

}
