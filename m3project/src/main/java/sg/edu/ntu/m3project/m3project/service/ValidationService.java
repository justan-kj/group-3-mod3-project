package sg.edu.ntu.m3project.m3project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sg.edu.ntu.m3project.m3project.entity.Accommodation;
import sg.edu.ntu.m3project.m3project.entity.Destination;
import sg.edu.ntu.m3project.m3project.entity.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class ValidationService {
    Dotenv dotenv = Dotenv.load();
    private final RestTemplate restTemplate = new RestTemplate();

    public void validateName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (!name.matches("^[a-zA-Z\\s]*$")) {
            throw new IllegalArgumentException("Name can only contain letters and spaces");
        }
    }

    public void validatePrice(Float price) throws IllegalArgumentException {
        if (price == null || price < 0) {
            throw new IllegalArgumentException("Price cannot be empty or negative");
        }
        if (!Float.toString(price).matches("^\\d*\\.?\\d+$")) {
            throw new IllegalArgumentException("Price can only contain numeric digits and decimals");         
        }
    }

    public void validateCity(String city) throws IllegalArgumentException {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        String geoNamesUri = "http://api.geonames.org/searchJSON?name=" + city + "&maxRows=1&username=" + dotenv.get("GEONAMES_USERNAME");
        Integer count = restTemplate.getForObject(geoNamesUri, GeonamesResponse.class).getTotalResultsCount();
        if (count == null || count == 0) {
            throw new IllegalArgumentException("City does not exist");
        }
    }

    public void validateCountry(String country) throws IllegalArgumentException {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be empty");
        }
        String geoNamesUri = "http://api.geonames.org/searchJSON?name=" + country + "&maxRows=1&featureCode=PCLI&username=" + dotenv.get("GEONAMES_USERNAME");
        Integer count = restTemplate.getForObject(geoNamesUri, GeonamesResponse.class).getTotalResultsCount();
        if (count == null || count == 0) {
            throw new IllegalArgumentException("Country does not exist");
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

    private static class GeonamesResponse {
        private Integer totalResultsCount;

        public Integer getTotalResultsCount() {
            return totalResultsCount;
        }

        public void setTotalResultsCount(Integer totalResultsCount) {
            this.totalResultsCount = totalResultsCount;
        }
    }
}
