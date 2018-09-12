package be.businesstraining.repository;

import be.businesstraining.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductsRepository
                 extends JpaRepository<Product, Long> {
}
