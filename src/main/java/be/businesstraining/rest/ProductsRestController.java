package be.businesstraining.rest;

import be.businesstraining.domain.Product;
import be.businesstraining.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductsRestController {

    @Autowired
    private IProductsRepository repository;

    @GetMapping("")
   // @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Product> getAll() {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {

        Optional<Product> compte = repository.findById(id);
	    if (!compte.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(compte.get());
    }


    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        Product result = repository.save(product);
        return (result != null)?
                   new ResponseEntity<>(result, HttpStatus.CREATED)
                  : new ResponseEntity<>(HttpStatus.CONFLICT);

    }
}
