package com.alaposi.notebookreport.controllers;

import com.alaposi.notebookreport.models.DtoForDelete;
import com.alaposi.notebookreport.models.DtoQuery;
import com.alaposi.notebookreport.models.Ticket;
import com.alaposi.notebookreport.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotebookReportApiController {

  private TicketService ticketService;

  @Autowired
  public NotebookReportApiController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @PostMapping(value = "/complete/{id}")
  public ResponseEntity<Object> deleteId(@PathVariable Long id, @RequestBody DtoForDelete dtoForDelete) {
    Ticket ticketTodelete = ticketService.findById(id);
    if (ticketTodelete == null) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } else {
      if (dtoForDelete != null && dtoForDelete.getSecret().equals("voala")) {
        ticketService.delete(ticketTodelete);
        return new ResponseEntity(HttpStatus.OK);
      } else {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }
    }
  }

  @GetMapping(value = "/list/query")
  public ResponseEntity<DtoQuery> getFilteredReport(@RequestParam(required = false) String manufacturer, @RequestParam(required = false) String reporter) {
    if (manufacturer == null && reporter == null) {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    } else if (manufacturer != null) {
      return ResponseEntity.status(HttpStatus.OK).body(new DtoQuery(ticketService.getFilteredReportByManufacturer(manufacturer)));
    } else if (reporter != null) {
      return ResponseEntity.status(HttpStatus.OK).body(new DtoQuery(ticketService.getFilteredReportByReporter(reporter)));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new DtoQuery(ticketService.findAll()));
    }
  }
}
