package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.ItemServico;
import br.com.fiap.myassist.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByValorGreaterThanEqual(BigDecimal valor);


    @Query("select is from ItemServico is where is.servico.id = :id")
    List<ItemServico> findItensServico(Long id);


    List<Servico> findByDescricaoIgnoreCase(String descricao);


    List<Servico> findByDescricaoIgnoreCaseAndIdNot(String descricao, Long id);


}
