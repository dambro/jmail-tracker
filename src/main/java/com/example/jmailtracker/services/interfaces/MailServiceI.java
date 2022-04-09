package com.example.jmailtracker.services.interfaces;

import com.example.jmailtracker.dto.MailSendRequest;
import com.example.jmailtracker.dto.MailSendResponse;
import com.example.jmailtracker.dto.StatsResponse;

public interface MailServiceI {

   MailSendResponse send(MailSendRequest request);
   StatsResponse stats();
}
