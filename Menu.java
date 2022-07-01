import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {
	private String menu = "%n 1: Iniciar votacao %n 2: Encerrar Votacao %n 3: Listar Eleitores %n 4: Listar Eleitores (Ordem Alfabetica) %n 5: Imprimir Resultados %n 6: Gerar Arquivo com resultados %n 0: Sair %n";
	private int selectedPath;
	Scanner in = new Scanner(System.in);

	ListaDeCandidatos listaDeCandidatos;
	ListaDeEleitores listagemDeEleitores;
	Votacao votacao;

	public Menu() {
		listaDeCandidatos = new ListaDeCandidatos();
		listagemDeEleitores = new ListaDeEleitores();
		votacao = new Votacao(listaDeCandidatos, listagemDeEleitores);
		do {
			System.out.printf(menu);
			selectedPath = in.nextInt();
			if (selectedPath == 0) {
				System.out.println("Voce tem certeza que quer fechar o programa?");
				System.out.printf(
						"Digite %n 0: Para Sair %n 1: Para voltar ao menu %n");
				int logoutAffirmation = in.nextInt();

				if (logoutAffirmation == 0) {
					System.out.println("Voce está saindo do programa.");
					System.exit(0);
				} else {
					System.out.println(
							"Voce está voltando ao programa, por favor selecione novamente alguma opcao do menu.");
					System.out.printf(menu);
					selectedPath = in.nextInt();
				}
			}
			switch (selectedPath) {
				case 1:
					votacao.iniciarVotacao();
					break;
				case 2:
					votacao.fecharVotacao();
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
					if(!votacao.getVotacaoStatus())
						showTabela();
					else 
						System.out.println("A votacao deve ser encerrada para mostrar a tabela");
					break;
				case 6:
					if (!votacao.getVotacaoStatus())
						salvarArquivo();
					else
						System.out.println("A votacao deve ser encerrada para fazer a criacao do arquivo");
					break;
				default:
					System.out.println("Voce está saindo do programa.");
					System.exit(0);
					break;
			}
		} while (selectedPath != 0);
	}

	public void salvarArquivo() {
		try {
			String path = "TxtFiles//resultados.txt";
			File file = new File(path);
			if (!file.exists()) {
				System.out.println("Arquivo nao existe, criando novo arquivo");
				file.createNewFile();
			}
			FileWriter writter = new FileWriter(path);
			Candidato[] candidatos = listaDeCandidatos.getCandidatos();

			String dataEHora = "Data e Hora: ".concat(
					LocalDateTime
							.now()
							.toString()
							.split("T")[0].concat(" - ")
							.concat(
									LocalDateTime.now().toString().split("T")[1].substring(0, 8)));

			writter.write(dataEHora.concat("\n"));
			for (Candidato candidato : candidatos) {
				writter.write(candidato.toStringArquivo().concat("\n"));
			}
			writter.write("000,NULO,NULO," + votacao.getVotosNulos());
			writter.close();
			System.out.println("Arquivo escrito com sucesso");
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public void showTabela() {
		System.out.println("Codigo \t| Candidato \t\t\t| Partido \t\t| Votos | Votos validos");
		for(Candidato candidato : listaDeCandidatos.getCandidatos()) {

			String qtdVtsVlds;
			if (votacao.getVotosValidos() != 0) {
				qtdVtsVlds = Double.toString(Math.round((candidato.getVotos() / (double)votacao.getVotosValidos()) *100));
			} else qtdVtsVlds = "0";
			System.out.println(candidato.toStringTabela()
			.concat("\t|" + qtdVtsVlds)+ "%");
		}
		System.out.println("\t\t\t\t\t| NULOS\t\t\t|" + votacao.getVotosNulos());
		System.out.println("\t\t\t\t\t| Total votos\t\t|" + votacao.getVotos());
		System.out.println("\t\t\t\t\t| Total votos validos\t|" + votacao.getVotosValidos());
	}
}
