package com.testeunitarios.service;

import com.testeunitarios.model.Calculadora;
import com.testeunitarios.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario) {
        var calc = new Calculadora();
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        if (valor.compareTo(new BigDecimal("1000")) > 0) {
            valor = BigDecimal.ZERO;
        }
        String s = returnString();
        if (valor.compareTo(new BigDecimal("50")) > 0) {
            valor = BigDecimal.valueOf(calc.multiplica(valor.intValue(), 5));
        }
        int i = returnIntDual();

        return valor;
    }

    public String returnString() {
        return "teste";
    }


    public int returnIntDual() {
        var funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal("2500"));
        if(funcionario.getNome().equals("Lucas")){
            return 4;
        }
        return 5;
    }

}

