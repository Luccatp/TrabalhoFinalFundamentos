import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaDeEleitores {

    private File candidatosFile = new File("TxtFiles//eleitores.txt");
    private int quantidadeDeLinhas = Utilidade.getQuantidadeDeLinhas(candidatosFile) - 1;
    private Eleitor[] eleitores;

    public ListaDeEleitores() {
        this.eleitores = new Eleitor[quantidadeDeLinhas];
        popularEleitores();
    }

    private void popularEleitores() {
        try {
            Scanner reader = new Scanner(candidatosFile);
            reader.nextLine();
            for (int i = 0; reader.hasNextLine(); i++) {
                String fileLine = reader.nextLine();
                String[] fileLineContent = fileLine.split(",");
                int id = Integer.parseInt(fileLineContent[0]);
                String nome = fileLineContent[1];
                String situacao = fileLineContent[2];
                Eleitor eleitor = new Eleitor(id, nome, situacao);
                eleitores[i] = eleitor;
            }
            reader.close();
        } catch(FileNotFoundException Error) {
            System.out.println("File Not found");
            Error.printStackTrace();
        }
    }

            public Eleitor[] getEleitores() {
                return eleitores;
            }

    public Eleitor[] getEleitoresOrdenados() {
        int n = eleitores.length;
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) { 
                String nomeEleitor1 = eleitores[j].getNome();
                String nomeEleitor2 = eleitores[j + 1].getNome();
                char primeiraLetraNomeEleitor1 = nomeEleitor1.charAt(0);
                char primeiraLetraNomeEleitor2 = nomeEleitor2.charAt(0);
                if (primeiraLetraNomeEleitor1 > primeiraLetraNomeEleitor2)
                    troca(j);
                // else if (primeiraLetraNomeEleitor1 == primeiraLetraNomeEleitor2)
                //     if (segundaLetraNomeEleitor1 > segundaLetraNomeEleitor2)
                //         troca(j);
                //     else if (2 == 2) 
                //         if (3 > 3)
                //             troca(j);
            }

        return eleitores;
    }

    private void troca(int j) {
        Eleitor temp = eleitores[j];
        eleitores[j] = eleitores[j + 1];
        eleitores[j + 1] = temp;
    }
}
