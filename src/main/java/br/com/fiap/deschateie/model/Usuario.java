package br.com.fiap.deschateie.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="T_DES_USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1382697321374411118L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	private String nome;
	
	private String email;
	
	private LocalDateTime dataNascimento;
	
	private String login;
	
	private String senha;
	
	@Enumerated(value=EnumType.STRING)
	private NumeroPermissao numeroPermissao = NumeroPermissao.P0;
	
	@Enumerated(value=EnumType.STRING)
	private Genero genero;

	
	
	public Usuario(String nome, String email, LocalDateTime dataNascimento,
			String login, String senha, Genero genero) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
		this.genero = genero;
	}
	

	public Usuario(String nome, String email, LocalDateTime dataNascimento,
			String login, String senha, NumeroPermissao numeroPermissao,
			Genero genero) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
		this.numeroPermissao = numeroPermissao;
		this.genero = genero;
	}




	public Usuario(String nome, String email, LocalDateTime dataNascimento,
			NumeroPermissao numeroPermissao, Genero genero) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.numeroPermissao = numeroPermissao;
		this.genero = genero;
	}



	public Usuario() {
		super();
	}

	public Usuario(String nome, String email, LocalDateTime dataNascimento,
			Genero genero) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public NumeroPermissao getNumeroPermissao() {
		return numeroPermissao;
	}

	public void setNumeroPermissao(NumeroPermissao numeroPermissao) {
		this.numeroPermissao = numeroPermissao;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}
