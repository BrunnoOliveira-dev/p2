public class Descanso {
    int horaDescanso = 0;
    int numeroSemanas = 1;

    public void defineHorasDescanso(int i) {
        this.horaDescanso = i;
    }

    public void defineNumeroSemanas(int i) {
        this.numeroSemanas = i;
    }

    public String getStatusGeral() {
        if (horaDescanso / numeroSemanas >= 26) return "descansado";
        else return "cansado";
    }
}
