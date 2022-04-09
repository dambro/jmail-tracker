package com.example.jmailtracker.factory.simplemail;


import javax.mail.internet.MimeMessage;

public interface NewMail {

    MimeMessage create(String to, String from, String body, String subject, Integer attachment);
}
