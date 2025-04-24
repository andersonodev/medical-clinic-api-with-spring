package dev.anderson.med.voll.api.domain.Consulta.Validacoes;

import org.springframework.stereotype.Component;

import dev.anderson.med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import dev.anderson.med.voll.api.infra.Exception.ValidacaoException;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidacaoHorarioAntecedencia implements ValidacaoAgendamentoConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        LocalDateTime dataConsulta = dados.data();
        LocalDateTime dataAtual = LocalDateTime.now();
        long diferencaData = Duration.between(dataAtual, dataConsulta).toMinutes();

        if (diferencaData < 30) {
            throw new ValidacaoException("Consulta deve ser marcada com pelo menos 30 minutos de antecedência");
        }
    }
}
