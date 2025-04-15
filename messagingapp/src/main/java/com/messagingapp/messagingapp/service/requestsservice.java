package com.messagingapp.messagingapp.service;

import com.messagingapp.messagingapp.model.friendslist;
import com.messagingapp.messagingapp.model.requests;
import com.messagingapp.messagingapp.repo.friendsrepo;
import com.messagingapp.messagingapp.repo.requestsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class requestsservice {
    @Autowired
    requestsrepo rrepo;
    @Autowired
    friendsrepo frrepo;
    public void sendrequest(requests rs){
        rrepo.save(rs);
    }

    public List<String> getrequests(String usern) {
return rrepo.getrequests(usern);
    }

    public void acceptrequest(String un,String from) {
        rrepo.acceptrequest(un,from);
        friendslist frlist=new friendslist();
        frlist.setFriend(un);
        frlist.setUsername(from);
frrepo.save(frlist);
          frlist=new friendslist();
        frlist.setFriend(from);
        frlist.setUsername(un);
        frrepo.save(frlist);
    }
    public List<String> friends(String usern){
        return frrepo.friends(usern);
    }
}
