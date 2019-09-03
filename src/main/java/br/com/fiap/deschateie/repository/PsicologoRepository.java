package br.com.fiap.deschateie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.deschateie.model.Psicologo;

public interface PsicologoRepository extends JpaRepository<Psicologo, Long>{

	Page<Psicologo> findByNome(String nome, Pageable paginacao);

	Page<Psicologo> findByEmail(String email, Pageable paginacao);

}
