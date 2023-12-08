package com.example.userservice.Core;


import com.example.userservice.Entities.Account;
import com.example.userservice.Repository.IAccountRepo;
import com.example.userservice.View.RequestObjects.CreateUserRequest;
import com.example.userservice.View.ViewModels.AccountVm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final IAccountRepo accountRepo;


    public void createUser(CreateUserRequest request){

        Account acc = accountRepo.findByEmail(request.getEmail());
        if(acc != null)
            return;


        Account accountToSave = Account.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .timestamp(LocalDateTime.now())
                .userType(request.getUserType())
                .build();

        accountRepo.save(accountToSave);

    }


    public List<AccountVm> getPatients(){
        return Mapper.toAccountVms(accountRepo.findAllPatients());
    }


    public AccountVm getUserByEmail(String email){
        Account account = accountRepo.findByEmail(email);
        if(account == null)
            throw new IllegalArgumentException("Email does not exist");


        return Mapper.toAccountVm(account);
    }

    public AccountVm getUserById(long id){
        Account account = accountRepo.getReferenceById(id);
        if(account == null)
            throw new IllegalArgumentException("User with id does not exist");

        return Mapper.toAccountVm(account);
    }

    public List<AccountVm> getWorkers(){
        return Mapper.toAccountVms(accountRepo.findAllExceptPatients());
    }
}
