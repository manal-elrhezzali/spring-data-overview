package com.manalrzzl.springdataoverview;

import com.manalrzzl.springdataoverview.entity.Flight;
import com.manalrzzl.springdataoverview.repository.FlightRepository;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
// only a partial Spring context will be created
// containing our persistence specific bean
// which is H2, our EntityManager, Spring Data repo.. => makes test execute
// as quickly as possible as there is no overhead of starting up things
// that we don't need
@DataJpaTest
class CrudTests {

	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void verifyFlightCanBeSaved() {
		final Flight flight = new Flight();
		flight.setOrigin("Germany");
		flight.setDestination("Morocco");
		flight.setScheduledAt(LocalDateTime.parse("2022-07-01T12:12:00"));

		flightRepository.save(flight);

		Assertions.assertThat(flightRepository.findAll())
				.hasSize(1)
				.first()
				.isEqualTo(flight);

		flightRepository.deleteById(flight.getId());

		Assertions.assertThat(flightRepository.count()).isZero();
	}

}
