package com.testeunitarios.service;

import com.testeunitarios.model.Desempenho;
import com.testeunitarios.model.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
            var percentual = desempenho.percentualReajuste();
            var reajuste = funcionario.getSalario().multiply(percentual);
            funcionario.reajustarSalario(reajuste);
    }
}
