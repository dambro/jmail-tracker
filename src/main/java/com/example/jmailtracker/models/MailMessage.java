package com.example.jmailtracker.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailMessage {

  @Id
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @GeneratedValue(generator = "UUID")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  private Timestamp sendTs;
  private Timestamp receiveTs;
  private long gapTs;
  private Integer attachmentDimension;
}
