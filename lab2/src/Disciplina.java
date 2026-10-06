public class Disciplina {
    private String materia;
    private int horas = 0;
    private double[] notas = {0, 0, 0, 0};

    public Disciplina(String materia) {
        this.materia = materia;
    }

    public void cadastraHoras(int horas) {
        this.horas += horas;
    }

    public void cadastraNota(int i, double v) {
        this.notas[i-1] = v;
    }

    public boolean aprovado() {
        double total = notas[0] + notas[1] + notas[2] + notas[3];
        if (total >= 28) {
            return true;
        }
        return false;
    }

    public double media() {
        double total = notas[0] + notas[1] + notas[2] + notas[3];
        return total / 4;
    }

    public String getNotas() {
        String notas = "[";
        for (int i = 0; i<3; i++) {
            notas += this.notas[i] + ", ";
        }
        return notas + this.notas[3] + "]";
    }

    public String toString() {
        return this.materia + " " + this.horas + " " + media() + " " + getNotas();
    }
}
