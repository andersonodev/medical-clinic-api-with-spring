package dev.anderson.med.voll.api.domain.Paciente;

import dev.anderson.med.voll.api.domain.Dados.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record AtualizaPaciente(
    @NotNull
    Long id,
    String nome,
    String telefone,
    DadosEndereco endereco
) {
}
