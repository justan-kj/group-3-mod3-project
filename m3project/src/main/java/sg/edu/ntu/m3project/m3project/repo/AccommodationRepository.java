package sg.edu.ntu.m3project.m3project.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sg.edu.ntu.m3project.m3project.entity.Accommodation;

@Repository
public interface AccommodationRepository extends CrudRepository<Accommodation, Integer>{
    
}