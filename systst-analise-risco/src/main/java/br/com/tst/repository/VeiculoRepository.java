package br.com.tst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tst.domain.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
}
