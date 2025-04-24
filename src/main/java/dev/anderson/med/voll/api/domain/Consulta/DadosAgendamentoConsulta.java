package dev.anderson.med.voll.api.domain.Consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

import dev.anderson.med.voll.api.domain.Medico.Especialidade;

public record DadosAgendamentoConsulta(
    Long idMedico,

    @NotNull
    Long idPaciente,

    @NotNull
    @Future
    LocalDateTime data,

    Especialidade especialidade) {
}
