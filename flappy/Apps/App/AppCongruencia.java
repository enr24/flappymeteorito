package App;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterMessageFromOperator;

public class AppCongruencia {
	static Scanner teclado;
	static ArrayList<Integer> MCx;
	static int x,a,c,m;
	static Random random = new Random();
	
	public static void main(String[] args) {
		PedirDatos();
		EjecutarM();
	}

	private static void EjecutarM() {
		MCx = new ArrayList<Integer>();
		System.out.printf("%12s","N");
		System.out.printf("%12s","X0");
		System.out.printf("%20s","AXn+c");
		System.out.printf("%20s","(AXn+c)/m");
		System.out.printf("%12s","Xnm");
		System.out.println();
		int n=0;
		do{
			MCx.add(x);
			int axc=(a*x)+c;
			System.out.printf("%12d",n);
			System.out.printf("%12d",x);
			System.out.printf("%20d",axc);
			System.out.printf("%20s",axc +"/"+m);
			x=((a*x)+c)%m;
			System.out.printf("%12d",x);
			System.out.println();
			n++;
		} while(!MCx.contains(x));
		System.out.printf("%12d",n);
		System.out.printf("%12d",x);
		
	}

	private static void PedirDatos() {
	 teclado = new Scanner(System.in);
	 int op;
	 int k;
		System.out.println("Opcion 1: X0 Manual");
		System.out.println("Opcion 2: x0 Automatico");
		System.out.print("Ingrese Opcion: ");
		op=teclado.nextInt();
		switch(op){
		case 1:
			System.out.print("Ingrese X0: ");
			x=teclado.nextInt();
		break;
		case 2:
			x=random.nextInt(99999);
			System.out.println("Valor Generado: " + x);
			break;
			default:
				System.exit(0);
				break;
		}
		do{
				System.out.print("Ingrese valor k: ");
				k=teclado.nextInt();
				if(k>1){
					a=2*k+1;
					if(a%2==1 && a%3!=0 && a%5!=0)
						break;
				}
				
		} while(true);
		
		do{
				System.out.print("Ingrese valor c: ");
				c=teclado.nextInt();
				if(c%2==1 && c%8==5)
					break;
		} while(true);
		
		
		
		do{
				System.out.print("Ingrese valor m: ");
				m=teclado.nextInt();
				int contador=0;
				boolean primo=false;
				for(int i=1;i<=m;i++)
					if(m%i==0)
						contador++;
				if(contador==2)
					primo=true;
				if(primo)
					if(m<=Math.pow(2, 15))
					break;
		} while(true);
		
	}

}
