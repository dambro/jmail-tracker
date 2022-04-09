package com.example.jmailtracker.factory.simplemail;

import com.example.jmailtracker.AttachmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class BaseMail implements NewMail {

  @Autowired private JavaMailSender mailSender;

  @Override
  public MimeMessage create(
      String to, String from, String body, String subject, String attachment) {

    MimeMessage message = mailSender.createMimeMessage();

    try {
      MimeMessageHelper mmHelper = new MimeMessageHelper(message, true);

      mmHelper.setFrom(from);
      mmHelper.setTo(to);
      mmHelper.setSubject(subject);
      mmHelper.setText(body);
      handleAttachment(mmHelper, attachment);
    } catch (MessagingException e) {
      System.out.println(e);
    }

    return message;
  }

  private MimeMessageHelper handleAttachment(MimeMessageHelper mmHelper, String attachment) {
    try {
      AttachmentType type = AttachmentType.find(attachment);
      if (type != null) {
        mmHelper.addAttachment("FileTest", type.getFile());
      }
    } catch (MessagingException e) {
      System.out.println(e);
    }

    return mmHelper;
  }
}