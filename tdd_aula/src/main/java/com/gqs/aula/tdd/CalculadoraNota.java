
package com.gqs.aula.tdd;

public class CalculadoraNota {

    public static final String APROVADO = "APROVADO";
    public static final String REPROVADO_POR_FALTA = "REPROVADO POR FALTA";
    public static final String REPROVADO_POR_NOTA = "REPROVADO POR NOTA";

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

    public String situacao(double notaFinal, double frequencia) {
        if (frequencia < 75) {
            return REPROVADO_POR_FALTA;
        }

        if (!estaAprovadoPorNota(notaFinal)) {
            return REPROVADO_POR_NOTA;
        }

        return APROVADO;
    }

    public boolean podeFazerAI(double a1, double a2, double a3, double frequencia) {
        double notaFinal = calcularNotaFinal(a1, a2, a3);

        boolean notaInsuficiente = !estaAprovadoPorNota(notaFinal);
        boolean frequenciaSuficiente = frequencia >= 75;
        boolean somaSuficiente = (a1 + a3 >= 40) || (a2 + a3 >= 40);

        return notaInsuficiente && frequenciaSuficiente && somaSuficiente;
    }

    public double aplicarAI(double a1, double a2, double a3, double notaAI) {
        validarNota(notaAI, 30, "AI");

        double menorNota = Math.min(a1, a2);

        if (notaAI > menorNota) {
            if (a1 <= a2) {
                a1 = notaAI;
            } else {
                a2 = notaAI;
            }
        }

        return calcularNotaFinal(a1, a2, a3);
    }

}
