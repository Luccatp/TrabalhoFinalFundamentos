import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();

        String menuList = "%n 1: Iniciar votacao %n 2: Encerrar Votacao %n 3:Listar Eleitores %n 4: Listar Eleitores (Ordem Alfabetica) %n 5:Imprimir Resultados %n 6: Gerar Arquivo com resultados %n 0: Sair %n";

        Scanner in = new Scanner(System.in);

        System.out.println("Bem vindo ao programa de votação, por favor selecione uma das opções do menu.");
        System.out.printf(menuList);

        int selectedPath = in.nextInt();

        menu.InterectiveMenu(selectedPath);

        }  

    }