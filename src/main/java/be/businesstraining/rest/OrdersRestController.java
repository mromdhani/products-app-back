package be.businesstraining.rest;

import be.businesstraining.domain.Order;
import be.businesstraining.domain.Product;
import be.businesstraining.repository.IOrdersRepository;
import be.businesstraining.repository.IProductsRepository;
import org.hibernate.boot.model.source.spi.Orderable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrdersRestController {

    @Autowired
    private IOrdersRepository repoOrders;

    @Autowired
    private IProductsRepository repoProducts;

    @GetMapping("/all")
    public List<Order> findAllOrders() {
        return repoOrders.findAll();
    }
    @GetMapping("/user/{id}")
    public List<Order> findAllOrdersByUserId(@PathVariable Long id) {

        return null;
    }

    @GetMapping("/user/current")
    public List<Order> findAllOrdersForCurrentUser() {
        return null;
    }

    // These actions are here just for testing purposes
    @GetMapping("/add/test")
    public ResponseEntity<Order> testAddOrder() {

        Order order = new Order();
        order.setDate(LocalDateTime.now());



        return order;
    }
}
