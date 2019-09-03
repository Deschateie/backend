package br.com.fiap.deschateie.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.deschateie.controller.dto.UsuarioDTO;
import br.com.fiap.deschateie.controller.form.AtualizacaoNumeroPermissaoForm;
import br.com.fiap.deschateie.controller.form.AtualizacaoUsuarioForm;
import br.com.fiap.deschateie.controller.form.UsuarioForm;
import br.com.fiap.deschateie.model.Usuario;
import br.com.fiap.deschateie.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public Page<UsuarioDTO> listar(@RequestParam(required = false) String nome,
			@RequestParam(required = false) String email,
			@PageableDefault(sort = "codigo", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Usuario> usuarios;
		if (nome != null) {
			usuarios = usuarioRepository.findByNome(nome, paginacao);
		} else if (email != null) {
			usuarios = usuarioRepository.findByEmail(email, paginacao);
		} else {
			usuarios = usuarioRepository.findAll(paginacao);
		}
		return UsuarioDTO.converter(usuarios);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<UsuarioDTO> buscarPorCodigo(
			@PathVariable Long codigo) {
		Optional<Usuario> usuarios = usuarioRepository.findById(codigo);
		if (usuarios.isPresent()) {
			return ResponseEntity.ok(new UsuarioDTO(usuarios.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDTO> cadastrar(
			@RequestBody @Valid UsuarioForm form,
			UriComponentsBuilder uriBuilder) {
		Usuario usuarioEncontrado = usuarioRepository.findByEmail(form
				.getEmail());
		Usuario usuario;
		if (usuarioEncontrado != null) {
			usuario = usuarioEncontrado;
		} else {
			usuario = form.converter();
			usuarioRepository.save(usuario);
		}
		URI uri = uriBuilder.path("/usuarios/{codigo}").buildAndExpand(usuario
				.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
	}

	@PutMapping("/{codigo}")
	@Transactional
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long codigo,
			@RequestBody @Valid AtualizacaoUsuarioForm form) {
		Optional<Usuario> optional = usuarioRepository.findById(codigo);
		if (optional.isPresent()) {
			Usuario usuario = form.atualizar(codigo, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDTO(usuario));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long codigo) {
		Optional<Usuario> usuario = usuarioRepository.findById(codigo);
		if (usuario.isPresent()) {
			usuarioRepository.deleteById(codigo);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/info/{codigo}")
	@Transactional
	public ResponseEntity<UsuarioDTO> atualizarNumeroPermissaoDoUsuario(@PathVariable Long codigo,
			@RequestBody @Valid AtualizacaoNumeroPermissaoForm form) {
		Optional<Usuario> optional = usuarioRepository.findById(codigo);
		if (optional.isPresent()) {
			Usuario usuario = form.atualizar(codigo, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDTO(usuario));
		}
		return ResponseEntity.notFound().build();
	}

}
