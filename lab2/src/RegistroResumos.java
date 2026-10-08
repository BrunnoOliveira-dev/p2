import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class RegistroResumos {
    private int limite;
    private int indice = 0;
    private Resumo[] resumos;
    // private String[] conteudos;

    public RegistroResumos(int qt) {
        this.limite = qt;
        this.resumos = new Resumo[qt];
    }
    public void adiciona(String tema, String conteudo) {
        if (!temResumo(tema)) {
            Resumo newResumo = new Resumo(tema, conteudo);

            this.resumos[indice] = newResumo;

            this.indice += 1;
            this.indice = indice % limite;
        }
    }

    public String[] pegaResumos() {
        String[] todos = new String[this.limite];
        int k = 0;
        for (int i = 0; i < limite; i++) {
            if (resumos[i] != null) {
                todos[k] = resumos[i].toString();
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
            todos += resumos[i].getTema() + " | ";
        }
        todos += resumos[conta() - 1].getTema();
        return todos;
    }

    public boolean temResumo(String tema) {
        for (Resumo resumo : resumos) {
            if (resumo != null){
                if (resumo.getTema().equals(tema)) return true;
            }
        }
        return false;
    }

    public String[] find(String chaveDeBusca) {
        String[] possiveis = new String[limite];
        int k = 0;
        for (Resumo resumo : resumos) {
            if (resumo != null && resumo.find(chaveDeBusca)) {
                possiveis[k] = resumo.getTema();
                k += 1;
            }
        }

        return Arrays.copyOf(possiveis, k);
    }
}
