/*
 * Criado por Caio Bezerra Viana 
 */

package main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Usuario {
	
	/*
	 * 
	  	Nome [string]
		Email [string]
		Senha[string]
		Telefones [lista]
			. ddd [número]
			. Número [string]
			. Tipo [string]
	 */
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	@OneToMany(mappedBy = "usuario", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	
	
}
