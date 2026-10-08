import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Disciplina {
    private String materia;
    private int horas = 0;
    private double[] notas = {0, 0, 0, 0};
    int qtNotas = 4;
    private int[] pesos = {1, 1, 1, 1};

    public Disciplina(String materia) {
        this.materia = materia;
    }

    public Disciplina(String materia, int qtNotas) {
        this.materia = materia;
        this.qtNotas = qtNotas;
        notas = new double[qtNotas];
        pesos = new int[qtNotas];
        for (int i=1; i<qtNotas; i++) {
            pesos[i] = 1;
        }
    }

    public Disciplina(String materia, int qtNotas, int[] pesos) {
        this.materia = materia;
        this.qtNotas = qtNotas;
        this.pesos = pesos;
        notas = new double[qtNotas];
    }

    public void cadastraHoras(int horas) {
        this.horas += horas;
    }

    public void cadastraNota(int i, double v) {
        this.notas[i-1] = v;
    }

    public boolean aprovado() {
        double total = 0;
        for (int i = 0; i < qtNotas; i++) {
            total += notas[i] * pesos[i];
        }

        if (total / Arrays.stream(pesos).sum() >= 7 ) {
            return true;
        }
        return false;
    }

    public double media() {
        double total = Arrays.stream(notas).sum();
        return total / Arrays.stream(pesos).sum();
    }

    public String getNotas() {
        String notas = "[";
        for (int i = 0; i < qtNotas - 1; i++) {
            notas += this.notas[i] + ", ";
        }
        return notas + this.notas[qtNotas -1] + "]";
    }

    public String toString() {
        return this.materia + " " + this.horas + " " + media() + " " + getNotas();
    }
}
