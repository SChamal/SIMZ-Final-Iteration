/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simz1;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static simz1.LoginFrame1.mhp;
/**
 *
 * @author Janith
 */
public class StackedBarChart extends ApplicationFrame{
    
        private static final long serialVersionUID = 1L; 
        DBOperations dbOps = new DBOperations();
        public String d1=dataset(7),d2=dataset(6),d3=dataset(5),d4=dataset(4),d5=dataset(3),d6=dataset(2),d7=dataset(1);
        public int se1=0,se2=0,se3=0,se4=0,se5=0,se6=0,se7=0,cke1=0,cke2=0,cke3=0,cke4=0,cke5=0,cke6=0,cke7=0,bi1=0,bi2=0,bi3=0,bi4=0,bi5=0,bi6=0,bi7=0,
            dr1=0,dr2=0,dr3=0,dr4=0,dr5=0,dr6=0,dr7=0,si1=0,si2=0,si3=0,si4=0,si5=0,si6=0,si7=0;
        
    public StackedBarChart(String s)   
    {   
        super(s);
        initialize();
        JPanel jpanel = createDemoPanel(); 
        mhp.chartPanel.removeAll();
        mhp.chartPanel.add(jpanel);
        /*jpanel.setPreferredSize(new Dimension(500, 270));   
        setContentPane(jpanel); */
        
    }  
    public void initialize(){
        try{
            ResultSet rs =dbOps.getGraphData(dataset(7));
            while(rs.next()){
                
                d1 = rs.getString(1);
                se1 = rs.getInt(2);
                cke1 = rs.getInt(3);
                bi1 = rs.getInt(4);
                dr1 = rs.getInt(5);
                si1 = rs.getInt(6);
            }
               
            ResultSet rs2 =dbOps.getGraphData(dataset(6));
            while(rs2.next()){
            
                d2 = rs2.getString(1);
                se2 = rs2.getInt(2);
                cke2 = rs2.getInt(3);
                bi2 = rs2.getInt(4);
                dr2 = rs2.getInt(5);
                si2 = rs2.getInt(6);
            }
            
            ResultSet rs3 =dbOps.getGraphData(dataset(5));
            while(rs3.next()){
            
                d3 = rs3.getString(1);
                se3 = rs3.getInt(2);
                cke3 = rs3.getInt(3);
                bi3 = rs3.getInt(4);
                dr3 = rs3.getInt(5);
                si3 = rs3.getInt(6);
            }
            
            ResultSet rs4 =dbOps.getGraphData(dataset(4));
            while(rs4.next()){
                
            d4 = rs4.getString(1);
            se4 = rs4.getInt(2);
            cke4 = rs4.getInt(3);
            bi4 = rs4.getInt(4);
            dr4 = rs4.getInt(5);
            si4 = rs4.getInt(6);
            }
            
            ResultSet rs5 =dbOps.getGraphData(dataset(3));
            while(rs5.next()){
                
                d5 = rs5.getString(1);
                se5 = rs5.getInt(2);
                cke5 = rs5.getInt(3);
                bi5 = rs5.getInt(4);
                dr5 = rs5.getInt(5);
                si5 = rs5.getInt(6);
            }
            
            ResultSet rs6 =dbOps.getGraphData(dataset(2));
            while(rs6.next()){
                
                d6 = rs6.getString(1);
                se6 = rs6.getInt(2);
                cke6 = rs6.getInt(3);
                bi6 = rs6.getInt(4);
                dr6 = rs6.getInt(5);
                si6 = rs6.getInt(6);
            }
            
            ResultSet rs7 =dbOps.getGraphData(dataset(1));
            while(rs7.next()){
                
                d7 = rs7.getString(1);
                se7 = rs7.getInt(2);
                cke7 = rs7.getInt(3);
                bi7 = rs7.getInt(4);
                dr7 = rs7.getInt(5);
                si7 = rs7.getInt(6);
            }
            
        }catch (SQLException e){
        
        }
    }
        private CategoryDataset createDataset(){ 
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();   

        defaultcategorydataset.addValue(se1, "Shorteats", d1);   
        defaultcategorydataset.addValue(cke1, "Cake", d1);   
        defaultcategorydataset.addValue(bi1, "Bread Item", d1);   
        defaultcategorydataset.addValue(dr1, "Drinks",d1);   
        defaultcategorydataset.addValue(si1, "Sweet Items", d1);   

        defaultcategorydataset.addValue(se2, "Shorteats", d2);   
        defaultcategorydataset.addValue(cke2, "Cake", d2);   
        defaultcategorydataset.addValue(bi2, "Bread Item", d2);   
        defaultcategorydataset.addValue(dr2, "Drinks",d2);   
        defaultcategorydataset.addValue(si2, "Sweet Items", d2);
        
        defaultcategorydataset.addValue(se3, "Shorteats", d3);   
        defaultcategorydataset.addValue(cke3, "Cake", d3);   
        defaultcategorydataset.addValue(bi3, "Bread Item", d3);   
        defaultcategorydataset.addValue(dr3, "Drinks",d3);   
        defaultcategorydataset.addValue(si3, "Sweet Items", d3);
        
        defaultcategorydataset.addValue(se4, "Shorteats", d4);   
        defaultcategorydataset.addValue(cke4, "Cake", d4);   
        defaultcategorydataset.addValue(bi4, "Bread Item", d4);   
        defaultcategorydataset.addValue(dr4, "Drinks",d4);   
        defaultcategorydataset.addValue(si4, "Sweet Items", d4);
        
        defaultcategorydataset.addValue(se5, "Shorteats", d5);   
        defaultcategorydataset.addValue(cke5, "Cake", d5);   
        defaultcategorydataset.addValue(bi5, "Bread Item", d5);   
        defaultcategorydataset.addValue(dr5, "Drinks",d5);   
        defaultcategorydataset.addValue(si5, "Sweet Items", d5);
        
        defaultcategorydataset.addValue(se6, "Shorteats", d6);   
        defaultcategorydataset.addValue(cke6, "Cake", d6);   
        defaultcategorydataset.addValue(bi6, "Bread Item", d6);   
        defaultcategorydataset.addValue(dr6, "Drinks",d6);   
        defaultcategorydataset.addValue(si6, "Sweet Items", d6);
        
        defaultcategorydataset.addValue(se7, "Shorteats", d7);   
        defaultcategorydataset.addValue(cke7, "Cake", d7);   
        defaultcategorydataset.addValue(bi7, "Bread Item", d7);   
        defaultcategorydataset.addValue(dr7, "Drinks",d7);   
        defaultcategorydataset.addValue(si7, "Sweet Items", d7);        
        
        return defaultcategorydataset;   
    }   
   
