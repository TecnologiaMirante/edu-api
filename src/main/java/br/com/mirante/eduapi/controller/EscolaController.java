package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.EscolaDTO;
import br.com.mirante.eduapi.mappers.EscolaMapper;
import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.service.EscolaService;
import br.com.mirante.eduapi.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna Dados das Escolas", name = "Escola")
@RequestMapping("/escola")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @GetMapping("/findAllEscolas")
    @Operation(summary = "Consultar Escolas.", description = "Endpoint para consultar Escolas.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<EscolaDTO>> findAllEscolas(SpecTemplate.EscolaSpec spec, Pageable page) {
        Page<Escola> consultaPage = escolaService.findAllEscolas(spec, page);
        if (consultaPage.isEmpty()) {
            return new ResponseEntity<>(consultaPage.map(EscolaMapper.INSTANCE::escolaToEscolaDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(EscolaMapper.INSTANCE::escolaToEscolaDTO), HttpStatus.OK);
        }
    }

    @PostMapping()
    @Operation(summary = "Cadastrar Escolas.", description = "Endpoint para cadastrar Escolas.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EscolaDTO> create(@RequestBody EscolaDTO escolaDTO) {
        EscolaDTO savedEscola = escolaService.save(escolaDTO);
        return ResponseEntity.ok(savedEscola);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Escola.", description = "Endpoint para buscar a escolas pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EscolaDTO> getById(@PathVariable Long id) {
        return escolaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }





}
