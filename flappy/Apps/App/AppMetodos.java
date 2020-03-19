package App;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AppMetodos {
	static ArrayList<Integer> MCx;
	static ArrayList<Long> MNx;
	static Random random = new Random();
	static int opcion;
	
	public static void main(String[] args) {
		MCx = new ArrayList<Integer>();
		MNx = new ArrayList<Long>();
		LeerDatos();
		System.out.println("Fin");
		
		
	}
	private static void LeerDatos() {
		System.out.println("Opcion 1: Metodo de Medios Cuadrados");
		System.out.println("Opcion 2: Metodo de Newmann");
		System.out.println("Opcion a elegir: ");
		opcion=LeerEntero(1);
		if(opcion==1) {
			OpcionMoA();
			if(opcion==1) {
				System.out.println("Ingrese Semilla de Maximo 4 digitos: ");
				MMC(LeerEntero(4));
				}
			else
				MMC();
		} else if(opcion==2) {
			OpcionMoA();
			if(opcion==1) {
				System.out.println("Ingrese Semilla de Maximo 10 digitos: ");
				MN(LeerLong(10));
				}
			else
				MN();
			
		}
	}
	

	private static void MN(Long Semilla) {
		if(MNx.contains(Semilla)||Semilla==0)
			return;
		else {
			MNx.add(Semilla);
			System.out.println("Semilla: " +Semilla);
			}
		Semilla= Semilla*Semilla;
		String semilla = String.valueOf(Semilla);
		if(semilla.length() <5) 
			for(int i=semilla.length();i<5;i++) 
				semilla= "0"+semilla;
		
		if(semilla.length()%2==1)
				semilla= "0"+semilla;
		
		int medio=semilla.length()/2;
		Semilla=Long.valueOf((String) semilla.subSequence(medio-2, medio+3));
		
	
		MN(Semilla);
		
		
	}
	
	private static void MN() {
		MN(random.nextLong() % (9999999999l - 1) + 1);
	}
	
	
	
	private static void MMC() {
		 MMC(random.nextInt(9999));
	}
	
	private static void MMC(int Semilla) {
		if(MCx.contains(Semilla)||Semilla==0)
			return;
		else {
			MCx.add(Semilla);
			System.out.println("Semilla: " + Semilla);
			}
		
		Semilla=(int) Math.pow(Semilla, 2);
		String semilla = String.valueOf(Semilla);
		if(semilla.length() <8) 
			for(int i=semilla.length();i<8;i++) 
				semilla= "0"+semilla;
		int medio=semilla.length()/2;
		Semilla=Integer.valueOf((String) semilla.subSequence(medio-2, medio+2));
		MMC(Semilla);
	}

	
	private static void OpcionMoA() {
		System.out.println("Opcion 1: Ingresar la Semilla Manual");
		System.out.println("Opcion 2: Generar la Semilla Automatica");
		System.out.println("Opcion a elegir: ");
		opcion=LeerEntero(1);
	}
	private static int LeerEntero(int i) {
		int Valor=0;
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.print("Ingrese valor de " + 1 + " Digito/s: ");
				Valor=teclado.nextInt();
			} while(String.valueOf(Valor).length()>i) ;
		return Valor;
	}
	private static Long LeerLong(int i) {
		long Valor=0;
		Scanner teclado = new Scanner(System.in);
		do {
				System.out.print("Ingrese valor de " + 1 + " Digito/s: ");
				Valor=teclado.nextLong();
			} while(String.valueOf(Valor).length()>i) ;
		return Valor;
	}
}
