package com.example.userservice;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.userservice.Core.AccountService;
import com.example.userservice.Entities.Account;
import com.example.userservice.Repository.IAccountRepo;
import com.example.userservice.View.RequestObjects.CreateUserRequest;
import com.example.userservice.View.ViewModels.AccountVm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

class AccountServiceTest {

    private IAccountRepo accountRepo;
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepo = mock(IAccountRepo.class);
        accountService = new AccountService(accountRepo);
    }
    @Test
    void createUser_ShouldCreateUser() {
        CreateUserRequest request = new CreateUserRequest();
        when(accountRepo.findByEmail(request.getEmail())).thenReturn(null);

        accountService.createUser(request);

        verify(accountRepo, times(1)).save(any(Account.class));
    }
    @Test
    void getPatients_ShouldReturnListOfPatients() {
        List<Account> mockAccounts = new ArrayList<>();

        when(accountRepo.findAllPatients()).thenReturn(mockAccounts);

        List<AccountVm> result = accountService.getPatients();

        assertNotNull(result);
    }
    @Test
    void getUserByEmail_ShouldReturnUser() {
        String email = "test@example.com";
        Account mockAccount = new Account();

        when(accountRepo.findByEmail(email)).thenReturn(mockAccount);

        AccountVm result = accountService.getUserByEmail(email);

        assertNotNull(result);
    }

    @Test
    void getUserByEmail_ShouldThrowExceptionForNonExistentEmail() {
        String email = "nonexistent@example.com";

        when(accountRepo.findByEmail(email)).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> {
            accountService.getUserByEmail(email);
        });
    }

    @Test
    void getUserById_ShouldReturnUser() {
        long id = 1L;
        Account mockAccount = new Account();

        when(accountRepo.getReferenceById(id)).thenReturn(mockAccount);

        AccountVm result = accountService.getUserById(id);

        assertNotNull(result);
    }

    @Test
    void getUserById_ShouldThrowExceptionForNonExistentId() {
        long id = 999L;

        when(accountRepo.getReferenceById(id)).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> {
            accountService.getUserById(id);
        });
    }

    @Test
    void getWorkers_ShouldReturnListOfWorkers() {
        List<Account> mockAccounts = new ArrayList<>();

        when(accountRepo.findAllExceptPatients()).thenReturn(mockAccounts);

        List<AccountVm> result = accountService.getWorkers();

        assertNotNull(result);
    }

}