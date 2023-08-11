package com.example.settings_email.service;

import com.example.settings_email.bean.Mail;

import java.util.List;

public interface IMailService {
    void update(Mail mail);
    List<Mail> findAll();
    Mail findByID(String id);
}
