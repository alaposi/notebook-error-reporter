package com.alaposi.notebookreport.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notebook_report")
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String reporter;
  private String manufacturer;
  private String serialnumber;
  private String description;
  @Temporal(TemporalType.DATE)
  private Date date = new Date();

  public Ticket() {
  }

  public Ticket(String manufacturer, String serialnumber, String description, String reporter) {
    this.manufacturer = manufacturer;
    this.serialnumber = serialnumber;
    this.description = description;
    this.reporter = reporter;
  }

  // region getters/setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getSerialnumber() {
    return serialnumber;
  }

  public void setSerialnumber(String serialnumber) {
    this.serialnumber = serialnumber;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getReporter() {
    return reporter;
  }

  public void setReporter(String reporter) {
    this.reporter = reporter;
  }

  // endregion getter/setter
}



