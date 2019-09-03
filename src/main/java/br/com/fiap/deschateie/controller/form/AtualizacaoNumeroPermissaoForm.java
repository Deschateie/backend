package br.com.fiap.deschateie.controller.form;

import javax.validation.constraints.NotNull;

import br.com.fiap.deschateie.model.NumeroPermissao;
import br.com.fiap.deschateie.model.Usuario;
import br.com.fiap.deschateie.repository.UsuarioRepository;

public class AtualizacaoNumeroPermissaoForm {

	@NotNull
	private NumeroPermissao numeroPermissao;

	public NumeroPermissao getNumeroPermmissao() {
		return numeroPermissao;
	}

	public void setNumeroPermmissao(NumeroPermissao numeroPermissao) {
		this.numeroPermissao = numeroPermissao;
	}

	public Usuario atualizar(Long codigo, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(codigo);
		usuario.setNumeroPermissao(this.numeroPermissao);
		return usuario;
	}
	
}
