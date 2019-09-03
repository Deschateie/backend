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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.deschateie.controller.dto.PsicologoDTO;
import br.com.fiap.deschateie.controller.form.AtualizacaoPsicologoForm;
import br.com.fiap.deschateie.controller.form.PsicologoForm;
import br.com.fiap.deschateie.model.Psicologo;
import br.com.fiap.deschateie.repository.PsicologoRepository;

@RestController
@RequestMapping("/psicologos")
public class PsicologoController {

	@Autowired
	private PsicologoRepository psicologoRepository;

	@GetMapping
	public Page<PsicologoDTO> listar(
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) String email,
			@PageableDefault(sort = "codigo", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Psicologo> psicologos;
		if(nome != null) {
			psicologos = psicologoRepository.findByNome(nome, paginacao);
		}else if(email != null) {
			psicologos = psicologoRepository.findByEmail(email, paginacao);
		}else {
			psicologos = psicologoRepository.findAll(paginacao);			
		}
		return PsicologoDTO.converter(psicologos);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<PsicologoDTO> buscarPorCodigo(@PathVariable Long codigo){
		Optional<Psicologo> psicologo = psicologoRepository.findById(codigo);
		if(psicologo.isPresent()) {
			return ResponseEntity.ok(new PsicologoDTO(psicologo.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PsicologoDTO> cadastrar(@RequestBody @Valid PsicologoForm form, UriComponentsBuilder uriBuilder){
		Psicologo psicologo = form.converter();
		psicologoRepository.save(psicologo);
		
		URI uri = uriBuilder.path("/psicologos/{codigo}").buildAndExpand(psicologo
				.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new PsicologoDTO(psicologo));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<PsicologoDTO> atualizar(@PathVariable Long codigo,
			@RequestBody @Valid AtualizacaoPsicologoForm form){
		Optional<Psicologo> optional = psicologoRepository.findById(codigo);
		if(optional.isPresent()) {
			Psicologo psicologo = form.atualizar(codigo, psicologoRepository);
			return ResponseEntity.ok(new PsicologoDTO(psicologo));
		}
		return ResponseEntity.notFound().build();
	}
	
}
