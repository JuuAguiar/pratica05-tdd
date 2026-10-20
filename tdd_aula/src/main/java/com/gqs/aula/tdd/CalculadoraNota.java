
package com.gqs.aula.tdd;

public class CalculadoraNota {

    public boolean estaAprovadoPorNota(double notaFinal) {
        return notaFinal >= 70;
    }

    public double calcularNotaFinal(double a1, double a2, double a3) {
        validarNota(a1, 30, "A1");
        validarNota(a2, 30, "A2");
        validarNota(a3, 40, "A3");

        return a1 + a2 + a3;
    }

    private void validarNota(double nota, double notaMaxima, String nomeAvaliacao) {
        if (nota < 0 || nota > notaMaxima) {
            throw new IllegalArgumentException(
                nomeAvaliacao + " deve estar entre 0 e " + notaMaxima);
        }
    }
}
