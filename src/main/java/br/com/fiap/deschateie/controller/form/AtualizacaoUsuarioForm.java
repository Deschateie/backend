package br.com.fiap.deschateie.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.deschateie.model.Genero;
import br.com.fiap.deschateie.model.Usuario;
import br.com.fiap.deschateie.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {

	@NotNull @NotEmpty @Length(max=50, min=3)
	private String nome;
	@NotNull
	private LocalDateTime dataNascimento;
	@NotNull
	private Genero genero;
	
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

	public Usuario atualizar(Long codigo, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(codigo);
	
		usuario.setNome(this.nome);
		usuario.setDataNascimento(this.dataNascimento);
		usuario.setGenero(this.genero);
		
		return usuario;
	}

}
