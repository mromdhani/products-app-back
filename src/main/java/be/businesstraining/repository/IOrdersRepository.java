package be.businesstraining.repository;

import be.businesstraining.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdersRepository extends JpaRepository<Order, Long> {
}
