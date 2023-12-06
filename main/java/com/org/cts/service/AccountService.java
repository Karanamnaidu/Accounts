package com.org.cts.service;

import com.org.cts.model.Accounts;

public interface AccountService {
    public void addAccount(Accounts accounts);
    public String getById(int id);
    public void updateAccount(Accounts accounts);
    public String updateNameBasedOnId(int id,String name);
    public String deleteById(int id);
}
