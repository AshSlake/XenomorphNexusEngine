package principal;

import java.util.ArrayList;
import java.util.Scanner;

import xenomorfo.Xenomorfo;

public class Main {

	public static void main(String[] args) {

		new JanelaProgram().setVisible(true);
	
	// instancia das classes
	Scanner scan = new Scanner(System.in);
    ArrayList <Xenomorfo> xenomorfos = new ArrayList<>();

	// definição dos xenomorfos iniciais
	System.out.println("Quantos xenomorfos você ira começar a simulação ?");
	int numberXeno = scan.nextInt();
	String xenoPrincipal[] = new String[numberXeno];

	if(numberXeno > 1)
	{
		System.out.println("Esses xenomorfos Vão ser seus mais velhos de uma possivel colmeia então nomeie eles!");
		for (int i = 0; i < numberXeno; i++) {
			xenoPrincipal[i] = scan.next();
		}
	}else
	{
		System.out.println("Esse xenomorfo Vai ser seus mais velho de uma possivel colmeia então nomeie ele!");
		xenoPrincipal[0] = scan.next();
	}
	scan.close();

	for (int i = 0 ; i < numberXeno ; i++) {
		Xenomorfo xenomorfo = new Xenomorfo(i, xenoPrincipal[i], null, 0, 0, 0, 0, 0, 0, 0, 0, 0,false);
		xenomorfos.add(xenomorfo);
	}

	// saida dos nomes dos xenomorfos iniciais
	System.out.println();

	for(Xenomorfo xeno : xenomorfos) {
		System.out.println(xeno.getNome());
	}
}

}
