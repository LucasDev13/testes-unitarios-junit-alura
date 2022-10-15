package com.testeunitarios.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void deveriaSomarDoisNumerosPositivos(){
        //instanciei a classe que tem o método que vou testar
        Calculadora calculadora = new Calculadora();

        //chamo o método que quero testar, passo o que ele precisa
        //guardo seu retorno em uma variável para utilizar nos assertions(afirmações)
        int soma = calculadora.somar(3, 7);

        //Faço as verificações se o teste está correto ou não com base no retorno do método.
        Assertions.assertEquals(10, soma);
    }
}
