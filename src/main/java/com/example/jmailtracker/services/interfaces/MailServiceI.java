package com.example.jmailtracker.services.interfaces;

import com.example.jmailtracker.dto.MailSendResponse;
import com.example.jmailtracker.dto.StatsResponse;

public interface MailServiceI {

   MailSendResponse send(String to, String from, String subject, String body, String attachment);
   StatsResponse stats();
}
