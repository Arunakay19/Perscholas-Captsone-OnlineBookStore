
package org.perscholas.onlinebookstore.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlinebookstore.data.CustomerRepoI;
import org.perscholas.onlinebookstore.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class CustomerService {

    CustomerRepoI myUserRepoI;
//    OrderSe courseRepoI;

    @Autowired
    public CustomerService(CustomerRepoI myUserRepoI) {
        this.myUserRepoI = myUserRepoI;
    }
}
/*
    public Customer getCustomerById(Integer id) {
        Optional<Customer> optional = myUserRepoI.findById(id);
        return optional.get();
    }

    public Customer findByEmailAndPassword(String email, String password) {
        Optional<Customer> optional = myUserRepoI.findByEmailAndPassword(email, password);
        return optional.get();
    }

    public Customer findByEmail(String email) {
        Optional<Customer> optional = myUserRepoI.findByEmailAllIgnoreCase(email);
        return optional.get();
    }

   /* public Customer getOrCreateOrderById(String customer_id, String order_id) throws Exception {

        if(myUserRepoI.findByEmailAllIgnoreCase(email).isPresent() ) {
            Customer myUser = myUserRepoI.findByEmailAllIgnoreCase(email).get();
//            Course course = courseRepoI.findByNameAllIgnoreCase(courseName).get();
//            myUser.addCourse(course);
            return myUser;

        } else {
            throw new Exception("saving a order to the customer " + email + " did not go well!!!!!");
        }
    }*/

/*
    public Customer createOrUpdate(Customer user){
        if(myUserRepoI.findByEmailAllIgnoreCase(user.getEmail()).isPresent()) {
            log.debug("Customer email " + user.getEmail() + " exists!");
            Customer originalUser = myUserRepoI.findByEmailAllIgnoreCase(user.getEmail()).get();
            originalUser.setFirstName(user.getFirstName());
            originalUser.setLastName(user.getLastName());
            originalUser.setPassword(user.getPassword());
            return myUserRepoI.save(originalUser);
        } else {
            log.debug("Customer email " + user.getEmail() + " do not exists!");
            return myUserRepoI.save(user);
        }

    }

}
*/