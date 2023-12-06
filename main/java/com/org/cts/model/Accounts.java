package com.org.cts.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Accounts {
    @Id
    private int id;
    private String name;
    private double balance;
    private long phoneNumber;
    private String address;
}
