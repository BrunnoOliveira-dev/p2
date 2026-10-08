public class Resumo {
    private String tema;
    private String conteudo;

    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    public String getTema() {
        return tema;
    }

    public boolean find(String busca) {
        if (conteudo.contains(busca)) return true;
        return false;
    }

    @Override
    public String toString() {
        return tema + ": " + conteudo;
    }
}
