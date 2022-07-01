package projetoGerenciaConsultas;

import java.util.Scanner;

/*
 *  Esta classe é um tipo de wrapper para a classe Scanner, 
 *  facilitando a leitura de dados do teclado. 
 * 
 * */

public class Console {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static int leInteiro(String msg) {
		System.out.println(msg);
		int i = teclado.nextInt();
		teclado.nextLine(); // consumo do Enter
		return i;
	}
	
	public static float leReal(String msg) {
		System.out.println(msg);
		float f = teclado.nextFloat();
		teclado.nextLine(); // consumo do Enter
		return f;
	}
	
	
	public static String leString() {
		return teclado.nextLine();
	}
	
	public static String leString (String msg) {
		String str = "";
		while (true) {
			System.out.println(msg);
			str = teclado.nextLine();
			
			if (str != null && !str.trim().equals("")) {
				return str.trim();
			} else {
				System.out.println("Querido usuário, digite o valor correto.");
			}
		}
	}
}
