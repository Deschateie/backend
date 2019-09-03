package br.com.fiap.deschateie.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.fiap.deschateie.model.Genero;
import br.com.fiap.deschateie.model.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private Genero genero;
	private LocalDateTime dataNascimento;
	
	
	
	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getCodigo();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.genero = usuario.getGenero();
		this.dataNascimento = usuario.getDataNascimento();
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public Genero getGenero() {
		return genero;
	}
	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}
	public static Page<UsuarioDTO> converter(Page<Usuario> usuarios) {
		return usuarios.map(UsuarioDTO::new);
	}
}
