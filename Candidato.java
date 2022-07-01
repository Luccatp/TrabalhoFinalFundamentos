public class Candidato {
  private int id;
  private String nome;
  private String partido;
  private int votos;

  public Candidato(int id, String nome, String partido) {
    this.id = id;
    this.nome = nome;
    this.partido = partido;
    this.votos = 0;
  }

  public Candidato() {

  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getPartido() {
    return partido;
  }

  public void aumentarVoto() {
    votos++;
  }

  public int getVotos() {
	return votos;
  }

  public String toString() {
    return (
      "\nId: " + id + 
      "\nNome: " + nome + 
      "\nPartido: " + partido
      );
  }

  public String toStringArquivo() {
    return(
      Integer.toString(id).concat(",")
      .concat(nome + ",")
      .concat(partido + ",")
      .concat(Integer.toString(votos))
    );
  }

  public String toStringTabela() {
    return(
      Integer.toString(id).concat("\t|")
      .concat(nome + "\t|")
      .concat(partido + "\t|")
      .concat(Integer.toString(votos))
    );
  }
}
