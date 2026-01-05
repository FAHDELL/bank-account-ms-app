package fahd.net.customer_service.repositories;

import fahd.net.customer_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository  extends JpaRepository<Customer,Long> {
}
