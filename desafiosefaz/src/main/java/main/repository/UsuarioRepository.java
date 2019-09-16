package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
