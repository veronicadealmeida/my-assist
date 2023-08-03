package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
}
