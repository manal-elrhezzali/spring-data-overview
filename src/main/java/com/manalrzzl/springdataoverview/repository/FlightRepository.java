package com.manalrzzl.springdataoverview.repository;

import com.manalrzzl.springdataoverview.entity.Flight;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FlightRepository extends PagingAndSortingRepository<Flight, Long> {

  List<Flight> findByOrigin(String origin);

  List<Flight> findByOriginAndDestination(String origin, String destination);

  List<Flight> findByOriginIn(String ... origins);


  List<Flight> findByOriginIgnoreCase(String origin);

  Page<Flight> findByOrigin(String origin, Pageable pageRequest);
}
