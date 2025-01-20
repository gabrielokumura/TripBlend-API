package TripBlend.com.api.controller;

import TripBlend.com.api.dtos.DepoimentosDTO;
import TripBlend.com.api.services.DepoimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depoimentos")
public class DepoimentosController {

    @Autowired
    private DepoimentoService depoimentoService;


    @GetMapping
    public ResponseEntity<Page<DepoimentosDTO>> listarTransacoes(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size, @RequestParam(defaultValue = "nome") String sort){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<DepoimentosDTO> depoimentos = depoimentoService.listarDepoimentos(pageable);
        return ResponseEntity.ok(depoimentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepoimentosDTO> atualizarDepoimento(@PathVariable Long id, @RequestBody DepoimentosDTO depoimentoDTO
    ) {
        // Atualizar o depoimento baseado no ID
        DepoimentosDTO atualizado = depoimentoService.atualizarDepoimento(id, depoimentoDTO);
        return ResponseEntity.ok(atualizado);
    }

}
