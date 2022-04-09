package com.example.jmailtracker.services.implementations;

import com.example.jmailtracker.manager.interfaces.MailTrackManagerI;
import com.example.jmailtracker.models.MailMessage;
import com.example.jmailtracker.services.interfaces.TrackServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TrackService implements TrackServiceI {

    @Autowired private MailTrackManagerI mailTrackManager;

    public MailMessage track(Timestamp pre, Timestamp post, Integer attachment){
       return mailTrackManager.track(pre, post, attachment);
    }

}
