package com.alaposi.notebookreport;

import com.alaposi.notebookreport.models.Reporter;
import com.alaposi.notebookreport.models.Ticket;
import com.alaposi.notebookreport.repositories.ReporterRepository;
import com.alaposi.notebookreport.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotebookreportApplication implements CommandLineRunner {

  private ReporterRepository reporterRepository;
  private TicketRepository ticketRepository;

  @Autowired
  public NotebookreportApplication(ReporterRepository reporterRepository, TicketRepository ticketRepository) {
    this.reporterRepository = reporterRepository;
    this.ticketRepository = ticketRepository;
  }


  public static void main(String[] args) {
    SpringApplication.run(NotebookreportApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Reporter r1 = new Reporter("Egg");
    Reporter r2 = new Reporter("Szilvi");
    Reporter r3 = new Reporter("Kevi");
    Reporter r4 = new Reporter("Riel");
    Reporter r5 = new Reporter("Barna");

    reporterRepository.save(r1);
    reporterRepository.save(r2);
    reporterRepository.save(r3);
    reporterRepository.save(r4);
    reporterRepository.save(r5);

    Ticket t1 = new Ticket("Dell", "125125125", "broken display", "Egg");
    Ticket t2 = new Ticket("Lenovo", "AA125895", "pixel error", "Szilvi");
    ticketRepository.save(t1);
    ticketRepository.save(t2);
  }
}
