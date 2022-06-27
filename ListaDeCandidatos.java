import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ListaDeCandidatos {
    private File candidatosFile = new File("TxtFiles//candidatos.txt");
    int quantidadeDeCandidatos = Utilidade.getQuantidadeDeLinhas(candidatosFile);
    Candidato[] candidatos;

    public ListaDeCandidatos() {
        this.candidatos = new Candidato[quantidadeDeCandidatos];
        popularCandidatos();
    }

    public void popularCandidatos() {
        try{
            Scanner reader = new Scanner(candidatosFile);
            reader.nextLine();
            for (int i = 0; reader.hasNextLine(); i++) {
                String fileLine = reader.nextLine();
                String[] fileLineContent = fileLine.split(",");
                int id = Integer.parseInt(fileLineContent[0]);
                String nome = fileLineContent[1];
                String situacao = fileLineContent[2];
                Candidato candidato = new Candidato(id, nome, situacao);
                candidatos[i] = candidato;
            }
                reader.close();
        } catch(FileNotFoundException Error) {
            System.out.println("File Not found");
            Error.printStackTrace();
        }
    }

    public Candidato[] getCandidatos() {
        return candidatos;
    }
    
    


}
