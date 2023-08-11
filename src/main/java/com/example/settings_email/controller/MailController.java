package com.example.settings_email.controller;

import com.example.settings_email.bean.Mail;
import com.example.settings_email.service.IMailService;
import com.example.settings_email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {
    private IMailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String displayList(Model model) {
        model.addAttribute("mails", mailService.findAll());
        return "mail/list";
    }


    //String mailID, String language, int pageSize, boolean haveSpamsFilter, String signature
    @GetMapping("/update")
    public String displayUpdate(Model model, @RequestParam("id") String id) {
        model.addAttribute("mail", mailService.findByID(id));
        model.addAttribute("languages", getLanguages());
        model.addAttribute("sizes",getPageSizes());
        return "mail/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("mail") Mail mail ){
        mailService.update(mail);
        return "redirect:/mail/list";
    }

    private List<String> getLanguages() {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        return languages;
    }

    private List<String> getPageSizes(){
        List<String> pageSizes = new ArrayList<>();
        pageSizes.add("5");
        pageSizes.add("10");
        pageSizes.add("15");
        pageSizes.add("25");
        pageSizes.add("50");
        pageSizes.add("100");
      return pageSizes;
    }

}
