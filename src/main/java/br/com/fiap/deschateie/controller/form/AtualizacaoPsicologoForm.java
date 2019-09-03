package br.com.fiap.deschateie.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.deschateie.model.Genero;
import br.com.fiap.deschateie.model.Psicologo;
import br.com.fiap.deschateie.repository.PsicologoRepository;

public class AtualizacaoPsicologoForm {

	
	@NotNull @NotEmpty @Length(max=50, min=3)
	private String nome;
	@NotNull
	private LocalDateTime dataNascimento;
	@NotNull
	private Genero genero;
	@NotNull @Length(max = 50)
	private String formacao;
	@NotNull @Length(max = 500)
	private String biografia;
	@NotNull
	private Long telefone;
	@NotNull
	private Double valorConsulta;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public Psicologo atualizar(Long codigo,
			PsicologoRepository psicologoRepository) {
		Psicologo psicologo = psicologoRepository.getOne(codigo);
		
		psicologo.setNome(this.nome);
		psicologo.setDataNascimento(this.dataNascimento);
		psicologo.setGenero(this.genero);
		psicologo.setFormacao(this.formacao);
		psicologo.setBiografia(this.biografia);
		psicologo.setTelefone(this.telefone);
		psicologo.setValorConsulta(this.valorConsulta);
		
		System.out.println(this.nome);
		System.out.println(this.dataNascimento);
		System.out.println(this.genero);
		System.out.println(this.formacao);
		System.out.println(this.biografia);
		System.out.println(this.telefone);
		System.out.println(this.valorConsulta);
		
		return psicologo;
	}
	
	
	
}
