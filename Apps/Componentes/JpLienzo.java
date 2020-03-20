package Componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import Utilerias.Figura;

public class JpLienzo extends JPanel implements MouseListener, KeyListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	private int Fig,x1,y1,x2,y2,Ancho,Alto;
	private Color color;
	private ArrayList<Figura> Contenido;
	
	public JpLienzo(){
		super();
		Contenido = new ArrayList<Figura>();
		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		
		ValoresIniciales();
		repaint();
	}
	
	
	public void ValoresIniciales() {
		Fig=5;
		x1=0;
		x2=0;
		y1=0;
		y2=0;
		Ancho=0;
		Alto=0;
		color=Color.BLACK;
	}
	
	public void Guarda(int fig, int xi, int yi, int xf, int yf, Color Color) {
		Fig=fig;
		x1=xi;
		y1=yi;
		x2=xf;
		y2=yf;
		color=Color;
		Contenido.add(new Figura(Fig,x1,y1,x2,y2,Ancho,Alto,color));
	}
	

	public void PintaTodo(Graphics g){
		Figura f;
		for(int i=0;i<Contenido.size();i++){
			f = Contenido.get(i);
			g.setColor(f.getColor());
				//Cuando la figura no va rellena
				switch(f.getFig()){
				case 1: //Cuadrado
				case 2: //Rectangulo
					g.drawRect(f.getX1(), f.getY1(), f.getAncho(), f.getAlto());
					break;
				case 3: //Circulo
				case 4: //Ovalo
					g.drawOval(f.getX1(), f.getY1(), f.getAncho(), f.getAlto());
					break;
				case 5: //Linea
					g.drawLine(f.getX1(), f.getY1(),f.getX2(), f.getY2());
					break;
				}
			}
			
	}

	
	@Override
	public void mouseDragged(MouseEvent e){
	//	x2=e.getX();
	//	y2=e.getY();
	//	repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	//	Contenido.add(new Figura(Fig,x1,y1,x2,y2,Ancho,Alto,color));
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		PintaTodo(g);
		Ancho=Math.abs(x2-x1);
		Alto=Math.abs(y2-y1);
		if(Fig==1 || Fig==3){
			Ancho=Ancho>Alto?Ancho:Alto;
			Alto=Ancho>Alto?Ancho:Alto;
		}
		
		g.setColor(color);
	
			switch(Fig){
			case 1://Cuadrado
			case 2://Rectangulo
				g.drawRect(x1, y1, Ancho, Alto);
				break;
			case 3://Circulo
			case 4://Ovalo
				g.drawOval(x1, y1, Ancho, Alto);
				break;
			case 5://Linea
				g.drawLine(x1, y1, x2, y2);
				break;
		}
		
		
		
	}
	
	public int getFig() {
		return Fig;
	}


	public void setFig(int fig) {
		Fig = fig;
	}


	

	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public ArrayList<Figura> getContenido() {
		return Contenido;
	}


	public void setContenido(ArrayList<Figura> contenido) {
		Contenido = contenido;
	}
	
	

}
