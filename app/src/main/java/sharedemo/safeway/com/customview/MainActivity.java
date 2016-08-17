package sharedemo.safeway.com.customview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sharedemo.safeway.com.customview.widget.PercentRoundView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PercentRoundView percentRoundView = (PercentRoundView) findViewById(R.id.percentRoundView);
        percentRoundView.setPercents(new float[]{30,10,5,10,30,15},new int[]{Color.BLUE,Color.CYAN,Color.DKGRAY,Color.GREEN,Color.MAGENTA,Color.RED});
        percentRoundView.setStartAngel(-90);
        percentRoundView.setChangeR(50);
        percentRoundView.setMaxR(500);
        percentRoundView.setMinR(100);
        percentRoundView.setLeftPostion(50);
        percentRoundView.setTopPostion(50);
        percentRoundView.postInvalidate();
//        CircleProcess process = (CircleProcess) findViewById(R.id.process);
//        CustomCircleProcess process2 = (CustomCircleProcess) findViewById(R.id.custom);
//         new Thread(process).start();
//        new Thread(process2).start();
    }
}
