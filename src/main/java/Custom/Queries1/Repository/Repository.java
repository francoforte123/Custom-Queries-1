package Custom.Queries1.Repository;

import Custom.Queries1.Entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Flight, Long>{
}
