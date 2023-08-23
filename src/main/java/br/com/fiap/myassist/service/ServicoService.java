package br.com.fiap.myassist.service;

import br.com.fiap.myassist.dto.ServicoAtualizacaoDTO;
import br.com.fiap.myassist.dto.ServicoInsercaoDTO;
import br.com.fiap.myassist.dto.ServicoResponseDTO;
import br.com.fiap.myassist.entity.Servico;
import br.com.fiap.myassist.repository.ServicoRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;
    private ModelMapper mapper = new ModelMapper();

    public List<ServicoResponseDTO> buscarTodos() {
        log.info("Inicio da busca no banco de dados");
        List<Servico> resultado = servicoRepository.findAll();
        log.info("Fim da busca no banco de dados");
        return resultado.stream()
                        .map(e -> mapper.map(e, ServicoResponseDTO.class))
                        .collect(Collectors.toList());
    }

    public Optional<ServicoResponseDTO> buscarPorId(Long id) {
        var resultado = servicoRepository.findById(id);
        if (resultado.isEmpty()) {
            return Optional.empty();
        }
        var dto = mapper.map(resultado.get(), ServicoResponseDTO.class);
        return Optional.of(dto);

        //return resultado.map(e -> mapper.map(e, ServicoResponseDTO.class));
    }


    public ServicoResponseDTO inserir(ServicoInsercaoDTO dto) {
        log.info("Busca de servicos existentes: {}", dto.getDescricao());
        //regra que não permite cadastrar servico com a mesma descricao
        var existente = servicoRepository.findByDescricaoIgnoreCase(dto.getDescricao());
        if (!existente.isEmpty()) {
            log.info("[AUDITOR] - Descricao '{}' já registrada", dto.getDescricao());
            throw new RuntimeException("Já existe um serviço cadastrado para a descrição informada");
        }
        var entidade = mapper.map(dto, Servico.class);
        var entidadeSalva = servicoRepository.save(entidade);
        return mapper.map(entidadeSalva, ServicoResponseDTO.class);
    }

    public Optional<ServicoResponseDTO> atualizar(Long id,
                                                  ServicoAtualizacaoDTO dto) {
        var resultado = servicoRepository.findById(id);
        if (resultado.isEmpty()) {
            return Optional.empty();
        }

        //Regra para não permitir salvar descrição repetida
        var existente = servicoRepository.findByDescricaoIgnoreCaseAndIdNot(dto.getDescricao(), id);
        if (!existente.isEmpty()) {
            throw new RuntimeException("Já existe um serviço cadastrado para a descrição informada");
        }

        var entidade = mapper.map(dto, Servico.class);
        var entidadeSalva = servicoRepository.save(entidade);
        return Optional.of(mapper.map(entidadeSalva, ServicoResponseDTO.class));
    }

    public Optional<ServicoResponseDTO> excluir(Long id) {
        var resultado = servicoRepository.findById(id);
        if (resultado.isEmpty()) {
            return Optional.empty();
        }

        //RN - Verifica se o serviço a ser excluído já foi usado
        //em um ItemServico. Caso verdadeiro, retorna um badRequest
        var itensExistentes = servicoRepository.findItensServico(id);
        if (!itensExistentes.isEmpty()) {
            throw new RuntimeException("O serviço já foi incluído em uma OS");
        }

        servicoRepository.deleteById(id);
        return Optional.of(new ServicoResponseDTO());
    }



}
