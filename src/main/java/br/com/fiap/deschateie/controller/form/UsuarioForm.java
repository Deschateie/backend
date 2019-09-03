package br.com.fiap.deschateie.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.deschateie.model.Genero;
import br.com.fiap.deschateie.model.Usuario;

public class UsuarioForm {

	@NotEmpty @NotNull @Length(max=50, min=3)
	private String nome;
	
	@NotEmpty @NotNull @Length(max=50)
	private String email;
	
	@NotNull
	private LocalDateTime dataNascimento;
	
	@NotNull
	private Genero genero;

	@NotNull
	private String login;
	
	@NotNull
	private String senha;
	
	public UsuarioForm() {
		super();
	}

	public UsuarioForm(String nome, String email, LocalDateTime dataNascimento,
			Genero genero, String login, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.login = login;
		this.senha = senha;
	}

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

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Usuario converter() {
		return new Usuario(nome, email, dataNascimento,login, senha, genero);
	}
	
	
	
}
