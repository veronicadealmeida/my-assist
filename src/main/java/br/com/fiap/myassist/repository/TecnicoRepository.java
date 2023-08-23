package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.OrdemServico;
import br.com.fiap.myassist.entity.Tecnico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

    Page<Tecnico> findByEmail(String email, Pageable pageable);

    Optional<Tecnico> findByEmail(String email);

    List<Tecnico> findByEmailIgnoreCaseAndIdNot(String email, Long id);

    @Query("select os from OrdemServico os join os.responsaveis t where t.id = :idTecnico")
    List<OrdemServico> findOrdensServicoBy(Long idTecnico);

}
