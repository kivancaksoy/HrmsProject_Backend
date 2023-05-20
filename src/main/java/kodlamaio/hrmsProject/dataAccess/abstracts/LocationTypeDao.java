package kodlamaio.hrmsProject.dataAccess.abstracts;

import kodlamaio.hrmsProject.entities.concretes.LocationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationTypeDao extends JpaRepository<LocationType, Integer> {
}
