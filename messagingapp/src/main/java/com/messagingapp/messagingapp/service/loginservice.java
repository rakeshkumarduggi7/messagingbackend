package com.messagingapp.messagingapp.service;

import com.messagingapp.messagingapp.model.logindetails;
import com.messagingapp.messagingapp.repo.loginrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class loginservice {
    @Autowired
    loginrepo repo;
    public int checklogin(logindetails ld){
        Optional<logindetails> l= repo.findById(ld.getUsername());
        if(l.isPresent()) {
            logindetails d = l.get();
            if (d.getPassword().equals(ld.getPassword())) return 1;
        }
        return -1;
    }
    public int signup(logindetails ld){
        Optional<logindetails> l=repo.findById(ld.getUsername());
        if(l.isEmpty()){
            logindetails ll=new logindetails();
            ll.setUsername(ld.getUsername());
            ll.setPassword(ld.getPassword());
            repo.save(ll);
            return 1;
        }
        return -1;
    }
    public List<String> suggest(String un){
        return repo.friendsuggestion(un);
    }
}
