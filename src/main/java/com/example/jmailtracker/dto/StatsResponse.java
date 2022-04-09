package com.example.jmailtracker.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data @Builder
public class StatsResponse implements Serializable {

    private Long average;
    private Long max;
    private Long min;

}
