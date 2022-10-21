package Custom.Queries1.Controller;

import Custom.Queries1.Entities.Flight;
import Custom.Queries1.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    Repository repository;


    @PostMapping
    public void generatesFlights() {
        Random random = new Random();
        for(int i = 0; i < 50; ++i) {
            Flight flight = new Flight();
            String randomString = random.ints(10, 65, 91)
                    .collect(StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            StringBuilder::append)
                    .toString(); //Generating a Random String with an IntStream
            flight.setDescription(randomString + " " + randomString + " " +randomString);
            flight.setFromAirport(randomString);
            flight.setToAirport(randomString);
            flight.setStatus(FlightStatus.ONTIME);
            repository.save(flight);
        }
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return repository.findAll();
    }
}
