package com.org.cts.service;

import com.org.cts.config.AccountConfig;
import com.org.cts.model.Accounts;
import com.org.cts.repository.AccountsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountsRepo accountsRepo;

    @Autowired
    AccountConfig accountConfig;

    @Override
    public void addAccount(Accounts accounts) {
        accountsRepo.save(accounts);
    }

    @Override
    public String getById(int id) {

        RestTemplate rest = accountConfig.getRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

         return rest.exchange("http://localhost:8989/amazon/getAll", HttpMethod.GET, entity, String.class).getBody();
    }


    @Override
    public void updateAccount(Accounts accounts) {
        accountsRepo.save(accounts);
    }

    @Override
    public String updateNameBasedOnId(int id, String name) {
        Optional<Accounts> opt = accountsRepo.findById(id);
        Accounts accounts = opt.get();
        accounts.setName(name);
        accountsRepo.save(accounts);
        return "succesfully";

    }

    @Override
    public String deleteById(int id) {
        accountsRepo.deleteById(id);

        return "success";
    }


}
