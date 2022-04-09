package com.example.jmailtracker.repository;

import com.example.jmailtracker.models.MailMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;


public interface MailTrackRepository extends JpaRepository<MailMessage, UUID> {

    @Query(value = "SELECT AVG(gapTs) FROM MailMessage ")
    Long getAverage();

    @Query("SELECT MAX(gapTs) FROM MailMessage")
    Long getMax();

    @Query("SELECT MIN(gapTs) FROM MailMessage")
    Long getMin();

}
