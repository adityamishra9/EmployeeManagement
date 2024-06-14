package com.tuto.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmRepo extends JpaRepository<EmEntity, Long>{
    //custom methods like findByName etc can be written here
}
