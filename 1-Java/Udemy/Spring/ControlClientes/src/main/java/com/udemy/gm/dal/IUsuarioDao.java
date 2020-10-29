package com.udemy.gm.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import com.udemy.gm.domain.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}
