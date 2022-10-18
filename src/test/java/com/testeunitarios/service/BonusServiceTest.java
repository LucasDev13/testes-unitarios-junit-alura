package com.testeunitarios.service;

import com.testeunitarios.model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
//        assertEquals(new BigDecimal("0.00"), bonus);

        //1° forma de fazer o assert para exception.

//        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("25000"))));

        //2° Forma de fazer o assert para exception com try catch. Esta maneira é util quando você quer pegar a
        // mensagem da exception
        try{
            service.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("25000")));
            fail("não deu a exception.");//vai cair nessa linha se não lançar a exception forçando o junit a lançar o erro
        }catch (Exception e){
            //Verificando se está vindo com a mensagem esperada.
            assertEquals("Funcionario com salario maior do que R$ 10000 não pode receber bonus!", e.getMessage());
        }
    }

    @Test
    void bonusDeveriaSer10PorcentoDoSalario(){
        var bonus = service.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("1250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("5000.00"), bonus);
    }

    @Test
    void bonusDeveriaSer1000ParaFuncionarioComSalarioBaixo(){
        //instanciar a classe que vou testar
        BonusService service = new BonusService();
        //chamo o método e passo o que ele precisa.
        BigDecimal bonus = service.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("2000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
