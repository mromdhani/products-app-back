package be.businesstraining.rest;

import be.businesstraining.domain.Product;
import be.businesstraining.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductsRestController {

    @Autowired
    private IProductsRepository repository;

    @GetMapping("")
    public List<Product> getAll() {
        return repository.findAll();
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
