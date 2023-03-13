
package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.service;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.data.UserRepoI;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.User;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class UserService {

    UserRepoI myUserRepoI;

    @Autowired
    public UserService(UserRepoI myUserRepoI) {
        this.myUserRepoI = myUserRepoI;
    }


//    public User getUserById(Integer id) {
//        Optional<Customer> optional = myUserRepoI.findById(id);
//        return optional.get();
//    }

    public User findByEmailAndPassword(String email, String password) {
        Optional<User> optional = myUserRepoI.findByEmailIgnoreCaseAndPassword(email, password);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public User findByEmail(String email) {
        Optional<User> optional = myUserRepoI.findByEmailAllIgnoreCase(email);
        return optional.get();
    }

    public List<User> getAllUsers() {
        return myUserRepoI.findAll();
    }

    public User addUser(User user) {
        return myUserRepoI.saveAndFlush(user);
    }

    public void deleteUser(Integer id) {
        if (id != null ) {
            myUserRepoI.deleteById(id);
        }
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
*/
}
