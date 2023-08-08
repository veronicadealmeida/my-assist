package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.Equipamento;
import br.com.fiap.myassist.enums.TipoEquipamentoEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento,Long> {

    List<Equipamento> findByNumeroSerie(String numeroSerie);

    List<Equipamento> findByTipo(TipoEquipamentoEnum tipo);

}
