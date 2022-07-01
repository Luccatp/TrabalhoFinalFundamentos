public class Eleitor {

    private int id;
    private String nome;
    private String situacao;
    
    public Eleitor(int id, String nome, String situacao) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao;
    }

    public Eleitor() {
        this.id = 000;
        this.nome = "";
        this.situacao = "";
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public boolean getSituacao() {
        if (situacao.equalsIgnoreCase("Apto")) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return (
            "\nId: " + id + "," +
            "\nNome: " + nome + "," +
            "\nSituação: " + situacao
        );
    }
}
