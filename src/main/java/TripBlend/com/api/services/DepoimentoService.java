package TripBlend.com.api.services;

import TripBlend.com.api.Depoimento;
import TripBlend.com.api.dtos.DepoimentosDTO;
import TripBlend.com.api.excecoes.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import TripBlend.com.api.repository.DepoimentosRepository;

@Service
public class DepoimentoService {
    @Autowired
    private DepoimentosRepository depoimentosRepository;

    public Page<DepoimentosDTO> listarDepoimentos(Pageable pageable) {
        Page<Depoimento> depoimentos = depoimentosRepository.findAll(pageable);
        return depoimentos.map(DepoimentosDTO::fromEntity);
    }

    public DepoimentosDTO atualizarDepoimento(Long id, DepoimentosDTO depoimentoDTO) {

        Depoimento depoimento = depoimentosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Depoimento não encontrado com id: " + id));

        // Atualizar os campos (exceto o ID)
        depoimento.setNome(depoimentoDTO.nome());
        depoimento.setDepoimento(depoimentoDTO.depoimento());
        depoimento.setFoto(depoimentoDTO.foto());

        // Salvar as alterações no banco
        Depoimento atualizado = depoimentosRepository.save(depoimento);

        // Converter para DTO
        return DepoimentosDTO.fromEntity(atualizado);
    }
}
