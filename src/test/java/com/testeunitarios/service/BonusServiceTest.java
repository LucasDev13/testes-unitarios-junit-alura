package com.testeunitarios.service;

import com.testeunitarios.model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    private void BonusService(){
        service = new BonusService();
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        //instanciar a classe que vou testar
//        BonusService service = new BonusService();
        //chamo o método e passo o que ele precisa.
        BigDecimal bonus = service.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("25000")));

        assertEquals(BigDecimal.ZERO, bonus);
    }

    @Test
    void bonusDeveriaSer1000ParaFuncionarioComSalarioBaixo(){
        //instanciar a classe que vou testar
        BonusService service = new BonusService();
        //chamo o método e passo o que ele precisa.
        BigDecimal bonus = service.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("2000")));

        assertEquals(new BigDecimal("1000"), bonus);
    }
}
