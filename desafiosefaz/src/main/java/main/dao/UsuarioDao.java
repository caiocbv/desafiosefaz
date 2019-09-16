package main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import main.model.Usuario;

@Repository
public class UsuarioDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void adicionarUsuario(Usuario usuario) {
		em.persist(usuario);
	}
	
	public List<Usuario> listarTodos(){
		return em.createQuery("SELECT e FROM Usuario e").getResultList();
	}
	
	public Usuario getUsuario(String email) {
		
		List<Usuario> todos = this.listarTodos();
		for (Usuario usuario : todos) {
			if(usuario.getEmail().matches(email)){
				return usuario;
			}
		}
		return null;
	}
	
	
	
}