    private JFreeChart createChart(CategoryDataset categorydataset)   
    {   
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Sales of last week", "Day", "Sales fo the day", categorydataset, PlotOrientation.VERTICAL, true, true, false);   
        jfreechart.setBackgroundPaint(Color.white);   
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();   
        categoryplot.setBackgroundPaint(Color.white);   
        categoryplot.setRangeGridlinePaint(Color.white);   
        StackedBarRenderer stackedbarrenderer = (StackedBarRenderer)categoryplot.getRenderer();   
        stackedbarrenderer.setDrawBarOutline(false);   
        stackedbarrenderer.setItemLabelsVisible(true);   
        stackedbarrenderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator());   
        return jfreechart;   
    }   
   
    public JPanel createDemoPanel()   
    {   
        JFreeChart jfreechart = createChart(createDataset());   
        return new ChartPanel(jfreechart);   
    }   
    
    public String dataset(int n){
       java.util.Date date = new java.util.Date();
       SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
       Calendar c = Calendar.getInstance(); 
       c.setTime(date);
       c.add(Calendar.DAY_OF_MONTH,-n);
       date = c.getTime();
       String dte =sdf2.format(c.getTime());
       return dte;
    }
    
    public void ShorteatsGraph(){
        DefaultCategoryDataset sedata = new DefaultCategoryDataset();
        sedata.setValue(se1, "sales", d1);
        sedata.setValue(se2, "sales", d2);
        sedata.setValue(se3, "sales", d3);
        sedata.setValue(se4, "sales", d4);
        sedata.setValue(se5, "sales", d5);
        sedata.setValue(se6, "sales", d6);
        sedata.setValue(se7, "sales", d7);
        
        JFreeChart chart1 = ChartFactory.createLineChart("Sales of Shorteats last week", "Date", "sales", sedata, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot c1 = chart1.getCategoryPlot();
        c1.setBackgroundPaint(Color.white); 
        c1.getRenderer().setSeriesPaint(0, Color.RED);
        //c1.setRangeGridlinePaint(Color.red);
        
        ChartPanel c1Panel = new ChartPanel(chart1);
        mhp.chartPanel.removeAll();
        mhp.chartPanel.add(c1Panel);
    }
    public void CakeGraph(){
        DefaultCategoryDataset ckedata = new DefaultCategoryDataset();
        ckedata.setValue(cke1, "sales", d1);
        ckedata.setValue(cke2, "sales", d2);
        ckedata.setValue(cke3, "sales", d3);
        ckedata.setValue(cke4, "sales", d4);
        ckedata.setValue(cke5, "sales", d5);
        ckedata.setValue(cke6, "sales", d6);
        ckedata.setValue(cke7, "sales", d7);
        
        JFreeChart chart2 = ChartFactory.createLineChart("Sales of Cakes last week", "Date", "sales", ckedata, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot c2 = chart2.getCategoryPlot();
        c2.setBackgroundPaint(Color.white); 
        c2.getRenderer().setSeriesPaint(0, Color.BLUE);
        //c2.setRangeGridlinePaint(Color.BLUE);
        
        ChartPanel c2Panel = new ChartPanel(chart2);
        mhp.chartPanel.removeAll();
        mhp.chartPanel.add(c2Panel);
    }
    
    public void BreadGraph(){
        DefaultCategoryDataset bidata = new DefaultCategoryDataset();
        bidata.setValue(bi1, "sales", d1);
        bidata.setValue(bi2, "sales", d2);
        bidata.setValue(bi3, "sales", d3);
        bidata.setValue(bi4, "sales", d4);
        bidata.setValue(bi5, "sales", d5);
        bidata.setValue(bi6, "sales", d6);
        bidata.setValue(bi7, "sales", d7);
        
        JFreeChart chart3 = ChartFactory.createLineChart("Sales of Bread Items last week", "Date", "sales", bidata, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot c3 = chart3.getCategoryPlot();
        c3.setBackgroundPaint(Color.white); 
        c3.getRenderer().setSeriesPaint(0, Color.GREEN);
        //c3.setRangeGridlinePaint(Color.green);
        
        ChartPanel c3Panel = new ChartPanel(chart3);
        mhp.chartPanel.removeAll();
        mhp.chartPanel.add(c3Panel);
    }
    public void DrinksGraph(){
        DefaultCategoryDataset drdata = new DefaultCategoryDataset();
        drdata.setValue(dr1, "sales", d1);
        drdata.setValue(dr2, "sales", d2);
        drdata.setValue(dr3, "sales", d3);
        drdata.setValue(dr4, "sales", d4);
        drdata.setValue(dr5, "sales", d5);
        drdata.setValue(dr6, "sales", d6);
        drdata.setValue(dr7, "sales", d7);
        
        JFreeChart chart4 = ChartFactory.createLineChart("Sales of Drinks last week", "Date", "sales", drdata, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot c4 = chart4.getCategoryPlot();
        c4.setBackgroundPaint(Color.white); 
        c4.getRenderer().setSeriesPaint(0, Color.YELLOW);
        //c4.setRangeGridlinePaint(Color.yellow);
        
        ChartPanel c4Panel = new ChartPanel(chart4);
        mhp.chartPanel.removeAll();
        mhp.chartPanel.add(c4Panel);
    }
    
    public void SweetsGraph(){
        DefaultCategoryDataset sidata = new DefaultCategoryDataset();
        sidata.setValue(si1, "sales", d1);
        sidata.setValue(si2, "sales", d2);
        sidata.setValue(si3, "sales", d3);
        sidata.setValue(si4, "sales", d4);
        sidata.setValue(si5, "sales", d5);
        sidata.setValue(si6, "sales", d6);
        sidata.setValue(si7, "sales", d7);
        
        JFreeChart chart5 = ChartFactory.createLineChart("Sales of Sweet items last week", "Date", "sales", sidata, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot c5 = chart5.getCategoryPlot();
        c5.setBackgroundPaint(Color.white); 
        c5.getRenderer().setSeriesPaint(0, Color.PINK);
        //c5.setRangeGridlinePaint(Color.pink);
        
        ChartPanel c5Panel = new ChartPanel(chart5);
        mhp.chartPanel.removeAll();
        mhp.chartPanel.add(c5Panel);
    }
    public static void main(String args[]){   
  
    }
}

