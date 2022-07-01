import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utilidade {

    public static int getQuantidadeDeLinhas(File file) {
        int qtdLinhas = 0;

        try {
            Scanner reader = new Scanner(file);
            reader.nextLine();
            while (reader.hasNext()) {
                qtdLinhas++;
                reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return qtdLinhas;
    }
    
}
