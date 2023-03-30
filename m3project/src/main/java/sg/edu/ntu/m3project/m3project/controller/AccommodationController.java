package sg.edu.ntu.m3project.m3project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.m3project.m3project.entity.Accommodation;
import sg.edu.ntu.m3project.m3project.repo.AccommodationRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/accommodation")

public class AccommodationController {

    @Autowired
    AccommodationRepository accommodationRepo;

    @GetMapping
    public ResponseEntity<List<Accommodation>> getAllAccommodations() {
        try {
            List<Accommodation> accommodations = (List<Accommodation>) accommodationRepo.findAll();
            return ResponseEntity.ok().body(accommodations);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Accommodation> createAccommodation(@RequestBody Accommodation accommodation) {

        try {
            Accommodation created = accommodationRepo.save(accommodation);
            return new ResponseEntity(created, HttpStatus.CREATED);
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}
