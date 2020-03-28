import java.awt.Font;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Created by IntelliJ IDEA.
 * User: YANG
 */
public class ProduceChart {
    /**
     * 生成扇形统计图
     *
     */
    public void ProduceChartC(String[][] GraphList,int[][] ListCount){
        String[] list = new String[]{"college","place","ID","timeM","timeD","situation"};
        Font font = new Font("宋体", Font.BOLD, 20);

        try {
            for (int j = 0; j < 6; j++) {
                DefaultPieDataset dataset = new DefaultPieDataset();
                for (int i = 0; i < GraphList[0].length; i++) {
                    if (GraphList[j][i]!=null){
                        double count = ListCount[j][i];
                        String Gcount = GraphList[j][i]+ListCount[j][i];
                        dataset.setValue(Gcount,count);
                    }
                }
                //创建图
                JFreeChart chart = ChartFactory.createPieChart(
                        list[j], // chart title
                        dataset, // data
                        true, // include legend
                        true,
                        false);
                int width = 1000;
                int height = 800;

                //设置字体
                chart.getTitle().setFont(font);
                chart.getLegend().setItemFont(font);
                PiePlot piePlot = (PiePlot) chart.getPlot();
                piePlot.setLabelFont(font);
                chart.getLegend().setItemFont(font);
                // 改样式
                chart.setTextAntiAlias(true);
                chart.setBackgroundPaint(ChartColor.WHITE);
                piePlot.setBackgroundPaint(ChartColor.WHITE);
                // 关闭片区外廓
                piePlot.setSectionOutlinesVisible(false);
                // 生成jpeg
                String pathname = "chart//"+list[j]+".jpeg";
                File pieChart = new File(pathname);
                ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 生成柱统计图
     *
     */
    public void ProduceChartC2(String[][] GraphList,int[][] ListCount){
        String[] list = new String[]{"college","place","ID","timeM","timeD","situation"};
        Font font = new Font("宋体", Font.BOLD, 20);

        try {
            for (int j = 0; j < 6; j++) {

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                for (int i = 0; i < GraphList[0].length; i++) {
                    if (GraphList[j][i]!=null){
                        double count = ListCount[j][i];
                        String str = GraphList[j][i]+ListCount[j][i];
                        dataset.addValue(count,str,list[j]);
                    }
                }
                //创建图
                JFreeChart chart = ChartFactory.createBarChart(
                        list[j],    //标题
                        "x",    //x轴名称
                        "y",    //y轴名称
                        dataset,//数据集
                        PlotOrientation.VERTICAL,//使用垂直柱状图
                        true,//是否使用legend
                        false,//是否使用tooltip
                        false);   //是否使用url


                int width = 1000;
                int height = 800;

                //设置字体
                chart.getTitle().setFont(font);
                chart.getLegend().setItemFont(font);

                chart.getLegend().setItemFont(font);
                // 改样式
                chart.setTextAntiAlias(false);
                chart.setBackgroundPaint(ChartColor.WHITE);

                // 生成jpeg
                String pathname = "chart//"+list[j]+"1.jpeg";
                File pieChart = new File(pathname);
                ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
                // 生成png
                String pathname2 = "chart//"+list[j]+"1.png";
                File pieChart2 = new File(pathname2);
                ChartUtilities.saveChartAsPNG( pieChart2, chart , width , height );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
