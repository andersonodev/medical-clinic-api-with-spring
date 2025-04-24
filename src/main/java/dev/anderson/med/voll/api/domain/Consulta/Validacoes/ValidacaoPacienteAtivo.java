package dev.anderson.med.voll.api.domain.Consulta.Validacoes;

import org.springframework.stereotype.Component;

import dev.anderson.med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import dev.anderson.med.voll.api.domain.Paciente.PacienteRepository;
import dev.anderson.med.voll.api.infra.Exception.ValidacaoException;

@Component
public class ValidacaoPacienteAtivo implements ValidacaoAgendamentoConsulta {

    private final PacienteRepository repository;

    public ValidacaoPacienteAtivo(PacienteRepository repository) {
        this.repository = repository;
    }

    public void validar(DadosAgendamentoConsulta dados) {
        boolean pacienteAtivo = repository.findAtivoById(dados.idPaciente());

        if (!pacienteAtivo) {
            throw new ValidacaoException("Paciente inativo, não é possível agendar consulta");
        }
    }
}
