import java.util.Scanner;

public class Votacao {
    Scanner intScanner = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);
    ListaDeEleitores listagemDeEleitores;
    ListaDeCandidatos listagemDeCandidatos;

    private int path, votos, votosNulos, votosValidos;
    private boolean votacaoStatus = true;

    public Votacao(ListaDeCandidatos listaDeCandidatos, ListaDeEleitores listaDeEleitores) {
        this.listagemDeCandidatos = listaDeCandidatos;
		this.listagemDeEleitores = listaDeEleitores;
    }

    public void iniciarVotacao() {
        if(votacaoStatus) {
            System.out.printf("%n 1: Registrar novo voto %n 2: Retornar ao menu Principal %n");
            path = intScanner.nextInt();
            if(path == 1) {
                System.out.println("Digite o seu numero de eleitor");
                int id = intScanner.nextInt();
                if(listagemDeEleitores.booleanEleitoresID(id)) {
                    Eleitor eleitor = listagemDeEleitores.getEleitor(id); 
                    System.out.println(eleitor);
                    if(eleitor.getSituacao()) {
                        String confirmation = "";
                        do {
                            listagemDeCandidatos.listarCandidatos();
                            System.out.printf("%n Digite o numero do candidato: ");
                            int numeroCandidato = intScanner.nextInt();
                            if(listagemDeCandidatos.booleanCandidatoID(numeroCandidato)) {
                                Candidato candidato = listagemDeCandidatos.getCandidato(numeroCandidato);
                                System.out.println(candidato.getNome());
                                System.out.println("Voce confirma o voto? [S] para sim e [N] para não");
                                confirmation = stringScanner.nextLine();
                            if(confirmation.equalsIgnoreCase("S")) {
                                System.out.println("Voto registrado, voltando ao menu");
                                candidato.aumentarVoto();
                                votosValidos++;
                            } 
                        }
                        else{
                            System.out.println("Numero de candidato invalido, voto será contado como nulo.");
                            System.out.println("Voce confirma o voto? [S] para sim e [N] para não");
                            confirmation = stringScanner.nextLine();
                            if(confirmation.equalsIgnoreCase("S")) {
                                System.out.println("Voto registrado como nulo, voltando ao menu");
                                votosNulos++;
                            }
                        }
                    } while (!confirmation.equalsIgnoreCase("S"));
                    votos++;
                    
                }
            } else {
                System.out.println("Não foi achado nenhum eleitor com essa id, voltando para o menu");
                
            }
            
        } else {
            
        }
    } else {
        System.out.println("Votacao já foi encerrada, voltando ao menu");
        
    }
    }

    public void mostrarNumerosEleitores() {
        for (Eleitor numeroEleitor : numEleitor()) {
            System.out.println(numeroEleitor);
        }
    }

    public Eleitor[] numEleitor() {
        System.out.println("Por favor digite o seu numero de eleitor");
        return(listagemDeEleitores.getEleitores());
    }

    public void fecharVotacao() {
        if(votacaoStatus) {
            votacaoStatus = !votacaoStatus;
			System.out.print("Votacao esta encerrada");
        } else {
            System.out.print("Votacao ja foi encerrada");
        }
    }

    public int getVotosNulos() {
        return votosNulos;
    }

	public boolean getVotacaoStatus() {
		return votacaoStatus;
	}

	public int getVotosValidos() {	
			return votosValidos;
	}

	public int getVotos() {
		return votos;
	}
}
