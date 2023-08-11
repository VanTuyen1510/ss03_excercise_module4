package com.example.settings_email.service;

import com.example.settings_email.bean.Mail;
import com.example.settings_email.repository.IMailRepository;
import com.example.settings_email.repository.MailRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService implements IMailService{
    private IMailRepository repository = new MailRepositoryImpl();
    @Override
    public void update(Mail mail) {
        repository.update(mail);
    }

    @Override
    public List<Mail> findAll() {
        return repository.findAll();
    }

    @Override
    public Mail findByID(String id) {
        return repository.findByID(id);
    }
}
