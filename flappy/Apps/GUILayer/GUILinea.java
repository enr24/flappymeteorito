package GUILayer;

import org.jfree.chart.ChartPanel;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GUILinea extends ApplicationFrame {

   public GUILinea( String applicationTitle , String chartTitle, ArrayList<Double> valores ) {
      super(applicationTitle);
      
      JFreeChart lineChart = ChartFactory.createLineChart(		//Creacion de un objeto de linea
         chartTitle,
         "Agujas",						//Nombre para X
         "Aciertos",				//Nombre para Y
         createDataset(valores), 	//Recibe Arreglo
         PlotOrientation.VERTICAL,
         true,	//Legend
         true,	//ToolTip
         false);//Urls
      
         
      ChartPanel chartPanel = new ChartPanel( lineChart );	//Crea el frame
      chartPanel.setPreferredSize( new java.awt.Dimension( 1280 , 720 ) );	//Tamaño preferido
      setContentPane( chartPanel );	//Agregar contenido
   }

   private DefaultCategoryDataset createDataset(ArrayList<Double> valores ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );	//Objeto que acepta el LineChart
      
      for(int i=0;i<valores.size();i++){									//Ciclo para todos los valores del arreglo
    	  dataset.addValue(valores.get(i),"Velocidad",String.valueOf(i));	//Se Agrega al set de datos
      }
      return dataset;
   }
   
   
}