package com.alaposi.notebookreport.repositories;

import com.alaposi.notebookreport.models.Reporter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporterRepository extends CrudRepository<Reporter, Long> {
  List<Reporter> findAll();
}
