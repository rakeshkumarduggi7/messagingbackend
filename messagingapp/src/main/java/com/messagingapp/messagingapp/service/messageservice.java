package com.messagingapp.messagingapp.service;

import com.messagingapp.messagingapp.model.messages;
import com.messagingapp.messagingapp.model.messageto;
import com.messagingapp.messagingapp.repo.messagerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;



@Service
public class messageservice {
    @Autowired
messagerepo mrepo;

    public List<String> sendmessage(String usern,messageto mes){
messages mess=new messages();
        mess.setMessage(mes.getMessage());
        mess.setUsername(usern);
        mess.setReciever(mes.getToun());
        mess.setTimestamp(LocalDateTime.now());
        mrepo.save(mess);
        return mrepo.getconv(usern,mes.getToun());
    }
}
