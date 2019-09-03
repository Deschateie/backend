package br.com.fiap.deschateie.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.deschateie.model.Genero;
import br.com.fiap.deschateie.model.Psicologo;

public class PsicologoForm {

	@NotEmpty
	@NotNull
	@Length(max = 50, min = 3)
	private String nome;

	@NotEmpty
	@NotNull
	@Length(max = 50)
	private String email;

	@NotNull
	private LocalDateTime dataNascimento;

	@NotNull
	private String login;
	
	@NotNull
	private String senha;
	
	@NotNull
	private Genero genero;

	@NotNull
	private Long crp;

	@NotNull
	@Length(max = 50)
	private String formacao;

	@NotNull
	@Length(max = 500)
	private String biografia;

	@NotNull
	private Long telefone;

	@NotNull
	private Double valorConsulta;

	public PsicologoForm(String nome, String email,
			LocalDateTime dataNascimento, String login, String senha,
			Genero genero, Long crp, String formacao, String biografia,
			Long telefone, Double valorConsulta) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
		this.genero = genero;
		this.crp = crp;
		this.formacao = formacao;
		this.biografia = biografia;
		this.telefone = telefone;
		this.valorConsulta = valorConsulta;
	}
	
	public PsicologoForm() {
		super();
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

	public Long getCrp() {
		return crp;
	}

	public void setCrp(Long crp) {
		this.crp = crp;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(Double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public Psicologo converter() {
		return new Psicologo(nome, email, dataNascimento, login, senha, genero, crp, formacao, biografia, telefone, valorConsulta);
	}

}
