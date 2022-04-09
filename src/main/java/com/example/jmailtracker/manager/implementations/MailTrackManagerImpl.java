package com.example.jmailtracker.manager.implementations;

import com.example.jmailtracker.dto.StatsResponse;
import com.example.jmailtracker.manager.interfaces.MailTrackManagerI;
import com.example.jmailtracker.models.MailMessage;
import com.example.jmailtracker.repository.MailTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.UUID;

@Component
public class MailTrackManagerImpl implements MailTrackManagerI {

  private MailTrackRepository mailTrackRepository;

  @Autowired
  public MailTrackManagerImpl(MailTrackRepository mailTrackRepository) {
    this.mailTrackRepository = mailTrackRepository;
  }

  public MailMessage track(Timestamp pre, Timestamp post, String attachmentDimension) {
    long diffSeconds = (post.getTime() / 1000) - (pre.getTime() / 1000);
    MailMessage email =
        new MailMessage(UUID.randomUUID(), pre, post, diffSeconds, attachmentDimension);
    return mailTrackRepository.save(email);
  }

  public StatsResponse getMailStats() {
    return StatsResponse.builder()
        .average(mailTrackRepository.getAverage())
        .max(mailTrackRepository.getMax())
        .min(mailTrackRepository.getMin())
        .build();
  }
}
