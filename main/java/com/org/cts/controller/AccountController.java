package com.org.cts.controller;

import com.org.cts.model.Accounts;
import com.org.cts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public void addAccount(@RequestBody Accounts accounts) {
        accountService.addAccount(accounts);
    }

    @GetMapping("/getById/{id}")
    public String  getById(@PathVariable int id) {
        return accountService.getById(id);

    }

    @PutMapping("/update")
    public void updateAccount(@RequestBody Accounts accounts) {
        accountService.updateAccount(accounts);
    }

    @PatchMapping("/updateNameById/{id}/{name}")
    public String updateNameBasedOnId(@PathVariable int id, @PathVariable String name) {
        String s = accountService.updateNameBasedOnId(id, name);
        return s;
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable int id) {
        String s = accountService.deleteById(id);
        return s;
    }
}
