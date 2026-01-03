package fahd.net.account_service.repositories;

import fahd.net.account_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository  extends JpaRepository<BankAccount,String> {
}
