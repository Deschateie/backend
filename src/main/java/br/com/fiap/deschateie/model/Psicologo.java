package br.com.fiap.deschateie.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="T_DES_PSICOLOGO")
@PrimaryKeyJoinColumn(name="codigo")
public class Psicologo extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3035904872089262853L;
	private Long crp;
	private String formacao;
	private String biografia;
	private Long telefone;
	private Double valorConsulta;
	
	public Psicologo(Long crp, String formacao, String biografia,
			Long telefone, Double valorConsulta) {
		super();
		this.crp = crp;
		this.formacao = formacao;
		this.biografia = biografia;
		this.telefone = telefone;
		this.valorConsulta = valorConsulta;
	}
	
	
	public Psicologo(String nome, String email, LocalDateTime dataNascimento,
			String login, String senha, NumeroPermissao numeroPermissao,
			Genero genero, Long crp, String formacao, String biografia,
			Long telefone, Double valorConsulta) {
		super(nome, email, dataNascimento, login, senha, numeroPermissao,
				genero);
		this.crp = crp;
		this.formacao = formacao;
		this.biografia = biografia;
		this.telefone = telefone;
		this.valorConsulta = valorConsulta;
	}



	public Psicologo(String nome, String email, LocalDateTime dataNascimento,
			Genero genero, Long crp, String formacao, String biografia,
			Long telefone, Double valorConsulta) {
		super(nome, email, dataNascimento, NumeroPermissao.P1, genero);
		this.crp = crp;
		this.formacao = formacao;
		this.biografia = biografia;
		this.telefone = telefone;
		this.valorConsulta = valorConsulta;
	}

	public Psicologo() {
		super();
	}
	
	public Psicologo(String nome, String email, LocalDateTime dataNascimento,
			String login, String senha, Genero genero, Long crp,
			String formacao, String biografia, Long telefone,
			Double valorConsulta) {
		super(nome, email, dataNascimento, login, senha, NumeroPermissao.P1, genero);
		this.crp = crp;
		this.formacao = formacao;
		this.biografia = biografia;
		this.telefone = telefone;
		this.valorConsulta = valorConsulta;
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
	
	
}
