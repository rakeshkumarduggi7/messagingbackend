package com.messagingapp.messagingapp.repo;

import com.messagingapp.messagingapp.model.requests;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface requestsrepo extends JpaRepository<requests,Integer> {

    @Query(value = "select fromun from requests where toun =:un",nativeQuery = true)
    public List<String> getrequests(@Param("un")String un);

    @Modifying
    @Transactional
    @Query(value = "delete   from requests where toun =:usern and fromun =:un",nativeQuery = true)
    public void acceptrequest(@Param("usern")String usern,@Param("un")String un);
}
