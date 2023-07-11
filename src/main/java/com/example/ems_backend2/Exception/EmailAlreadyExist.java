package com.example.ems_backend2.Exception;

public class EmailAlreadyExist extends Exception{
    public EmailAlreadyExist() {
        super("Email Already Exist");
    }
}
