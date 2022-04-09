package com.example.jmailtracker.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data @Builder
public class MailSendResponse implements Serializable {

    public static final String UNVALID_EMAILS = "Check sender's or receiver's emails";
    public static final int KO = -1;
    public static final int OK = 1;

    private String id;
    private String error;
    private int responseCode;
    private Long attImpact;
    private Integer attDimension;
    
}
