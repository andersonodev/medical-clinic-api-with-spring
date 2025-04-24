package dev.anderson.med.voll.api.domain.Consulta.Validacoes;

import org.springframework.stereotype.Component;

import dev.anderson.med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import dev.anderson.med.voll.api.domain.Medico.MedicoRepository;
import dev.anderson.med.voll.api.infra.Exception.ValidacaoException;

@Component
public class ValidacaoMedicoAtivo implements ValidacaoAgendamentoConsulta {

    private final MedicoRepository repository;

    public ValidacaoMedicoAtivo(MedicoRepository repository) {
        this.repository = repository;
    }

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null) {
            return;
        }

        boolean medicoAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoAtivo) {
            throw new ValidacaoException("Médico inativo, não é possível agendar consulta");
        }
    }
}
