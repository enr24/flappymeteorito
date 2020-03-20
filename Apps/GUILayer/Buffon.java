package GUILayer;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import Componentes.JpLienzo;

public class Buffon extends JFrame {
	private JpLienzo Lienzo;
	public Buffon() {
		super("Buffon");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initComponents();
	}

	private void initComponents() {
		Lienzo = new JpLienzo();
		Lienzo.setBackground(Color.LIGHT_GRAY);
		Agrega(5, 50, 275, 700, 275, Color.BLACK);
		add(Lienzo,BorderLayout.CENTER);
		
	}
	public void Agrega(int fig, int x1, int y1, int x2, int y2, Color color) {
		Lienzo.Guarda(fig,x1,y1,x2,y2,color);
	}
	
	
}
