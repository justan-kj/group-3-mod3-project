package sg.edu.ntu.m3project.m3project.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sg.edu.ntu.m3project.m3project.entity.Itinerary;
import sg.edu.ntu.m3project.m3project.entity.ItineraryItem;
import sg.edu.ntu.m3project.m3project.repo.ItineraryItemRepository;
import sg.edu.ntu.m3project.m3project.repo.ItineraryRepository;

@Service
public class ItineraryService {
    
    @Autowired
    private ItineraryRepository itineraryRepo;
    
    @Autowired
    private ItineraryItemRepository itineraryItemRepo;
    
    public <T> ResponseEntity<T> createdResponse(T entity, int id) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(id)
            .toUri();
        return ResponseEntity.created(location).body(entity);
    }

    public double getBudgetBalance(int itineraryId) {
        double totalExpense = 0.0;
        List<ItineraryItem> items = itineraryItemRepo.findAllByItineraryId(itineraryId);
    
        for (ItineraryItem item : items) {
            if (item.getAccommodation() != null) {
                totalExpense += item.getAccommodation().getPrice();
            }
            if (item.getTransport() != null) {
                totalExpense += item.getTransport().getPrice();
            }
        }
    
        Itinerary itinerary = itineraryRepo.findById(itineraryId).orElse(null);
        if (itinerary != null) {
            double balance = itinerary.getBudget() - totalExpense;
            return balance;
        } else {
            return -1;
        }
    }
}