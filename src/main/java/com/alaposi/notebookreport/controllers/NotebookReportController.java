package com.alaposi.notebookreport.controllers;

import com.alaposi.notebookreport.models.Ticket;
import com.alaposi.notebookreport.repositories.ReporterRepository;
import com.alaposi.notebookreport.services.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class NotebookReportController {

  private TicketService ticketService;
  private ReporterRepository reporterRepository;

  public NotebookReportController(TicketService ticketService, ReporterRepository reporterRepository) {
    this.ticketService = ticketService;
    this.reporterRepository = reporterRepository;
  }

  @GetMapping(value = "/")
  public String renderMainPage(Model model) {
    model.addAttribute("ticketToAdd", new Ticket());
    model.addAttribute("reporters", reporterRepository.findAll());
    return "main";
  }

  @PostMapping(value = "/add")
  public String addNewReport(@ModelAttribute(name = "mySampleToAdd") Ticket ticketToAdd) {
    ticketService.validateAndSave(ticketToAdd);
    return "redirect:/list";
  }

  @GetMapping(value = "/list")
  public String displayList(Model model) {
    model.addAttribute("errorList", ticketService.findAll());
    return "list";
  }
}
