package dev.raniery.med.voll.api.domain.Medico;

import dev.raniery.med.voll.api.domain.Dados.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record AtualizaMedico(
    @NotNull
    Long id,
    String nome,
    String telefone,
    DadosEndereco endereco) {
}
