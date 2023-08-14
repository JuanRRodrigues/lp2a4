package services;


import Repositories.PlateRepository;
import entities.Plate;
import org.apache.catalina.User;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PlateService {

    @Autowired
    private PlateRepository repository;

    public List<Plate> findAll() {
        return repository.findAll();
    }

    public Plate findById(Long id) {
        Optional<Plate> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }
    public Plate insert(Plate obj){
        return repository.save(obj);
    }

    private void updateData(Plate entity, Plate obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
    }

}
