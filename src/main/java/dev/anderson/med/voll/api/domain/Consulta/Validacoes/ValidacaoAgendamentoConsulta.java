package dev.anderson.med.voll.api.domain.Consulta.Validacoes;

import dev.anderson.med.voll.api.domain.Consulta.DadosAgendamentoConsulta;

public interface ValidacaoAgendamentoConsulta {

    void validar(DadosAgendamentoConsulta dados);
}
