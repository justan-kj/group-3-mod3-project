package sg.edu.ntu.m3project.m3project.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sg.edu.ntu.m3project.m3project.entity.Transport;

@Repository
public class TransportRepository extends CrudRepository<Transport, Integer>{
    
}
