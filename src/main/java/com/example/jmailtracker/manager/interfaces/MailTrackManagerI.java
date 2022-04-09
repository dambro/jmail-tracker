package com.example.jmailtracker.manager.interfaces;

import com.example.jmailtracker.dto.StatsResponse;
import com.example.jmailtracker.models.MailMessage;

import java.sql.Timestamp;

public interface MailTrackManagerI {

  MailMessage track(Timestamp pre,Timestamp post, Integer attachmentDimension);
  StatsResponse getMailStats();
  Long calculateImpact(Long gapTs);
}
