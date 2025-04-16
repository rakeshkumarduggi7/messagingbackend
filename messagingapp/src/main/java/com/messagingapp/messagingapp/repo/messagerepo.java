package com.messagingapp.messagingapp.repo;

import com.messagingapp.messagingapp.model.messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface messagerepo extends JpaRepository<messages,Integer> {

    @Query(value = "select concat(username,'  '),concat(message,'   '),timestamp from messages where username=:un or username=:re order by timestamp",nativeQuery = true)
    public List<String> getconv(@Param("un")String un,@Param("re")String re);

}
