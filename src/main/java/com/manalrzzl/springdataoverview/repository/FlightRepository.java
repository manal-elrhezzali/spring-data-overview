package com.manalrzzl.springdataoverview.repository;

import com.manalrzzl.springdataoverview.entity.Flight;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {

  List<Flight> findByOrigin(String origin);

  List<Flight> findByOriginAndDestination(String origin, String destination);

  List<Flight> findByOriginIn(String ... origins);


  List<Flight> findByOriginIgnoreCase(String origin);
}
