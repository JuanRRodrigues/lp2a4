package resources;

import entities.Plate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import services.PlateService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/plates")
public class PlateResource {
    @Autowired
    private PlateService service;

    @GetMapping
    public ResponseEntity<List<Plate>> findAll(){
        List<Plate> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping (value = "/{id}")
    public ResponseEntity<Plate> findById(@PathVariable Long id){
        Plate obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Plate> insert(@RequestBody Plate obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Plate> update(@PathVariable Long id,@RequestBody Plate obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
