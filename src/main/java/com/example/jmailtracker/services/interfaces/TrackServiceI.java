package com.example.jmailtracker.services.interfaces;

import com.example.jmailtracker.models.MailMessage;

import java.sql.Timestamp;

public interface TrackServiceI {

   MailMessage track(Timestamp pre, Timestamp post, Integer attachment);
}
