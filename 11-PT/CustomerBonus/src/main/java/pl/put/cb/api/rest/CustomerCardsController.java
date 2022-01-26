package pl.put.cb.api.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.cb.dao.CustomersDAO;
import pl.put.cb.model.Customer;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/customer_cards")
public class CustomerCardsController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerCardsController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Integer> get(@RequestParam(value="threshold", defaultValue="1.0") Double threshold) {
        List<Integer> customerIds = new ArrayList<Integer>();

        Double avspend = averageSpendings();

        for (Customer customer : CustomersDAO.getInstance().getCustomers()){
            if (avspend > 0.0 &&
                    customer.getSpendings() / avspend >= threshold){
                customerIds.add(customer.getId());
                logger.debug(customer.getId()+"");
            }
        }
        return customerIds;
    }

    private Double averageSpendings() {
        Double result = 0.0;
        List<Customer> inst = CustomersDAO.getInstance().getCustomers();
        if (inst.isEmpty()) return result;

        for (Customer customer : inst){
            result += customer.getSpendings();
        }

        return result / inst.size();
    }


}


