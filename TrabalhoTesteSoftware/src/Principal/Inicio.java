package Principal;
import java.util.Scanner;
public class Inicio {
	/*
	Qualquer célula viva com menos de dois vizinhos vivos morre de solidão.
	Qualquer célula viva com mais de três vizinhos vivos morre de superpopulação.
	Qualquer célula morta com exatamente três vizinhos vivos se torna uma célula viva.
	Qualquer célula com dois vizinhos vivos continua no mesmo estado para a próxima
	geração.*/
	private static void validaCelula(int [][]tab) {
		
	}
	private static void geraValorCelula(int [][]tab) {
		int min = 0;
		int max = 1;
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0; j < 6 ; j++) {
				tab[i][j] = (int)Math.floor(Math.random()*(max-min+1)+min);
			}
		}
	}
	private static void imprimeTabuleiro(int [][]tab) {
		for(int i = 0 ; i < 6 ; i++) {
			System.out.printf("[");
			for(int j = 0; j < 6 ; j++) {
				System.out.printf(" "+tab[i][j]+" ");
			}
			System.out.printf("]\n");
		}
	}
	/* - - - - - - - - - -*/
	/*
	Qualquer célula viva com menos de dois vizinhos vivos morre de solidão.
	Qualquer célula viva com mais de três vizinhos vivos morre de superpopulação.
	Qualquer célula morta com exatamente três vizinhos vivos se torna uma célula viva.
	Qualquer célula com dois vizinhos vivos continua no mesmo estado para a próxima
	geração.*/
	private static boolean validaRegraUm(int indice, int[]tab) {
		boolean validacao = (
				tab[indice] == 1 && 
				(tab[indice-1] == 0 && tab[indice+1] == 0 ) || 
				(tab[indice-1] == 0 && tab[indice+6] == 0 ) || 
				(tab[indice+1] == 0 && tab[indice+6] == 0 )
				);
		return validacao;
	}
	private static boolean validaRegraDois(int indice,int []tab) {
		boolean validacao = (
				tab[indice]   == 1 &&
				tab[indice-6] == 1 && 
				tab[indice-1] == 1 &&
				tab[indice+1] == 1 &&
				tab[indice+6] == 1
				);
		return validacao;
	}
	private static boolean validaRegraTres(int indice, int []tab) {
		boolean validacao = (
				tab[indice] == 0 &&
				(
				(tab[indice-6]== 0 && tab[indice-1] == 1 && tab[indice+1] == 1 && tab[indice+6] == 1) ||
				(tab[indice-6]== 1 && tab[indice-1] == 0 && tab[indice+1] == 1 && tab[indice+6] == 1) ||
				(tab[indice-6]== 1 && tab[indice-1] == 1 && tab[indice+1] == 0 && tab[indice+6] == 1) ||
				(tab[indice-6]== 1 && tab[indice-1] == 1 && tab[indice+1] == 1 && tab[indice+6] == 0) 
				)
				);
		return validacao;
	}
	private static void validaCelula(int []tab) {
		for(int i = 0; i < tab.length ; i++) {
			if(i < 6) {
				if(i == 0) {
					if(tab[i+1] == 0 || tab[i+6] == 0) {
						tab[i] = 0;
					}
				}else if(validaRegraUm(i,tab)) {
					tab[i] = 0;
				}
			}else if(i > 5 && i < 30 ) {
				if(validaRegraUm(i,tab)) {
					
				}else if(validaRegraDois(i, tab)) {
					
				}else if(validaRegraTres(i, tab)) {
					
				}
			}
		}
	}
	
	private static void geraValorCelula(int []tab) {
		int min = 0;
		int max = 1;
		for(int i = 0 ; i < tab.length ; i++) {
			tab[i] = (int)Math.floor(Math.random()*(max-min+1)+min);
		}
	}
	
	private static void imprimeTabuleiro(int []tab) {
		for(int i = 0; i < tab.length ; i++) {
			if( i%6 == 0 ) {
				System.out.printf("\n");
			}
				System.out.printf(" "+tab[i]+" ");
		}
		System.out.printf("\n");
	}
	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		int continuar = 0;
		
		//vetor
		System.out.println("Jogo iniciado! - VETOR");
		int [] tabVet = new int[36];
		for(int i = 0 ; i < tabVet.length ; i++) {
			tabVet[i] = 0;
		}
		while(continuar == 0) {
			System.out.println("Geração anterior!");
			imprimeTabuleiro(tabVet);
			geraValorCelula(tabVet);
			validaCelula(tabVet);
			System.out.println("Geração atual!");
			imprimeTabuleiro(tabVet);
			System.out.println("0 - Continuar Jogo\n1 - Finalizar jogo");
			continuar = ler.nextInt();
		}
		
		//matriz
		continuar = 0;
		int [][]tab = new int[6][6];
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0; j < 6 ; j++) {
				tab[i][j] = 0;
			}
		}
		System.out.println("Jogo iniciado - MATRIZ!");
		while(continuar == 0) {
			System.out.println("Geração anterior!");
			imprimeTabuleiro(tab);
			geraValorCelula(tab);
			validaCelula(tab);
			System.out.println("Geração atual!");
			imprimeTabuleiro(tab);
			System.out.println("0 - Continuar Jogo\n1 - Finalizar jogo");
			continuar = ler.nextInt();
		}
	}

}
