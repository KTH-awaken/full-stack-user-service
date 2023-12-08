package com.example.userservice.Repository;

import com.example.userservice.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepo extends JpaRepository<Account,Long> {
    Account findByEmail(String email);

    @Query("SELECT a FROM Account a WHERE a.userType != 'PATIENT'")
    List<Account> findAllExceptPatients();

    @Query("SELECT a FROM Account a WHERE a.userType = 'PATIENT'")
    List<Account> findAllPatients();
}
