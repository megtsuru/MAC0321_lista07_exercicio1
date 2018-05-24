package lista07.Isabella.Megumi.Q;

import java.util.Scanner;
import java.util.Random;

public class Batalha {
	private static final String[] skills = {"atacar com sabre", "atacar com dupla forca", "atacar com forca", "esquivar"};
	private static final int[] dano = {12, 10, 8, 0};
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

		while (mestreJedi.getQuantidadeVida() > 0 && lordeSith.getQuantidadeVida() > 0) {
			System.out.println("----------- " + cont + " -----------");
			
			batalha.imprimeListaComandos();
			
			System.out.println(mestreJedi.getNome() + ", escolha sua skill (0 a 3): ");
			skillMestre = keyboard.nextInt();
			
			System.out.println(lordeSith.getNome() + ", escolha sua skill (0 a 3): ");
			skillLorde = keyboard.nextInt();
			keyboard.nextLine();
				
			if (skillMestre == skillLorde) {
				//atencao: caso mesmo skill mesmo nivel -> usemos sorteio
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
		Batalha oi = new Batalha();
		oi.lutaMestreXLorde();
	}
}