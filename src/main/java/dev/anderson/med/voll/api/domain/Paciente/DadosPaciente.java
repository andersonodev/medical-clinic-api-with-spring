package dev.anderson.med.voll.api.domain.Paciente;

import dev.anderson.med.voll.api.domain.Dados.Endereco;

public record DadosPaciente(
    Long id,
    String nome,
    String email,
    String cpf,
    Endereco endereco) {

    public DadosPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getEndereco());
    }
}
