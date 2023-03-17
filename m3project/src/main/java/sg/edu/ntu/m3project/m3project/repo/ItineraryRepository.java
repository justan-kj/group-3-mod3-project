package sg.edu.ntu.m3project.m3project.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sg.edu.ntu.m3project.m3project.entity.Itinerary;

@Repository
public interface ItineraryRepository extends CrudRepository<Itinerary, Integer>{
    Optional<Itinerary> findByDestinationCity(String destinationCity);
    Optional<Itinerary> findByUserId(int userId);
}
