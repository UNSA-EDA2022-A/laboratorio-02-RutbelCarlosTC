package com.example.project;

import java.util.Scanner;

public class Exercise1 {

	public static void main(final String[] args) {

		Exercise1 obj = new Exercise1();
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			System.out.println(obj.esCuadradoPerfecto(n));			
		}
		
	}
	public boolean esCuadradoPerfecto(int numero) {
		if(numero <= 0)//si es un numero negativo o cero retorna falso
			return false;
		else{
			int i = 1; //inicializa variable iterativa para la recursion
			return esCuadradoPerfecto(numero, i);
		}
	}
	//recursivo
	public boolean esCuadradoPerfecto(int num,int i){
		//caso base si encuentra un i que al elevarlo al cuadrado de el numero
		//inicial(N)entonces N es cuadrado perfecto
		if(i * i == num)
			return true;
		//caso base
		//si el numero raiz (i) a buscar no es exacto y su potencia excede al numero inicial 
		//entonces N no es cuadrado perfecto
		if(i * i > num)
			return false;

		else{// de lo contrario se hace la llamada recursiva al siguiente i
			return esCuadradoPerfecto(num,i + 1);
		}

	}
	
}
