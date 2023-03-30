package sg.edu.ntu.m3project.m3project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.edu.ntu.m3project.m3project.entity.Accommodation;
import sg.edu.ntu.m3project.m3project.entity.Destination;
import sg.edu.ntu.m3project.m3project.entity.Itinerary;
import sg.edu.ntu.m3project.m3project.entity.ItineraryItem;
import sg.edu.ntu.m3project.m3project.entity.Transport;

import sg.edu.ntu.m3project.m3project.repo.AccommodationRepository;
import sg.edu.ntu.m3project.m3project.repo.DestinationRepository;
import sg.edu.ntu.m3project.m3project.repo.ItineraryItemRepository;
import sg.edu.ntu.m3project.m3project.repo.ItineraryRepository;
import sg.edu.ntu.m3project.m3project.repo.TransportRepository;
import sg.edu.ntu.m3project.m3project.repo.UserRepository;
import sg.edu.ntu.m3project.m3project.service.ItineraryService;
import sg.edu.ntu.m3project.m3project.service.ValidationService;

import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/itineraries/items")
public class ItineraryItemController {
    @Autowired
    ItineraryRepository itineraryRepo;

    @Autowired
    ItineraryItemRepository itineraryItemRepo;

    @Autowired
    DestinationRepository destinationRepo;

    @Autowired
    TransportRepository transportRepo;

    @Autowired
    AccommodationRepository accommodationRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    ItineraryService itineraryService;

    @Autowired
    ValidationService validationService;

    @GetMapping
    public ResponseEntity<List<ItineraryItem>> getAllItineraryItems() {
        List<ItineraryItem> itineraryItemRecords = (List<ItineraryItem>) itineraryItemRepo.findAll();
        return ResponseEntity.ok().body(itineraryItemRecords);
    }

    @GetMapping(value = "/{itineraryItemId}")
    public ResponseEntity<ItineraryItem> getItineraryItem(@PathVariable int itineraryItemId) {
        Optional<ItineraryItem> itineraryItemOptional = itineraryItemRepo.findById(itineraryItemId);
        if (itineraryItemOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        ItineraryItem itineraryItem = itineraryItemOptional.get();
        return ResponseEntity.ok().body(itineraryItem);
    }

    @PostMapping
    public ResponseEntity<ItineraryItem> createItineraryItem(@RequestBody ItineraryItem itineraryItem) {
        try {
            ItineraryItem createdItineraryItem = itineraryItemRepo.save(itineraryItem);
            return ResponseEntity.created(null).body(createdItineraryItem);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{itineraryItemId}")
    public ResponseEntity updateItineraryItem(@PathVariable int itineraryItemId,
            @RequestBody ItineraryItem updatedItem) {
        ItineraryItem existingItem = itineraryItemRepo.findById(itineraryItemId).orElse(null);
        if (existingItem != null) {

            if (updatedItem.getDestination() != null) {
                Destination newDestination = destinationRepo.findById(updatedItem.getDestination().getId())
                        .orElse(null);
                existingItem.setDestination(newDestination);
            }
            if (updatedItem.getTransport() != null) {
                Transport newTransport = transportRepo.findById(updatedItem.getTransport().getId()).orElse(null);
                existingItem.setTransport(newTransport);
            }
            if (updatedItem.getAccommodation() != null) {
                Accommodation newAccommodation = accommodationRepo.findById(updatedItem.getAccommodation().getId())
                        .orElse(null);
                existingItem.setAccommodation(newAccommodation);
            }

            existingItem.setStartDate(updatedItem.getStartDate());
            existingItem.setEndDate(updatedItem.getEndDate());

            itineraryItemRepo.save(existingItem);
            return ResponseEntity.ok().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/{itineraryItemId}/destination")
    public ResponseEntity setDestination(@PathVariable int itineraryItemId, @RequestParam int destinationId) {

        ItineraryItem itineraryItem = itineraryItemRepo.findById(itineraryItemId).orElse(null);
        Destination destination = destinationRepo.findById(destinationId).orElse(null);

        if (itineraryItem == null || destination == null) {
            return ResponseEntity.badRequest().build();
        }
        // Validate destination country
        try {
            validationService.validateCountry(destination.getCountry());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        // validate city service
        try {
            validationService.validateCity(destination.getCity());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        itineraryItem.setDestination(destination);
        itineraryItemRepo.save(itineraryItem);

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{itineraryItemId}/dates")
    public ResponseEntity<ItineraryItem> setItineraryItemDates(@PathVariable int itineraryItemId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Optional<ItineraryItem> itineraryItemOptional = itineraryItemRepo.findById(itineraryItemId);
        if (!itineraryItemOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ItineraryItem itineraryItemToUpdate = itineraryItemOptional.get();
        itineraryItemToUpdate.setStartDate(startDate);
        itineraryItemToUpdate.setEndDate(endDate);
        itineraryItemRepo.save(itineraryItemToUpdate);
        return ResponseEntity.ok().body(itineraryItemToUpdate);
    }

    @DeleteMapping(value = "/{itineraryItemId}")
    public ResponseEntity deleteItineraryItem(@PathVariable int itineraryItemId) {
        Optional<ItineraryItem> foundItineraryItem = itineraryItemRepo.findById(itineraryItemId);
        if (!foundItineraryItem.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        itineraryItemRepo.delete(foundItineraryItem.get());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{itineraryItemId}/destination")
    public ResponseEntity deleteDestinationItem(@PathVariable int itineraryItemId) {
        Optional<ItineraryItem> foundItineraryItem = itineraryItemRepo.findById(itineraryItemId);
        if (!foundItineraryItem.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        foundItineraryItem.get().setDestination(null);
        itineraryItemRepo.save(foundItineraryItem.get());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{itineraryItemId}/accommodation")
    public ResponseEntity deleteAccommodationItem(@PathVariable int itineraryItemId) {
        Optional<ItineraryItem> foundItineraryItem = itineraryItemRepo.findById(itineraryItemId);
        if (!foundItineraryItem.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        foundItineraryItem.get().setAccommodation(null);
        itineraryItemRepo.save(foundItineraryItem.get());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{itineraryItemId}/transport")
    public ResponseEntity deleteTransportItem(@PathVariable int itineraryItemId) {
        Optional<ItineraryItem> foundItineraryItem = itineraryItemRepo.findById(itineraryItemId);
        if (!foundItineraryItem.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        foundItineraryItem.get().setTransport(null);
        itineraryItemRepo.save(foundItineraryItem.get());
        return ResponseEntity.ok().build();
    }

}
