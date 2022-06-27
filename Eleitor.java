public class Eleitor {

    private int id;
    private String nome;
    private String situacao;
    
    public Eleitor(int id, String nome, String situacao) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return (
            "\nId: " + id +
            "\nNome: " + nome +
            "\nSituação: " + situacao
        );
    }
}
