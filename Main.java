import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ListaDeCandidatos listaDeCandidatos = new ListaDeCandidatos();
        ListaDeEleitores listagemDeEleitores = new ListaDeEleitores();

        int selectedPath, logoutAffirmation;
        String menu = "%n 1: Iniciar votacao %n 2: Encerrar Votacao %n 3:Listar Eleitores %n 4: Listar Eleitores (Ordem Alfabetica) %n 5:Imprimir Resultados %n 6: Gerar Arquivo com resultados %n 0: Sair %n";

        Scanner in = new Scanner(System.in);

        System.out.println("Bem vindo ao programa de votação, por favor selecione uma das opções do menu.");
        System.out.printf(menu);

        selectedPath = in.nextInt();

        if(selectedPath == 0){
            System.out.println("Voce tem certeza que quer fechar o programa?");
            System.out.printf("Digite %n 0: Para Sair %n 1: Para voltar ao menu %n");
            logoutAffirmation = in.nextInt();

            if(logoutAffirmation == 0) {
                System.out.println("Voce está saindo do programa.");
                System.exit(0);
            } else {
                System.out.println("Voce está voltando ao programa, por favor selecione novamente alguma opcao do menu.");
                System.out.printf(menu);
                selectedPath = in.nextInt();
            }
        } 
            switch(selectedPath) {
                case 1: 
                    break;
                case 2:
                    System.out.println("Escolheu 2");
                    break;
                case 3: 
                    for (Eleitor eleitor : listagemDeEleitores.getEleitores()) {
                        if (eleitor != null)
                            System.out.println(eleitor);
                    }
                    break;
                case 4: 
                for (Eleitor eleitor : listagemDeEleitores.getEleitoresOrdenados()) {
                    if (eleitor != null)
                        System.out.println(eleitor);
                }
                    break;
                case 5: 
                for (Candidato candidato : listaDeCandidatos.getCandidatos()) {
                    if (candidato != null)
                        System.out.println(candidato);
                }
                    break;
                case 6: 
                    System.out.println("Escolheu 6");
                    break;
                default: 
                    System.out.println("Voce está saindo do programa.");
                    System.exit(0);
                    break;
            }
        }  

    }