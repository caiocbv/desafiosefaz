package main;


import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import main.dao.UsuarioDao;
import main.model.Telefone;
import main.model.Usuario;
import main.repository.UsuarioRepository;

@SpringBootApplication
public class SpringExemplo {
	
	static ConfigurableApplicationContext context;
	
	public static void main(String[] args) {
		context = SpringApplication.run(SpringExemplo.class, args);
		//UsuarioDao userDao = context.getBean(UsuarioDao.class);
		UsuarioRepository userRep = context.getBean(UsuarioRepository.class);
		
		
		Usuario user = new Usuario();
		
		user.setNome("Fulano");
		user.setSenha("123123");
		user.setEmail("fulano@gmail.com");
		Telefone principal = new Telefone();
		
		principal.setDdd(81);
		principal.setNumero("9 99887766");
		principal.setTipo("celular");
		principal.setUsuario(user);
		
		user.getTelefones().add(principal);
		
		//userDao.adicionarUsuario(user);
		userRep.save(user);
		
		Usuario user2 = new Usuario();
		user2.setNome("Sicrano");
		user2.setSenha("111111");
		user2.setEmail("sicrano@gmail.com");
		principal = new Telefone();
		principal.setDdd(81);
		principal.setNumero("9 98756432");
		principal.setTipo("celular");
		principal.setUsuario(user2);
		user2.getTelefones().add(principal);
		
		//userDao.adicionarUsuario(user2);
		userRep.save(user2);
		
		List<Usuario> users = userRep.findAll();
		for (Usuario usuario : users) {
			System.out.println(usuario.getNome());
		}
		
		
		
	}

}
