package com.example.jmailtracker.controllers;

import com.example.jmailtracker.dto.MailSendRequest;
import com.example.jmailtracker.dto.MailSendResponse;
import com.example.jmailtracker.dto.StatsResponse;
import com.example.jmailtracker.services.interfaces.MailServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/mailService")
public class MailSenderController {

  private final MailServiceI mailService;

  @Autowired
  public MailSenderController(MailServiceI mailService) {
    this.mailService = mailService;
  }

  @PostMapping(value = "/send", consumes = "application/json")
  public @ResponseBody MailSendResponse send(@RequestBody MailSendRequest request) {
    return mailService.send(request);
  }

  @GetMapping(value = "/getStats", produces = "application/json")
  public @ResponseBody StatsResponse getStats() {
    return mailService.stats();
  }
}
