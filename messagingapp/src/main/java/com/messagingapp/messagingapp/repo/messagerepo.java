package com.messagingapp.messagingapp.repo;

import com.messagingapp.messagingapp.model.messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface messagerepo extends JpaRepository<messages,Integer> {
}
