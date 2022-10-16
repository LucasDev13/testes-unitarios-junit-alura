package com.testeunitarios.service;

import com.testeunitarios.model.Calculadora;
import com.testeunitarios.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario) {
        var calc = new Calculadora();
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        if (valor.compareTo(new BigDecimal("1000")) > 0) {
            throw new IllegalArgumentException("Funcionario com salario maior do que R$ 10000 não pode receber bonus!");
        }
        String s = returnString();
        if (valor.compareTo(new BigDecimal("50")) > 0) {
            valor = BigDecimal.valueOf(calc.multiplica(valor.intValue(), 5));
        }
        int i = returnIntDual();

        return valor.setScale(2, RoundingMode.HALF_UP);
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

