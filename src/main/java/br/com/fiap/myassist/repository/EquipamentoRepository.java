package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
}
