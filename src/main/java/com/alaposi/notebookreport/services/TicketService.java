package com.alaposi.notebookreport.services;

import com.alaposi.notebookreport.models.Ticket;

import java.util.List;

public interface TicketService {
  List<Ticket> findAll();

  boolean isValidName(String reporter);

  void validateAndSave(Ticket ticket);

  Ticket findById(Long id);

  void delete(Ticket ticketToModify);

  List<Ticket> getFilteredReportByManufacturer(String manufacturer);

  List<Ticket> getFilteredReportByReporter(String reporter);
}
