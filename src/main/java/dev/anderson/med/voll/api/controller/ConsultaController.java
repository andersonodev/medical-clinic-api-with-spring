package dev.anderson.med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.anderson.med.voll.api.domain.Consulta.AgendaConsultas;
import dev.anderson.med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import dev.anderson.med.voll.api.domain.Consulta.DadosDetalhamentoConsulta;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    private final AgendaConsultas agendaConsultas;

    public ConsultaController(AgendaConsultas agendaConsultas) {
        this.agendaConsultas = agendaConsultas;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConsulta> agendarConsulta(@RequestBody @Valid DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var dto = agendaConsultas.agendarConsulta(dadosAgendamentoConsulta);
        return ResponseEntity.ok(dto);
    }
}
