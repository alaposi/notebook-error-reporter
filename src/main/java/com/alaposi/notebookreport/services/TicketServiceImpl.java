package com.alaposi.notebookreport.services;

import com.alaposi.notebookreport.models.Ticket;
import com.alaposi.notebookreport.repositories.ReporterRepository;
import com.alaposi.notebookreport.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

  private TicketRepository ticketRepository;
  private ReporterRepository reporterRepository;

  @Autowired
  public TicketServiceImpl(TicketRepository ticketRepository, ReporterRepository reporterRepository) {
    this.ticketRepository = ticketRepository;
    this.reporterRepository = reporterRepository;
  }

  @Override
  public List<Ticket> findAll() {
    return ticketRepository.findAll();
  }

  @Override
  public boolean isValidName(String reporter) {
    if (reporterRepository.findAll() == null) {
      return false;
    } else {
      List<String> names = new ArrayList<>();
      reporterRepository.findAll().forEach(name -> names.add(name.getName()));
      return names.contains(reporter);
    }
  }

  @Override
  public void validateAndSave(Ticket ticket) {
    if (isValidName(ticket.getReporter()) && ticket.getSerialnumber().matches("[a-zA-Z0-9]+")) {
      ticketRepository.save(ticket);
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
  }

  @Override
  public Ticket findById(Long id) {
    return ticketRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(Ticket ticketToModify) {
    ticketRepository.delete(ticketToModify);
  }

  @Override
  public List<Ticket> getFilteredReportByManufacturer(String manufacturer) {
    return ticketRepository.findAllByManufacturer(manufacturer);
  }

  @Override
  public List<Ticket> getFilteredReportByReporter(String reporter) {
    return ticketRepository.findAllByReporter(reporter);
  }
}