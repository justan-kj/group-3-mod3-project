package sg.edu.ntu.m3project.m3project.service;

import org.springframework.stereotype.Service;
import sg.edu.ntu.m3project.m3project.entity.Accommodation;
import sg.edu.ntu.m3project.m3project.entity.Destination;
import sg.edu.ntu.m3project.m3project.entity.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidationService {

    private final List<String> existingCities = Arrays.asList("Singapore", "Tokyo", "Paris", "New York");
    private final List<String> existingCountries = Arrays.asList("Singapore", "Japan", "France", "USA");

    public void validateName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (!name.matches("^[a-zA-Z\\s]*$")) {
            throw new IllegalArgumentException("Name can only contain letters and spaces");
        }
    }

    public void validatePrice(Float price) throws IllegalArgumentException {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be empty or negative");
        }
        if (!Float.toString(price).matches("^\\d*\\.?\\d+$")) {
            throw new IllegalArgumentException("Price cannot be empty or negative");         
        }
    }

    public void validateCity(String city) throws IllegalArgumentException {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        if (!existingCities.contains(city)) {
            throw new IllegalArgumentException("Please enter a valid city name");
        }
    }

    public void validateCountry(String country) throws IllegalArgumentException {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be empty");
        }
        if (!existingCountries.contains(country)) {
            throw new IllegalArgumentException("Please enter a valid country");
        }
    }

    public void validateUser(User user) throws IllegalArgumentException {
        validateName(user.getEmail());
        validateName(user.getPassword());
        if (user.getAge() < 0 ) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (user.getGender() < 0) {
            throw new IllegalArgumentException("Gender cannot be negative");
        }
    }

    public void validateBudget(float budget) {
        if (!Float.toString(budget).matches("^\\d*\\.?\\d+$") || budget < 0) {
            throw new IllegalArgumentException("Price cannot be empty or negative");
        } else if (budget > 99999999) {
            throw new IllegalArgumentException("Budget limit exceeded.");
        }
    }

    public void validateAccommodation(Accommodation accommodation) throws IllegalArgumentException {
        validateName(accommodation.getName());
        validatePrice(accommodation.getPrice());
    }

    public void validateDestination(Destination destination) throws IllegalArgumentException {
        validateCity(destination.getCity());
        validateCountry(destination.getCountry());
    }
}