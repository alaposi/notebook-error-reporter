package com.alaposi.notebookreport.repositories;

import com.alaposi.notebookreport.models.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
  List<Ticket> findAll();

  List<Ticket> findAllByManufacturer(String manufacturer);

  List<Ticket> findAllByReporter(String reporter);
}
