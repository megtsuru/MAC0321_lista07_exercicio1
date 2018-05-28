package lista07.Isabella.Megumi.Q;

/*
 * O programa é um jogo interativo que simula a batalha entre um Mestre Jedi e um Lorde Sith.
 * 
 * Inicialmente, o programa pede para que se digite o nome, o valor de dominio da forca(numeros inteiros de 1 a 10) 
 * e o valor de dominio do sabre (numeros inteiros de 1 a 10) de cada um dos personagens.
 * 
 * 
 * Então, é iniciada a batalha em que em cada jogada:
 * 		 i.   Eh escolhida uma skill(habilidade) para cada personagem,
 * 		 ii.  Cada personagem sofre ou nao um dano (a quantidade de vida eh subtraida) dependendo das skills escolhidas, e
 *	     iii. O jogo encerra quando um dos personagens fica com a quantidade de vida menor ou igual a zero, sendo este o perdedor.
 * 
 * Detalhando as regras do jogo:
 * 
 *  a) Cada um dos personagens iniciam com quantidade de vida igual a 100.
 *  
 * 	b) As skills (habilidades) sao as mesmas para os dois personagens. Em cada jogada, o programa pede para que se
 *     escolha uma das skills entre as que são listadas, uma para o Mestre Jedi e outra para o Lorde Sith, sendo elas:
 * 			0. atacar com sabre 		(12)
 * 			1. atacar com dupla forca 	(10)
 * 			2. atacar com forca 		(8)
 * 			3. esquivar					(0)
 *	   Os numeros entre parenteses sao o dano minimo (quantidade minima de vida que a skill retira do oponente) associado 
 *	   a cada skill.
 *	   Além disso, 
 *	   		(0) eh uma skill do tipo habilidade com uso de sabre;
 *	   		(1) e (2) sao skills do tipo habilidade com uso de forca;
 *			(3) eh uma skill do tipo habilidade de esquiva.
 *
 * 	c) Cada skill tem um dano minimo associado a ela, porem o dano real da skill depende do dominio(forca ou sabre) 
 * 	   associado a cada personagem. Assim, o dano real eh calculado atraves da formula abaixo:
 * 			Dano real = dano minimo * (1 + 0,1 * (dominio))
 * 	   Sendo dominio 
 * 			i.  o valor do dominio da forca se a skill eh do tipo habilidade com uso de forca;
 * 			ii. o valor do dominio do sabre se a skill eh do tipo habilidade com uso de sabre.
 * 
 *  d) A skill esquivar evita que o personagem sofra dano no caso em que o oponente tenha escolhido um ataque com sabre.
 * 
 *  e) Cada skill tem uma prioridade de execucao sobre a outra, sendo esta, listada na ordem crescente:
 *			atacar com sabre < atacar com dupla forca < atacar com forca < esquivar
 *	
 *  
 *  f) Caso tenha sido escolhida a mesma skill para os dois jogadores, temos duas possibilidades de saida:
 *  		i.  Tem prioridade de execucao o personagem que tenha o maior dominio associado ao tipo da skill escolhida.
 *  		ii. Caso os personagens tenham o mesmo dominio associado ao tipo da skill escolhida, a prioridade de execucao
 *  			eh definida por uso da aleatoriedade.
 */


import java.util.Scanner;
import java.util.Random;

public class Batalha {
	private static final String[] skills = {"atacar com sabre", "atacar com dupla forca", "atacar com forca", "esquivar"}; //lista de skills (habilidades)
	private static final int[] dano = {12, 10, 8, 0}; //indica a quantidade de vida que uma skill (habilidade) tira do oponente
	private static String nome;
	private static int dominioForca, dominioSabre;
	private Scanner keyboard = new Scanner(System.in);
	
	private void montaPersonagem() {
		System.out.println("Informe um nome:");
		nome = keyboard.nextLine();
		
		System.out.println("Informe o dominio da forca (1 a 10):");
		dominioForca = keyboard.nextInt();
		
		System.out.println("Informe o dominio do sabre (1 a 10):");
		dominioSabre = keyboard.nextInt();
		keyboard.nextLine();
	}
	
	private void imprimeListaComandos() {
		for(int i = 0; i < 4; i++) {
			System.out.println(i + ". " + skills[i]);
		}
		System.out.printf("\n" );
	}
	
