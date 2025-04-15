package com.messagingapp.messagingapp.repo;

import com.messagingapp.messagingapp.model.logindetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface loginrepo extends JpaRepository<logindetails,String > {

    @Query(value = "SELECT username FROM logindetails WHERE username <> :un", nativeQuery = true)
    List<String> friendsuggestion(@Param("un") String un);

}
