package com.messagingapp.messagingapp.repo;

import com.messagingapp.messagingapp.model.friendslist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface friendsrepo extends JpaRepository<friendslist,Integer> {

    @Query(value = "select friend from friendslist where username =:un",nativeQuery = true)
    public List<String> friends(@Param("un") String un);
}
