package dev.anderson.med.voll.api.domain.Consulta.Validacoes;

import org.springframework.stereotype.Component;

import dev.anderson.med.voll.api.domain.Consulta.ConsultaRepository;
import dev.anderson.med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import dev.anderson.med.voll.api.infra.Exception.ValidacaoException;

@Component
public class ValidacaoMedicoConsultaHorario implements ValidacaoAgendamentoConsulta {

    private final ConsultaRepository repository;

    public ValidacaoMedicoConsultaHorario(ConsultaRepository repository) {
        this.repository = repository;
    }

    public void validar(DadosAgendamentoConsulta dados) {
        boolean medicoConsultaHorario = repository.existsByIdAndData(dados.idMedico(), dados.data());

        if (medicoConsultaHorario) {
            throw new ValidacaoException("Médico já possui consulta marcada para o horário");
        }
    }
}