	public void lutaMestreXLorde() {
		Batalha batalha = new Batalha();
		int skillMestre = 0;
		int skillLorde = 0;
		boolean mestreGanhou = true;
		int cont = 0;
		
		System.out.println("Montagem do Mestre Jedi");
		batalha.montaPersonagem();
		Mestre mestreJedi = new Mestre(nome, dominioForca, dominioSabre);
		System.out.println("\nNome: " + mestreJedi.getNome() + "\nDominio da forca: " + mestreJedi.getDominioForca() + "\nDominio do Sabre: " + mestreJedi.getDominioSabre());
		
		System.out.println("\nMontagem do Lorde Sith");
		batalha.montaPersonagem();
		Lorde lordeSith = new Lorde(nome, dominioForca, dominioSabre);
		System.out.println("\nNome: " + lordeSith.getNome() + "\nDominio da forca: " + lordeSith.getDominioForca() + "\nDominio do Sabre: " + lordeSith.getDominioSabre() + "\n");

		//saída do loop quando um dos personagens fica com a vida zerada
		while (true) {
			System.out.println("----------- " + cont + " -----------");
			
			batalha.imprimeListaComandos();
			
			System.out.println(mestreJedi.getNome() + ", escolha sua skill (0 a 3): ");
			skillMestre = keyboard.nextInt();
			
			System.out.println(lordeSith.getNome() + ", escolha sua skill (0 a 3): ");
			skillLorde = keyboard.nextInt();
			keyboard.nextLine();
			
			//caso em que os jogadores escolhem a mesma habilidade (skill)		
			if (skillMestre == skillLorde) {
				int skill = skillMestre;
				if (skill == 3) {
					System.out.println("Os dois esquivaram!");
				}
				if (skill == 2 || skill == 1) {
					if (mestreJedi.getDominioForca() > lordeSith.getDominioForca()) {
						lordeSith.setVidaPosDano(dano[skill]*(1 + 0.1 * lordeSith.getDominioForca()));
						if (lordeSith.getQuantidadeVida() <= 0) {
							mestreGanhou = true;
							break;
						}
						mestreJedi.setVidaPosDano(dano[skill]*(1 + 0.1 * mestreJedi.getDominioForca()));
						if (mestreJedi.getQuantidadeVida() <= 0) {
							mestreGanhou = false;
							break;
						}
					}
					else if (mestreJedi.getDominioForca() < lordeSith.getDominioForca()) {
						mestreJedi.setVidaPosDano(dano[skill]*(1 + 0.1 * mestreJedi.getDominioForca()));
						if (mestreJedi.getQuantidadeVida() <= 0) {
							mestreGanhou = false;
							break;
						}
						lordeSith.setVidaPosDano(dano[skill]*(1 + 0.1 * lordeSith.getDominioForca()));
						if (mestreJedi.getQuantidadeVida() <= 0) {
							mestreGanhou = false;
							break;
						}
					}
					else {
						Random gerador = new Random();
						int aleatorio = gerador.nextInt(2);
						if (aleatorio == 0) {
							mestreJedi.setVidaPosDano(dano[skill]*(1 + 0.1 * mestreJedi.getDominioForca()));
							if (mestreJedi.getQuantidadeVida() <= 0) {
								mestreGanhou = false;
								break;
							}
							lordeSith.setVidaPosDano(dano[skill]*(1 + 0.1 * lordeSith.getDominioForca()));
							if (lordeSith.getQuantidadeVida() <= 0) {
								mestreGanhou = true;
								break;
							}
						}
						else {
							lordeSith.setVidaPosDano(dano[skill]*(1 + 0.1 * lordeSith.getDominioForca()));
							if (lordeSith.getQuantidadeVida() <= 0) {
								mestreGanhou = true;
								break;
							}
							mestreJedi.setVidaPosDano(dano[skill]*(1 + 0.1 * mestreJedi.getDominioForca()));
							if (mestreJedi.getQuantidadeVida() <= 0) {
								mestreGanhou = false;
								break;
							}
						}
					}
				}
				//caso em que jogadores escolhem habilidades diferentes
				else {
					if (mestreJedi.getDominioSabre() > lordeSith.getDominioSabre()) {
						lordeSith.setVidaPosDano(dano[skill]*(1 + 0.1 * lordeSith.getDominioSabre()));
						if (lordeSith.getQuantidadeVida() <= 0) {
							mestreGanhou = true;
							break;
						}
						mestreJedi.setVidaPosDano(dano[skill]*(1 + 0.1 * mestreJedi.getDominioSabre()));
						if (mestreJedi.getQuantidadeVida() <= 0) {
							mestreGanhou = false;
							break;
						}
					}
					else if (mestreJedi.getDominioSabre() < lordeSith.getDominioSabre()) {
						mestreJedi.setVidaPosDano(dano[skill]*(1 + 0.1 * mestreJedi.getDominioSabre()));
						if (mestreJedi.getQuantidadeVida() <= 0) {
							mestreGanhou = false;
							break;
						}
						lordeSith.setVidaPosDano(dano[skill]*(1 + 0.1 * lordeSith.getDominioSabre()));
						if (lordeSith.getQuantidadeVida() <= 0) {
							mestreGanhou = true;
							break;
						}
					}
					else {
						Random gerador = new Random();
						int aleatorio = gerador.nextInt(2);
						if (aleatorio == 0) {
							mestreJedi.setVidaPosDano(dano[skill]*(1 + 0.1 * mestreJedi.getDominioSabre()));
							if (mestreJedi.getQuantidadeVida() <= 0) {
								mestreGanhou = false;
								break;
							}
							lordeSith.setVidaPosDano(dano[skill]*(1 + 0.1 * lordeSith.getDominioSabre()));
							if (lordeSith.getQuantidadeVida() <= 0) {
								mestreGanhou = true;
								break;
							}
						}
						else {
							lordeSith.setVidaPosDano(dano[skill]*(1 + 0.1 * lordeSith.getDominioSabre()));
							if (lordeSith.getQuantidadeVida() <= 0) {
								mestreGanhou = true;
								break;
							}
							mestreJedi.setVidaPosDano(dano[skill]*(1 + 0.1 * mestreJedi.getDominioSabre()));
							if (mestreJedi.getQuantidadeVida() <= 0) {
								mestreGanhou = false;
								break;
							}
						}
					}
				}
			}
			else if (skillMestre != skillLorde) {
				if (skillMestre == 3 && (skillLorde == 1 || skillLorde == 2)) {
					mestreJedi.setVidaPosDano(dano[skillLorde]*(1 + 0.1 * lordeSith.getDominioForca()));
					if (mestreJedi.getQuantidadeVida() <= 0) {
						mestreGanhou = false;
						break;
					}
				}
				else if (skillLorde == 3 && (skillMestre == 1 || skillMestre == 2)) {
					lordeSith.setVidaPosDano(dano[skillMestre]*(1 + 0.1 * mestreJedi.getDominioForca()));
					if (lordeSith.getQuantidadeVida() <= 0) {
						mestreGanhou = true;
						break;
					}
				}
				if (skillMestre == 0 && (skillLorde == 1 || skillLorde == 2)) {
					mestreJedi.setVidaPosDano(dano[skillLorde]*(1 + 0.1 * lordeSith.getDominioForca()));
					if (mestreJedi.getQuantidadeVida() <= 0) {
						mestreGanhou = false;
						break;
					}
					lordeSith.setVidaPosDano(dano[skillMestre]*(1 + 0.1 * mestreJedi.getDominioSabre()));
					if (lordeSith.getQuantidadeVida() <= 0) {
						mestreGanhou = true;
						break;
					}
				}
				else if (skillLorde == 0 && (skillMestre == 1 || skillMestre == 2)) {
					lordeSith.setVidaPosDano(dano[skillMestre]*(1 + 0.1 * mestreJedi.getDominioForca()));
					if (lordeSith.getQuantidadeVida() <= 0) {
						mestreGanhou = true;
						break;
					}
					mestreJedi.setVidaPosDano(dano[skillLorde]*(1 + 0.1 * lordeSith.getDominioSabre()));
					if (mestreJedi.getQuantidadeVida() <= 0) {
						mestreGanhou = false;
						break;
					}
				}
				else if (skillLorde == 3 && skillMestre == 0) {
					System.out.println(lordeSith.getNome() + " esquivou!");
				}
				else if (skillLorde == 0 && skillMestre == 3) {
					System.out.println(mestreJedi.getNome() + " esquivou!");
				}
				else if (skillLorde == 1 && skillMestre == 2) {
					mestreJedi.setVidaPosDano(dano[skillLorde]*(1 + 0.1 * lordeSith.getDominioForca()));
					if (mestreJedi.getQuantidadeVida() <= 0) {
						mestreGanhou = false;
						break;
					}
					lordeSith.setVidaPosDano(dano[skillMestre]*(1 + 0.1 * mestreJedi.getDominioForca()));
					if (lordeSith.getQuantidadeVida() <= 0) {
						mestreGanhou = true;
						break;
					}
				}
				else if (skillLorde == 2 && skillMestre == 1) {
					lordeSith.setVidaPosDano(dano[skillMestre]*(1 + 0.1 * mestreJedi.getDominioForca()));
					if (lordeSith.getQuantidadeVida() <= 0) {
						mestreGanhou = true;
						break;
					}
					mestreJedi.setVidaPosDano(dano[skillLorde]*(1 + 0.1 * lordeSith.getDominioForca()));
					if (mestreJedi.getQuantidadeVida() <= 0) {
						mestreGanhou = false;
						break;
					}
				}
			}
			System.out.println("\nVida restante de " + mestreJedi.getNome() + ": " + String.format("%.2f", mestreJedi.getQuantidadeVida()));
			System.out.println("Vida restante de " + lordeSith.getNome() + ": " + String.format("%.2f", lordeSith.getQuantidadeVida()) + "\n");
			cont++;
		}
		
		if (mestreGanhou == true) {
			System.out.println(mestreJedi.getNome() + " WINS!!!");
		}
		else {
			System.out.println(lordeSith.getNome() + " WINS!!!");
		}
	}
}

class TesteBatalha {
	public static void main(String[] args) {
		Batalha lendaria = new Batalha();
		lendaria.lutaMestreXLorde();
	}
}