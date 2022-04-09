package com.example.jmailtracker.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data @Builder
public class MailSendRequest implements Serializable {

    private String to;
    private String from;
    private String subject;
    private String body;
    private String attachment;

}
