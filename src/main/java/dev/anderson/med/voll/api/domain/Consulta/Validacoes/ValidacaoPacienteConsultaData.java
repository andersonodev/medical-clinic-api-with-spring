package dev.anderson.med.voll.api.domain.Consulta.Validacoes;

import org.springframework.stereotype.Component;

import dev.anderson.med.voll.api.domain.Consulta.ConsultaRepository;
import dev.anderson.med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import dev.anderson.med.voll.api.infra.Exception.ValidacaoException;

import java.time.LocalDateTime;

@Component
public class ValidacaoPacienteConsultaData implements ValidacaoAgendamentoConsulta {

    private final ConsultaRepository repository;

    public ValidacaoPacienteConsultaData(ConsultaRepository repository) {
        this.repository = repository;
    }

    public void validar(DadosAgendamentoConsulta dados) {
        LocalDateTime horarioPrimeiraConsulta = dados.data().withHour(7);
        LocalDateTime horarioUltimaConsulta = dados.data().withHour(18);
        boolean pacienteConsultaData = repository.existsByIdAndDataBetween(dados.idPaciente(), horarioPrimeiraConsulta, horarioUltimaConsulta);

        if (pacienteConsultaData) {
            throw new ValidacaoException("Paciente já possui consulta marcada para esta data");
        }
    }
}
