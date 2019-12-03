package com.alaposi.notebookreport.models;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
public class Reporter2 {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  //@ElementCollection
  private ArrayList<String> names;

  public ArrayList<String> getNames() {
    return names;
  }

  public void setNames(ArrayList<String> names) {
    this.names = names;
  }
}
