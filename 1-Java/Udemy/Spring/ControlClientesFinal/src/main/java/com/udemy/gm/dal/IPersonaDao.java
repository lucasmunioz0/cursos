package com.udemy.gm.dal;

import com.udemy.gm.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDao extends JpaRepository<Persona, Long>{
    
}
