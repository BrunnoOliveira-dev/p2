public class RegistroTempoOnline {
    private String materia;
    private int tempo=0;
    private int metaTempo = 120;
    public RegistroTempoOnline(String materia) {
        this.materia = materia;
    }

    public RegistroTempoOnline(String materia, int tempo) {
        this.materia = materia;
        this.metaTempo = tempo;
    }

    public void adicionaTempoOnline(int i) {
        this.tempo += i;
    }

    public boolean atingiuMetaTempoOnline() {
        if (tempo >= metaTempo) {
            return true;
        } else return  false;
    }

    public String toString() {
        return materia + " " + tempo+"/"+metaTempo;
    }
}
