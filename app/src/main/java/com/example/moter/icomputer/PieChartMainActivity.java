package com.example.moter.icomputer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.widget.LinearLayout;

import org.achartengine.CharFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class PieChartMainActivity extends AppCompatActivity {

    int [] pieChartValues ={32,18,31,34,18,33,4,44,67};
    public static final String TYPE = "type";
    private static int [] COLORS = new int[]{Color.BLUE,Color.CYAN,Color.DKGRAY,Color.GREEN,Color.MAGENTA,Color.RED,Color.WHITE,Color.YELLOW,Color.LTGRAY}
    String [] mSeriesTitle = new String [] {"DB","Computer Architecture","Data communication & networking","O/S","Logic Circuit","Programming","Software Engineering","Data Structure & algorithm", "Subject Pedagogy"};
    private  CategorySeries mSeries = new CategorySeries("문항수");
    private  DefaultRenderer mRenderer = new DefaultRenderer();
    private  GraphicalView mCharView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart_main);
        mRenderer.setApplyBackgroundColor(true);
        mRenderer.setBackgroundColor(Color.argb(100,50,50,50));
        mRenderer.setCharTitleTextSize(20);
        mRenderer.estLabelsTextSize(30);
        mRenderer.setLegendTextSize(30);
        mRenderer.setMargins(new int[]{20,30,15,2});
        mRenderer.setZoomButtonVisible(true);
        mRenderer.setStartAngle(90);

            if(mChartView == null)
            {
                LinearLayout layout = (LinearLayout) findViewById(R.id.char_pie);
                mCharetView = ChartFactory.getPieChartView(this, mSeries, mRenderer);
                mRenderer.setClickEnabled(true);
                mRenderer.setSelectableBuffer(10);
                layout.addView(mChartView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT));

            } else {
                mChartView.repaint();
            }
            public void fillPieChart() {
                for(int i=0; i<pieChartValues.length;i++){
                    mSeries.add(mSeriesTitle[i]+"_"+(String.valueOf(pieChartValues[i])),pieChartValues[i]);
                    SimpleSeriesRenderer renderer =new SimpleSeriesRenderer();
                    renderer.addSeriesRenderer(renderer);

                    if(mChartView !=null)
                        mChartView.repaint();


    }
    }
}
