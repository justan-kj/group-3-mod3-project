package sg.edu.ntu.m3project.m3project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.m3project.m3project.entity.Itinerary;
import sg.edu.ntu.m3project.m3project.repo.ItineraryRepository;
import sg.edu.ntu.m3project.m3project.repo.UserRepository;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/itineraries")
public class ItineraryController {
    @Autowired
    ItineraryRepository itineraryRepo;

    @Autowired
    UserRepository userRepo;

    @GetMapping
    public ResponseEntity<List<Itinerary>> getAllItineraries(){
        List<Itinerary> itineraryRecords =  (List<Itinerary>)itineraryRepo.findAll();
        return ResponseEntity.ok().body(itineraryRecords);
    }

    @GetMapping(value="/{userId}")
    public ResponseEntity<Itinerary> getUserItinerary(@PathVariable int userId){
        Optional<Itinerary> userItinerary = itineraryRepo.findByUserId(userId);
        if (userItinerary.isPresent()) {
            return ResponseEntity.ok().body(userItinerary.get());
        }else{
            return ResponseEntity.ok().build();
        }
    }
    
    @PostMapping(value="/{userId}")
    public ResponseEntity addDestination(@PathVariable int userId){
        return ResponseEntity.ok().build();
    }

    @PutMapping(value="/{userId}")
    public ResponseEntity updateDestination(@PathVariable int userId){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteUserItinerary(){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteDestination(){
        return ResponseEntity.ok().build();
    }

}

