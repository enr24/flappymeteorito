package App;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.jfree.ui.RefineryUtilities;

import GUILayer.Buffon;
import Grafica.GUILinea;

public class AppBuffon {
	static int NoAgujas,A;
	static int x1,x2,y1,y2;
	static Random random = new Random();
	static Buffon main;
	static double Pi,P,NoAg=0;
	static ArrayList<Double> Valores;
	
	public static void main(String[] args) {
		
		Valores = new ArrayList<Double>();
		 main = new Buffon(); 
		//NoAgujas=50;
		 PedirDatos();
		Ejecutar();
		Pi();
		System.out.println("Numero de Aciertos: " + A);
		System.out.println("Pi= " + Pi);
		Grafica();
		main.setVisible(true);
		
		

	}
	
	private static void Grafica() {
			GUILinea chart = new GUILinea(
			         "Simulacion" , //Titulo App
			         "Grafica",		//Titulo Grafica
			         Valores); //Valores
			
			      chart.pack( ); //Acomoda el frame
			      RefineryUtilities.centerFrameOnScreen( chart ); //Acomoda el frame en el centro de la pantalla
			      chart.setVisible( true );
	}

	private static void Pi() {
		Pi=(2*NoAg)/(double)A;
	}

	private static void Ejecutar() {
		for(int i=0;i<NoAgujas;i++) {
			NoAg++;
			x1=random.nextInt(800);
			if(x1<0)
				x1*=-1;
			y1=random.nextInt(600);
			if(y1<0)
				y1*=-1;
			int D;
			do {
				//double angulo=GenerarAngulo();
			x2= x1 + ((int) (325*Math.cos(GenerarAngulo())));
			y2= y1 + ((int) (275*Math.sin(GenerarAngulo())));
			
			D=(int) (Math.sqrt((Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2) )));
			} while(D!=275);
			
			/*
			x1=527;
			y1=229;
			x2=501;
			y2=-45;
			*/
			
			/*
			System.out.println(x1);
			System.out.println(y1);
			System.out.println(x2);
			System.out.println(y2);
			*/
			
			double tempx=0,tempy=0;
			if (x1>=0 && x2>=0)
				tempx=Math.abs(x2-x1);
			else 
				tempx=Math.abs(x1)+Math.abs(x2);
			
			if (y1>=0 && y2>=0)
				tempy=Math.abs(y2-y1);
			else 
				tempy=Math.abs(y1)+Math.abs(y2);
	
				Color color=Color.blue;
				int xi,xf;
				double yi,yf;
				double incy = (tempy/tempx);;
				
				
				if(x1<x2) {
					xi=x1;
					xf=x2;
					
					yi=y1;
					yf=y2;
				} else  {
					xi=x2;
					xf=x1;

					yi=y2;
					yf=y1;
				}
				
				
				
				do {
					/*
					System.out.println("X= "+ xi);
					System.out.println("Y= " +yi);
					System.out.println();
					*/
					int ye=(int) yi;
					if(xi==50) {
						if(ye<=502 && ye>=47) {
							color=Color.red;
							A++;
							break;
						}	
					}
					if(xi>50 && xi<700) {
						if(ye>=46 && ye<=53|| ye<=280 && ye>=270 || ye<=502 && ye>=495) {
							color=Color.red;
							A++;
							break;
						}					
					}
					if(xi==700) {
						if(ye<=501 && ye>=50) {
							color=Color.red;
							A++;
							break;
						}	
					}
					
					
					if(yi<yf)
						yi+=incy;
					else
						yi-=incy;
					xi++;
				
		
				} while(xi<xf);
				Pi();
				Valores.add(Pi);
			main.Agrega(5, x1, y1, x2, y2, color);
			//<>
		}
		main.Agrega(2, 50, 50, 700, 500, Color.BLACK);
	}

	private static double GenerarAngulo() {
		double angulo = 0 + (random.nextDouble() * (360 - 0));
		return angulo;
	}

	private static int CrearPosicion(int i) {
		int n=random.nextInt(i);
		if(random.nextInt(10)>=5)
			n*=-1;
		return i+n;
		}
	
	
	private static void PedirDatos() {
		Scanner teclado =new Scanner(System.in);
		System.out.print("Ingrese Numero de Agujas: ");
		NoAgujas= teclado.nextInt();
		
	}

}
