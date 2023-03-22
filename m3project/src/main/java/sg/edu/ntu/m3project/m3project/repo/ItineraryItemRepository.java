package sg.edu.ntu.m3project.m3project.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sg.edu.ntu.m3project.m3project.entity.Itinerary;
import sg.edu.ntu.m3project.m3project.entity.ItineraryItem;

@Repository
public interface ItineraryItemRepository extends CrudRepository<ItineraryItem, Integer>{
  List<ItineraryItem> findAllByItineraryId(int itineraryId);
  Optional<ItineraryItem> findByitineraryId(int itineraryId);
  List<ItineraryItem> findAllByItinerary (Itinerary itinerary);
}
