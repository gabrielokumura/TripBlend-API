package TripBlend.com.api.dtos;

import TripBlend.com.api.Depoimento;

import java.time.LocalDateTime;

public record DepoimentosDTO(Long id, String foto, String depoimento,
                             String nome, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {

    public static DepoimentosDTO fromEntity(Depoimento depoimento) {
        return new DepoimentosDTO(
                depoimento.getId(),
                depoimento.getFoto(),
                depoimento.getDepoimento(),
                depoimento.getNome(),
                depoimento.getCriadoEm(),
                depoimento.getAtualizadoEm()
        );
    }
}
