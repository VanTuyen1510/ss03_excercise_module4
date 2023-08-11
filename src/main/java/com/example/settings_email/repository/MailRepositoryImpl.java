package com.example.settings_email.repository;

import com.example.settings_email.bean.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MailRepositoryImpl implements IMailRepository {
    public static Map<String,Mail> mailMap;
    //String mailID, String language, int pageSize, boolean haveSpamsFilter, String signature
    static {
        mailMap = new HashMap<>();
        mailMap.put("1",new Mail("1","English",5,true,"Thor"));
        mailMap.put("2",new Mail("2","Vietnamese",10,true,"Iron Man"));
        mailMap.put("3",new Mail("3","Japanese",15,false,"Spider Man"));
        mailMap.put("4",new Mail("4","Chinese",20,false,"King"));
    }


    @Override
    public void update(Mail mail) {
        if (mailMap.containsKey(mail.getMailID())) {
            mailMap.put(mail.getMailID(),mail);
        }
    }

    @Override
    public Mail findByID(String id) {
        return mailMap.get(id);
    }

    @Override
    public List<Mail> findAll() {
        return new ArrayList<>(mailMap.values());
    }
}
