package com.alaposi.notebookreport.models;

import java.util.List;

public class DtoQuery {
  private String result = "ok";
  private List<Ticket> tickets;

  public DtoQuery(List<Ticket> tickets) {
    this.tickets = tickets;
  }

  public DtoQuery() {
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }
}

