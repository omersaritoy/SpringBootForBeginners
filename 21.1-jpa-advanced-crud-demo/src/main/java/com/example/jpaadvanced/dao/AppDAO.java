package com.example.jpaadvanced.dao;

import com.example.jpaadvanced.entity.Instructor;
import org.springframework.stereotype.Repository;

@Repository
public interface AppDAO {
    void save(Instructor theInstructor);

}
