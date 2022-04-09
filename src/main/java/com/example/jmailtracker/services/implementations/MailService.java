package com.example.jmailtracker.services.implementations;

import com.example.jmailtracker.dto.MailSendRequest;
import com.example.jmailtracker.dto.MailSendResponse;
import com.example.jmailtracker.dto.StatsResponse;
import com.example.jmailtracker.factory.simplemail.NewMail;
import com.example.jmailtracker.manager.interfaces.MailTrackManagerI;
import com.example.jmailtracker.models.MailMessage;
import com.example.jmailtracker.services.interfaces.MailServiceI;
import com.example.jmailtracker.services.interfaces.TrackServiceI;
import com.example.jmailtracker.validators.EmailValidatorI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class MailService implements MailServiceI {

  @Autowired private JavaMailSender mailSender;

  @Autowired private EmailValidatorI emailValidator;

  @Autowired private NewMail simpleMail;

  @Autowired private TrackServiceI trackService;

  @Autowired private MailTrackManagerI mailTrackManager;

  public MailSendResponse send(MailSendRequest request) {
    String to = request.getTo();
    String from = request.getFrom();
    String body = request.getBody();
    String subject = request.getSubject();
    Integer attachment = request.getAttachment();

    if (!checkEmails(to, from)) {
      return createResponse(MailSendResponse.UNVALID_EMAILS, null, MailSendResponse.KO, null, null);
    }

    Timestamp pre = new Timestamp(System.currentTimeMillis());
    mailSender.send(simpleMail.create(to, from, body, subject, attachment));
    Timestamp post = new Timestamp(System.currentTimeMillis());

    MailMessage msg = trackService.track(pre, post, attachment);

    return createResponse(null, msg.getId().toString(), MailSendResponse.OK, attachment, mailTrackManager.calculateImpact(msg.getGapTs()));
  }

  public StatsResponse stats() {
    return mailTrackManager.getMailStats();
  }

  private boolean checkEmails(String to, String from) throws IllegalArgumentException {
    return emailValidator.validate(to) && emailValidator.validate(from);
  }

  private MailSendResponse createResponse(
      String error, String id, int responseCode, Integer attDimension, Long impact) {
    return MailSendResponse.builder()
        .error(error)
        .id(id)
        .responseCode(responseCode)
        .attDimension(attDimension)
        .attImpact(impact)
        .build();
  }
}
