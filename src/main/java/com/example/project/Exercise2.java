package com.example.project;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {

	public static void main(final String[] args) {

		Exercise2 obj = new Exercise2();
		Scanner sc = new Scanner(System.in);
		while (true) {

			int n = sc.nextInt(), suma;
			int a[] = new int[n];	

			for (int i = 0; i < a.length; i++) {
				n = sc.nextInt();
				a[i] = n;
			}

			suma = sc.nextInt();

			System.out.println(obj.esSubconjuntoSumaExt(a, suma));
		}
	}

	public boolean esSubconjuntoSumaExt(int a[], int suma) {
		ArrayList<Integer> setList ;
		setList = actualizarArreglo(a, suma);
		suma = actualizarSuma(setList, suma);
		a = convertirLista_Arreglo(setList);
		
		int n = a.length;
		return esSubconjuntoSumaExt(a, n, suma);

	}
	static boolean esSubconjuntoSumaExt(int set[],int n, int sum){
		// Caso base
		if (sum == 0)
			return true;
		if (n == 0)
			return false;
		
		//si el ultimo elemento excede la suma entonces se ignora
		if (set[n - 1] > sum)
			return esSubconjuntoSumaExt(set, n - 1, sum);
			
		//comprobar si existe un subconjunto que sume el objetivo incluyendo o excluyendo el ultimo elemento
		return esSubconjuntoSumaExt(set, n - 1, sum) || esSubconjuntoSumaExt(set, n - 1, sum - set[n - 1]);
	}
	public static ArrayList<Integer> actualizarArreglo(int a[],int suma) {
		ArrayList<Integer> nuevo = new ArrayList<>();
		for(int i = 0;i < a.length - 1;i++) {
			if( (a[i] % 7 == 0) && (a[i + 1]==1)){
				continue;
			}
			nuevo.add(a[i]);
	
		}
		nuevo.add(a[a.length - 1]);
		return nuevo;
		
	}
	public static int actualizarSuma(ArrayList<Integer> a,int suma) {
		int sumaNuevo = suma;
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i) % 7 == 0) {
				sumaNuevo -= a.get(i);
				a.remove(i);
			}
		}
		return sumaNuevo;
	}
	public static int[] convertirLista_Arreglo(ArrayList<Integer> list) {
		int[] a = new int [list.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = list.get(i);
		}
		return a;
	}

}