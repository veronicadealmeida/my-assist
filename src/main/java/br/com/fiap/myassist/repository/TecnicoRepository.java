package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {


    Optional<Tecnico> findByEmail(String email);


}
