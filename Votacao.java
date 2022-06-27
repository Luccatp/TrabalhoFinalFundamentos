import java.util.Scanner;

public class Votacao {
    

    public void iniciarVotacao() {
        Menu menu = new Menu();
        Scanner in = new Scanner(System.in);
        int teste = in.nextInt();
        System.out.printf("%n 1:Registrar novo voto %n 2:Retornar ao menu Principal");
        if(teste == 1) {
            menu.InterectiveMenu(0);
        } else {
            System.out.println("tchau");
        }
    }
}
