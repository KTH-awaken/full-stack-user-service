package com.example.userservice.Core;



import com.example.userservice.Entities.Account;
import com.example.userservice.View.ViewModels.AccountVm;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static AccountVm toAccountVm(Account account){
        return new AccountVm(account.getId(),account.getFirstName(), account.getLastName() ,account.getEmail(), account.getUserType(), account.getTimestamp());
    }

    public static List<AccountVm> toAccountVms(List<Account> accounts){
        List<AccountVm> vms = new ArrayList<>();
        for(Account account : accounts)
            vms.add(Mapper.toAccountVm(account));
        return vms;
    }

}
