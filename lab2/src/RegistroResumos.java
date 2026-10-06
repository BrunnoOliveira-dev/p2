public class RegistroResumos {
    private int limite;
    private int indice = 0;
    private String[] resumos;
    private String[] conteudos;

    public RegistroResumos(int i) {
        this.limite = i;
        this.resumos = new String[i];
        this.conteudos = new String[i];
    }
    public void adiciona(String tema, String conteudo) {
        if (!temResumo(tema)) {
            this.resumos[indice] = tema;
            this.conteudos[indice] = conteudo;
            this.indice += 1;
            this.indice = indice % limite;
        }
    }

    public String[] pegaResumos() {
        String[] todos = new String[this.limite];
        int k = 0;
        for (int i = 0; i < limite; i++) {
            if (resumos[i] != null) {
                todos[k] = resumos[i] + ": " + conteudos[i];
                k++;
            }
        }
        return todos;
    }

    public int conta() {
        int total = 0;
        for (int i = 0; i < limite; i++) {
            if (resumos[i] != null) total++;
        }

        return total;
    }

    public String imprimeResumos() {
        String todos = "- " + conta() + " resumo(s) cadastrado(s)\n- ";
        for (int i = 0; i < conta() - 1; i++) {
            todos += resumos[i] + " | ";
        }
        todos += resumos[conta() - 1];
        return todos;
    }

    public boolean temResumo(String tema) {
        for (String t : resumos) {
            if (t != null){
                if (t.equals(tema)) return true;
            }
        }
        return false;
    }
}
