package sg.edu.ntu.m3project.m3project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @PostMapping
    public ResponseEntity<Accommodation> createAccommodation(@RequestBody Accommodation accommodation) {

        try {
            Accommodation created = accommodationRepo.save(accommodation); // when "id" is not present, .save() will perform create operation.
            return new ResponseEntity(accommodationRepo.findById(created.getId()), HttpStatus.CREATED);
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/{accommodationId}")
    public ResponseEntity<Accommodation> updateAccommodation(@RequestBody Accommodation accommodation, @PathVariable Integer accommodationId) {
        Optional<Accommodation> currentAccommodation = accommodationRepo.findById(accommodationId);
        if (currentAccommodation.isPresent()) { // Check if the expected object is present
            try {
                Accommodation a = currentAccommodation.get(); // Get the object - Accommodation

                // Update the fetched accommodation with name, price sent via Request Body
                a.setName(accommodation.getName());
                a.setDescription(accommodation.getDescription());
                a.setPrice(accommodation.getPrice());

                accommodationRepo.save(a); // When "id" is present, .save() will perform update operation.
                return ResponseEntity.ok().body(a);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{accommodationId}")
    public ResponseEntity deleteAccommodation(@PathVariable int accommodationId) {
        boolean exist = accommodationRepo.existsById(accommodationId);
        if (exist) {
            try {
                accommodationRepo.deleteById(accommodationId);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}