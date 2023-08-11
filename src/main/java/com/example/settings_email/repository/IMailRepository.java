package com.example.settings_email.repository;

import com.example.settings_email.bean.Mail;

import java.util.List;

public interface IMailRepository {
   void update(Mail mail);
   Mail findByID(String id);
   List<Mail> findAll();
}
