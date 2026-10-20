package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {

    @Test
    void deveSomarAsTresNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(20, 20, 30);
        assertEquals(70, resultado);
    }

    @Test
    void deveSomarOutrasNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(10, 15, 25);
        assertEquals(50, resultado);
    }

    @Test
    void deveAprovarComNota70() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.estaAprovadoPorNota(70));
    }

    @Test
    void deveReprovarComNota69() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.estaAprovadoPorNota(69));
    }

    @Test
    void deveRejeitarA1MaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularNotaFinal(35, 20, 30));

    }

    @Test
    void deveAprovarComNotaEFrequenciaSuficientes() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("APROVADO", calc.situacao(80, 90));
    }

    @Test
    void deveReprovarComNotaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO", calc.situacao(60, 90));
    }

    @Test
    void deveReprovarPorFrequenciaMesmoComNotaAlta() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO", calc.situacao(95, 74));
    }

    @Test
    void deveAprovarComFrequenciaExatamente75() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("APROVADO", calc.situacao(70, 75));
    }

    @Test
    void devePermitirAIComNotaInsuficiente() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.podeFazerAI(10, 20, 30, 80));
    }

    @Test
    void devePermitirAIComSomaExatamente40() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.podeFazerAI(10, 5, 30, 80));
    }

    @Test
    void deveNegarAIParaAlunoAprovado() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(25, 25, 30, 80));
    }

    @Test
    void deveNegarAIPorFrequenciaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(10, 20, 30, 70));
    }

    @Test
    void deveNegarAIPorSomaInsuficiente() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(5, 5, 30, 80));
    }

}
