package fahd.net.account_service.web;

import fahd.net.account_service.clients.CustomerRestClient;
import fahd.net.account_service.entities.BankAccount;
import fahd.net.account_service.model.Customer;
import fahd.net.account_service.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountRepository bankAccountRepository ,CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        bankAccountList.forEach(bankAccount -> {
            bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
        });
        return bankAccountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){

        BankAccount account = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        System.out.println(customer.toString());
        System.out.println(account.toString());

        return account;
    }
}
