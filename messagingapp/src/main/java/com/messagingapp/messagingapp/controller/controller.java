package com.messagingapp.messagingapp.controller;

import com.messagingapp.messagingapp.model.logindetails;
import com.messagingapp.messagingapp.model.messageto;
import com.messagingapp.messagingapp.model.requests;
import com.messagingapp.messagingapp.service.loginservice;
import com.messagingapp.messagingapp.service.messageservice;
import com.messagingapp.messagingapp.service.requestsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesapp")
public class controller {
    @Autowired
loginservice Loginservice;
    @Autowired
    requestsservice rservice;
    @Autowired
    messageservice mservice;
static private String usern;
    @PostMapping("/login")
    public String login(@RequestBody logindetails ld){
int a=Loginservice.checklogin(ld);
if(a==1){
    usern= ld.getUsername();
}
         return a==1?"login success":"no username found in database";
    }
    @PostMapping("/signup")
    public String signup(@RequestBody logindetails ld){
        int a=Loginservice.signup(ld);
        return a==1?"signup success":"username similar exists already find new one";
    }
@GetMapping("/suggest")
public List<String> suggest(){
            return Loginservice.suggest(usern);
}

    @PostMapping("/suggest/sendrequest")
    public String sendrequest(@RequestBody requests req){
rservice.sendrequest(req);
return "sent request to "+req.getToun();
    }
    @PostMapping("/requests")
    public List<String> getrquests( ){
return rservice.getrequests(usern);
    }

    @PostMapping("/acceptrequest")
    public String accrequest(@RequestParam String from){
        rservice.acceptrequest(usern,from);
        return "done";
    }
    @PostMapping("/friends")
    public List<String> friends( ){
return rservice.friends(usern);
    }
    @PostMapping("/friends/sendmessage")
    public List<String> sendmessage(@RequestBody messageto mes){
return mservice.sendmessage(usern,mes);
    }
}
