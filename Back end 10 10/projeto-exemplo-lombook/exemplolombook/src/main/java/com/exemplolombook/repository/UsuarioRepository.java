package com.exemplolombook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplolombook.entities.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

}
