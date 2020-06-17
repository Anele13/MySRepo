package ejemplo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

public class Ejemplo {
	
	 public static void main(String[] args) {
 		List<Double> frameList =  new ArrayList<Double>();
	 	for (int i = 0; i < 100; i++) {
	 		NormalDistribution cosa = new NormalDistribution();	
			frameList.add(cosa.sample());
		}
	 	//Double[] array = frameList.toArray(new Double[frameList.size()]);
	 	double[] arr = frameList.stream().mapToDouble(Double::doubleValue).toArray();
	 	
	 	//Media
	 	Median media = new Median();
	 	System.out.println("Media:");
	 	System.out.println(media.evaluate(arr));
	 	
	 	//Desvio estandar
	 	StandardDeviation std = new StandardDeviation();
	 	System.out.println("Desvio:");
	 	System.out.println(std.evaluate(arr));
	 	
	 	//Varianza
	 	Variance var = new Variance();
	 	System.out.println("Varianza");
	 	System.out.println(var.evaluate(arr));
	 	
	 	//Grafico
	 	histogramChart(frameList, "Grafico Normal");
	 }
	 	 
	 public static void histogramChart(List<Double> listIn, String listName) {

		  double tabIn[] = new double[listIn.size()];
		  for (int i = 0; i < listIn.size(); i++) {
		    tabIn[i] = listIn.get(i);
		  }

		  // Creacion de datasets
		  HistogramDataset dataset = new HistogramDataset();
		  dataset.setType(HistogramType.RELATIVE_FREQUENCY);
		  dataset.addSeries(listName, tabIn, 5);

		  // Creacion de histograma
		  JFreeChart chart = ChartFactory.createHistogram("", null, null, dataset, PlotOrientation.VERTICAL, true, true, false);
		  ChartFrame frame = new ChartFrame("Espacio de datos", chart);
		  frame.pack();
		  frame.setVisible(true);
		}
}

